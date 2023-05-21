package com.fabianospdev.imageprocessing.converter

import android.graphics.Bitmap
import com.caverock.androidsvg.SVG
import java.io.File
import java.io.FileInputStream

class SVGConverter {
    fun convertToBitmap(svgFilePath: String): Bitmap? {
        val svg = loadSVGFromFile(svgFilePath)
        return convertSVGToBitmap(svg)
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