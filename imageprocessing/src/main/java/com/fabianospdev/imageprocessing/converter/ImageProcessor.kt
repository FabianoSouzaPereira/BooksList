@file:Suppress("KDocMissingDocumentation")

package com.fabianospdev.imageprocessing.converter

import ImageCompressor
import android.content.Context
import android.graphics.Bitmap

interface ImageProcessor {
    fun imageCompressor(context: Context, image: Any): Bitmap? {
        return ImageCompressor().compressToBitmap(context = context, image = image)
    }
}