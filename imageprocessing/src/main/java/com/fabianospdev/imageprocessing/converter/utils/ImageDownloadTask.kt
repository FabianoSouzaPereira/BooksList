package com.fabianospdev.imageprocessing.converter.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class ImageDownloadTask(private val imageView: ImageView) :
    AsyncTask<String, Void, Bitmap>() {

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg urls: String): Bitmap? {
        val imageUrl = urls[0]

        return try {
            val url = URL(imageUrl)
            val connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val inputStream: InputStream = connection.inputStream
            BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onPostExecute(result: Bitmap?) {
        if (result != null) {
            imageView.setImageBitmap(result)
        } else {
            // Handle error case here
        }
    }
}