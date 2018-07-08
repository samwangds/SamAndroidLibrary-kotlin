package wang.isam.libaray.kotlin.ext

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.view.inputmethod.InputMethodManager.HIDE_IMPLICIT_ONLY
import android.view.inputmethod.InputMethodManager.SHOW_IMPLICIT

fun View.showSoftInput(show: Boolean) {
    val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    if (show) {
        inputMethodManager.showSoftInput(this, SHOW_IMPLICIT)
    } else {
        inputMethodManager.hideSoftInputFromWindow(windowToken, HIDE_IMPLICIT_ONLY)
    }
}