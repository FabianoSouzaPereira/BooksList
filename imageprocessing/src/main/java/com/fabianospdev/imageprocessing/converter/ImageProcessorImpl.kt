/* 
*  Implementation ImageProcessor to convert some images types to bitmap.
*  Between formats accessible are JPEG, JPG, PNG, SVG
*/

package com.fabianospdev.imageprocessing.converter

import android.content.Context
import android.graphics.Bitmap

class ImageProcessorImpl : ImageProcessor {
    override fun imageCompressor(context: Context, image: Any): Bitmap? {
        return super.imageCompressor(context,image)
    }
}