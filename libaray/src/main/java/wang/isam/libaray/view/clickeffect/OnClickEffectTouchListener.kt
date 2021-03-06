package wang.isam.libaray.view.clickeffect

import android.view.MotionEvent
import android.view.View
import wang.isam.libaray.view.clickeffect.impl.DefaultClickEffectScaleAnimate

class OnClickEffectTouchListener(var viewClickEffect: ViewClickEffect = DefaultClickEffectScaleAnimate()):
        View.OnTouchListener {
    override fun onTouch(v: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                viewClickEffect.onPressedEffect(v)
                v.isPressed = true
            }

            MotionEvent.ACTION_MOVE -> {
                val x = event.x
                val y = event.y
                val isInside = x > 0 && x < v.width && y > 0 && y < v.height
                if (v.isPressed != isInside) {
                    v.isPressed = isInside
                }
            }
            MotionEvent.ACTION_CANCEL -> {
                viewClickEffect.onUnPressedEffect(v)
                v.isPressed = false
            }
            MotionEvent.ACTION_UP -> {
                viewClickEffect.onUnPressedEffect(v)
                if (v.isPressed) {
                    v.performClick()
                    v.isPressed = false
                }
            }
        }
        return true
    }
}

/**
 * 设置点击效果
 * onClickEffect 默认为 DefaultClickEffectScaleAnimate 效果
 */
fun View.setOnClickEffect(onClickEffect: OnClickEffectTouchListener = OnClickEffectTouchListener()) {
    this.setOnTouchListener(onClickEffect)
}