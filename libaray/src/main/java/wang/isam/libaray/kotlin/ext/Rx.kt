package wang.isam.libaray.kotlin.ext

import android.arch.lifecycle.Lifecycle.Event
import android.arch.lifecycle.LifecycleOwner
import android.view.View
import com.jakewharton.rxbinding2.view.clicks
import com.trello.rxlifecycle2.android.lifecycle.kotlin.bindUntilEvent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

fun  <T> Observable<T>.bindUntilDestroy(owner: LifecycleOwner): Observable<T> {
    return this.bindUntilEvent(owner, Event.ON_DESTROY)
}

fun  <T> Observable<T>.debounceDefault(): Observable<T> {
    return this.debounce(200, java.util.concurrent.TimeUnit.MILLISECONDS)
}

fun View.clicksDefault(owner: LifecycleOwner): Observable<Unit> {
    return this.clicks().debounceDefault().bindUntilDestroy(owner).observeOn(AndroidSchedulers.mainThread())
}
