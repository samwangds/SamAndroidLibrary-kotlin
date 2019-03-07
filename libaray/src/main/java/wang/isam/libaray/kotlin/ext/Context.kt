package wang.isam.libaray.kotlin.ext

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Created by samwang on 2019/3/8.
 */

/**
 * 获取应用程序名称
 */
fun Context.getAppName(): String? {
    try {
        val packageManager = this.packageManager
        val packageInfo = packageManager.getPackageInfo(
                this.packageName, 0)
        val labelRes = packageInfo.applicationInfo.labelRes
        return this.resources.getString(labelRes)
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }

    return null
}

/**
 * [获取应用程序版本名称信息]
 *
 * @param context
 * @return 当前应用的版本名称
 */
fun Context.getVersionName(): String? {
    try {
        val packageManager = this.packageManager
        val packageInfo = packageManager.getPackageInfo(
                this.packageName, 0)
        return packageInfo.versionName

    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }

    return null
}

fun Context.debugable(): Boolean {
    try {
        val info = this.applicationInfo
        return info.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
    } catch (e: Exception) {

    }

    return false
}

/**
 * 判断网络是否连接
 * @return
 */
fun Context.isConnected(): Boolean {

    val connectivity = this
            .getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager

    if (null != connectivity) {

        val info = connectivity.activeNetworkInfo
        if (null != info && info.isConnected) {
            if (info.state == NetworkInfo.State.CONNECTED) {
                return true
            }
        }
    }
    return false
}

/**
 * 判断是否是wifi连接
 */
fun Context.isWifi(): Boolean {
    val cm = this
            .getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager

    return if (cm != null) {
        cm.activeNetworkInfo.type == ConnectivityManager.TYPE_WIFI
    } else false

}
