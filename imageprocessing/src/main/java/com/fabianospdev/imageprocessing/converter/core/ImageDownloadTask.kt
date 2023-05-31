package com.fabianospdev.imageprocessing.converter.core

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import com.fabianospdev.imageprocessing.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.InputStream
import java.lang.ref.WeakReference
import java.net.HttpURLConnection
import java.net.URL

class ImageDownloadTask {

    fun downloadImage(context: Context, imageView: ImageView, url: String){
        return downloadImage2(context, imageView, url)
    }
            
    private fun downloadImage2(context: Context, imageView: ImageView, url: String) {
        val weakContext: WeakReference<Context> = WeakReference(context)
        val weakImageView: WeakReference<ImageView> = WeakReference(imageView)

        val scope = CoroutineScope(Dispatchers.Main)
        scope.launch {
            val errorBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.errorconvert)

            val bitmap: Bitmap? = try {
                val imageBitmap = scope.async(Dispatchers.IO) {
                    val urlConnection = URL(url).openConnection() as HttpURLConnection
                    urlConnection.doInput = true
                    urlConnection.connect()
                    val inputStream: InputStream = urlConnection.inputStream
                    BitmapFactory.decodeStream(inputStream)
                }
                imageBitmap.await()
            } catch (e: java.net.MalformedURLException) {
                errorBitmap
            } catch (e: Exception) {
                e.printStackTrace()
                errorBitmap
            }

            val contextWeak = weakContext.get()
            val imageViewWeak = weakImageView.get()
            if (bitmap != null && contextWeak != null && imageViewWeak != null) {
                imageViewWeak.setImageBitmap(bitmap)
            } else {
                // Trate o caso de erro aqui
            }
        }
    }
}