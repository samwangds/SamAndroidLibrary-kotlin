package wang.isam.libaray.kotlin.ext

import android.app.Fragment
import android.content.Context
import android.support.annotation.IntDef
import android.support.annotation.StringRes
import android.widget.Toast

//@Documented
//@IntDef{Toast.LENGTH_LONG,Toast}
//@Retention(RetentionPolicy.SOURCE)
//public @interface ToastDuratgion{}
private object ToastObject {
    @IntDef(Toast.LENGTH_LONG, Toast.LENGTH_SHORT)
    @Retention(AnnotationRetention.SOURCE)
    annotation class ToastDuration
}

fun Context.toast(text: CharSequence, @ToastObject.ToastDuration duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}
fun Fragment.toast(text: CharSequence, @ToastObject.ToastDuration duration: Int = Toast.LENGTH_SHORT) {
    this.activity.toast(text,duration)
}

fun Context.toast(@StringRes text: Int, @ToastObject.ToastDuration duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}
fun Fragment.toast(@StringRes text: Int, @ToastObject.ToastDuration duration: Int = Toast.LENGTH_SHORT) {
    this.activity.toast(text,duration)
}
