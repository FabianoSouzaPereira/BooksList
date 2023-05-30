import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import com.caverock.androidsvg.SVG
import com.fabianospdev.imageprocessing.R
import com.fabianospdev.imageprocessing.converter.imagescare.SVGConverter
import java.io.ByteArrayOutputStream
import java.io.File

class ImageCompressor {
    fun compressToBitmap(context: Context, image: Any?): Bitmap? {
        return try {
            when (image) {
                is ByteArray -> {
                    val compressedBytes = extractByteArray(image)
                    BitmapFactory.decodeByteArray(compressedBytes, 0, compressedBytes!!.size)
                }
                is String -> {
                    val imagePath = extractImagePath(image)
                    BitmapFactory.decodeFile(imagePath)
                }
                is File -> {
                    val imageFile = extractImageFile(image)
                    BitmapFactory.decodeFile(imageFile)
                }
                is Bitmap -> {
                    val bitmap = extractBitmap(image)
                    val outputStream = ByteArrayOutputStream()
                    bitmap?.compress(Bitmap.CompressFormat.JPEG, 80, outputStream)
                    val compressedBytes = outputStream.toByteArray()
                    BitmapFactory.decodeByteArray(compressedBytes, 0, compressedBytes.size)
                }
                is SVG -> {
                    SVGConverter().convertToBitmap(image)
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