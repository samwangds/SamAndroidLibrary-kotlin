package wang.isam.libaray.kotlin.ext

import android.app.Activity
import android.content.ComponentName
import android.content.Intent

fun Activity.startActivity(activityClass: Class<out Activity>){
    this.startActivity(Intent(this, activityClass))
}

/**
 * 打开网络设置界面
 */
fun Activity.openSetting() {
    val intent = Intent("/")
    val cm = ComponentName("com.android.settings",
            "com.android.settings.WirelessSettings")
    intent.component = cm
    intent.action = "android.intent.action.VIEW"
    this.startActivityForResult(intent, 0)
}