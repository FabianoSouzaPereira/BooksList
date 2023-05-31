@file:Suppress("KDocMissingDocumentation")

package com.fabianospdev.imageprocessing.converter.core

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView

interface ImageProcessor {
    fun imageCompressor(context: Context, image: Any): Bitmap? {
        return ImageCompressor().compressToBitmap(context = context, image = image)
    }
    
    fun imageDownloadTask(context: Context,imageView: ImageView, uri: String) {
        return ImageDownloadTask().downloadImage(context, imageView, uri)
    }
}