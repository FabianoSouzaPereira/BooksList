package com.fabianospdev.imageprocessing.converter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream

open class ImageCompressor {

    fun compressToBitmap(imagePath: String): Bitmap? {
        val bitmap = BitmapFactory.decodeFile(imagePath)
        return compressBitmap(bitmap)
    }

    private fun compressBitmap(bitmap: Bitmap?): Bitmap? {
        if (bitmap == null) return null

        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, outputStream)
        val compressedBytes = outputStream.toByteArray()

        return BitmapFactory.decodeByteArray(compressedBytes, 0, compressedBytes.size)
    }
}