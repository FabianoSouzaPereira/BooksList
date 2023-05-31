package com.fabianospdev.imageprocessing.converter.core/*  
* This pack imagescare provide resources to work with images PNG, JPEG,JPG and SVG.
* 
* 
*/

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import com.caverock.androidsvg.SVG
import com.fabianospdev.imageprocessing.R
import java.io.ByteArrayOutputStream
import java.io.File

internal class ImageCompressor {
    fun compressToBitmap(context: Context, image: Any?): Bitmap? {
        return compressToBitmap2(context = context, image = image)
    }
    
    private fun compressToBitmap2(context: Context, image: Any?): Bitmap? {
        println("compressToBitmap2")
        return try {
            when (image) {
                is ByteArray -> {
                    val compressedBytes = extractByteArray(any = image)
                    BitmapFactory.decodeByteArray(compressedBytes, 0, compressedBytes!!.size)
                }
                is String -> {
                    val imagePath = extractImagePath(any = image)
                    BitmapFactory.decodeFile(imagePath)
                }
                is File -> {
                    val imageFile = extractImageFile(any = image)
                    BitmapFactory.decodeFile(imageFile)
                }
                is Bitmap -> {
                    val bitmap = extractBitmap(any = image)
                    val outputStream = ByteArrayOutputStream()
                    bitmap?.compress(Bitmap.CompressFormat.JPEG, 80, outputStream)
                    val compressedBytes = outputStream.toByteArray()
                    BitmapFactory.decodeByteArray(compressedBytes, 0, compressedBytes.size)
                }
                is SVG -> {
                    SVGConverter().convertToBitmap(context = context, image = image)
                }
                else -> {
                    println("Type is not supported!")
                    null
                }
            }
        } catch (e: Exception) {
            val errorBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.errorconvert)
            errorBitmap
        }
    }

    private fun extractBitmap(any: Any): Bitmap? {
        return when (any) {
            is BitmapDrawable -> any.bitmap
            is Bitmap -> any
            else -> null
        }
    }

    private fun extractImageFile(any: Any): String? {
        return if (any is File) any.path else null
    }

    private fun extractImagePath(any: Any): String? {
        return if (any is String) any else null
    }

    private fun extractByteArray(any: Any): ByteArray? {
        return if (any is ByteArray) any else null
    }
}