package com.github.zicheng.banner.transformer

import android.view.View
import androidx.viewpager2.widget.ViewPager2


class ZoomPageTransformer(private val minScale: Float = 0.8f, private val minAlpha: Float = 0.6f
) : ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        when {
            position < -1.0f -> {
                page.alpha = 0f
            }
            position <= 0.0f -> {
                val scale = minScale.coerceAtLeast(1 + position)
                val verticalMargin: Float = page.height * (1 - scale) / 2
                val horizontalMargin: Float = page.width * (1 - scale) / 2
                page.translationX = horizontalMargin - verticalMargin / 2
                page.scaleX = scale
                page.scaleY = scale
                page.alpha = minAlpha + (scale - minScale) / (1 - minScale) * (1 - minAlpha)
            }
            position <= 1.0f -> {
                val scale = minScale.coerceAtLeast(1 - position)
                val verticalMargin: Float = page.height * (1 - scale) / 2
                val horizontalMargin: Float = page.width * (1 - scale) / 2
                page.translationX = -horizontalMargin + verticalMargin / 2
                page.scaleX = scale
                page.scaleY = scale
                page.alpha = minAlpha + (scale - minScale) / (1 - minScale) * (1 - minAlpha)
            }
            else -> {
                page.alpha = 0f
            }
        }
    }
}