package wang.isam.libaray.view.clickeffect

import android.view.View

/**
 * View点击效果接口
 * @author SamWang(199004)
 *         2016/1/15	14:05
 */
interface ViewClickEffect {
    /**
     * 按下去的效果
     * @param view
     */
    fun onPressedEffect(view: View)

    /**
     * 释放的效果
     * @param view
     */
    fun onUnPressedEffect(view: View)
}