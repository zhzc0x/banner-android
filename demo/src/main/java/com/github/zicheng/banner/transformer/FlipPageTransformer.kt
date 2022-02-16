package com.github.zicheng.banner.transformer

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class FlipPageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        if (position <= 0.0f) {
            page.translationX = -page.width * position
            val rotation = ROTATION * position
            page.rotationY = rotation
            if (position > -0.5) {
                page.visibility = View.VISIBLE
            } else {
                page.visibility = View.INVISIBLE
            }
        } else if (position <= 1.0f) {
            page.translationX = -page.width * position
            val rotation = ROTATION * position
            page.rotationY = rotation
            if (position < 0.5) {
                page.visibility = View.VISIBLE
            } else {
                page.visibility = View.INVISIBLE
            }
        }
    }

    companion object {
        private const val ROTATION = 180.0f
    }
}