package wang.isam.libaray.view.clickeffect.impl

import android.animation.TimeInterpolator
import android.view.View
import android.view.animation.DecelerateInterpolator
import wang.isam.libaray.view.clickeffect.ViewClickEffect
/**
 * 点击时缩小动画
 * @author SamWang(199004)
 *         2016/1/15 14:26
 */
class DefaultClickEffectScaleAnimate(val interpolator: TimeInterpolator = DecelerateInterpolator()) : ViewClickEffect{
    override fun onPressedEffect(view: View) {
        view.animate().scaleX(scale).scaleY(scale).setDuration(duration).interpolator = interpolator
    }

    override fun onUnPressedEffect(view: View) {
        view.animate().scaleX(1f).scaleY(1f).interpolator = interpolator

    }

    companion object {
        private const val scale = 0.7f
        private const val duration = 150L
    }


}