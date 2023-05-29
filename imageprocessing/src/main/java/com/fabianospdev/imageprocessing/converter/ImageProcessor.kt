@file:Suppress("KDocMissingDocumentation")

package com.fabianospdev.imageprocessing.converter

import android.graphics.Bitmap
import com.fabianospdev.imageprocessing.converter.imagescare.ImageCompressor

interface ImageProcessor {
    fun imageCompressor(image: String): Bitmap? {
        return ImageCompressor().compressToBitmap(image)
    }

    fun imageCompressor(image: ByteArray): Bitmap? {
        return ImageCompressor().compressToBitmap(image)
    }
}