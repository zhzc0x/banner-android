package com.github.zicheng.banner.transformer

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class FadePageTransformer: ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        if (position <= 0.0f) {
            page.translationX = -page.width * position
            page.alpha = 1 + position
        } else if (position <= 1.0f) {
            page.translationX = -page.width * position
            page.alpha = 1 - position
        }
    }

}