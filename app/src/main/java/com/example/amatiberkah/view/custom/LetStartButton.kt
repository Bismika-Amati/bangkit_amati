package com.example.amatiberkah.view.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.amatiberkah.R

class LetStartButton: AppCompatButton {

    private lateinit var bgButton : Drawable
    private var txtColor: Int = 0

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background = bgButton

        setTextColor(txtColor)
        textSize = 10f
        gravity = Gravity.CENTER
        text = resources.getString(R.string.letstartbtn_available)
    }

    private fun init() {
        bgButton = ContextCompat.getDrawable(context, R.drawable.bg_letstart) as Drawable
        txtColor = ContextCompat.getColor(context, android.R.color.background_light)
    }
}