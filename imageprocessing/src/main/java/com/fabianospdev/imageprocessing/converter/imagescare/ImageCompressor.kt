package com.fabianospdev.imageprocessing.converter.imagescare

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream
import java.io.File


open class ImageCompressor {
    fun compressToBitmap(image: ByteArray): Bitmap? {
        return BitmapFactory.decodeByteArray(image, 0, image.size)
    }
    fun compressToBitmap(imagePath: String? = null): Bitmap? {
        val bitmap = BitmapFactory.decodeFile(imagePath)
        return compressBitmap(bitmap)
    }
    
    fun compressToBitmap(imageFile: File? = null): Bitmap? {
        if (imageFile != null) {
            return BitmapFactory.decodeFile(imageFile.path)
        }
        return null
    }
    fun compressToBitmap(bitmap: Bitmap? = null): Bitmap? {
        if (bitmap != null){
            compressBitmap(bitmap)
        }
        return null
    }

    private fun compressBitmap(bitmap: Bitmap?): Bitmap? {
        if (bitmap == null) return null
        
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, outputStream)
        val compressedBytes = outputStream.toByteArray()

        return BitmapFactory.decodeByteArray(compressedBytes, 0, compressedBytes.size)
    }
}