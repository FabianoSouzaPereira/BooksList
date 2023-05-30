package com.fabianospdev.imageprocessing.converter.imagescare

import android.graphics.Bitmap
import com.caverock.androidsvg.SVG
import java.io.File
import java.io.FileInputStream

class SVGConverter {
    fun convertToBitmap(image: Any): Bitmap? {
        return anyToBitmap(image)
    }
    private fun anyToBitmap(svgImage: Any): Bitmap? {
        return when(svgImage){
            is String -> {
                val svg = loadSVGFromFile(svgImage)
                return convertSVGToBitmap(svg)
            }
            is SVG -> {
               return convertSVGToBitmap(svgImage)
            }
            else -> {
                println("Type is not supported!")
                null
            }
        }
    }

    private fun loadSVGFromFile(svgFilePath: String): SVG? {
        val file = File(svgFilePath)
        val inputStream = FileInputStream(file)
        return SVG.getFromInputStream(inputStream)
    }

    private fun convertSVGToBitmap(svg: SVG?): Bitmap? {
        if (svg == null) return null

        val bitmapWidth = svg.documentWidth.toInt()
        val bitmapHeight = svg.documentHeight.toInt()

        val bitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888)
        val canvas = android.graphics.Canvas(bitmap)
        svg.renderToCanvas(canvas)

        return bitmap
    }
}