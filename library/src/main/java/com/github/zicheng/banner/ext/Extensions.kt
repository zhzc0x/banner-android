package com.github.zicheng.banner.ext

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue

internal val displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics

internal val Float.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        displayMetrics
    )

internal val Int.dp
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        displayMetrics
    ).toInt()

