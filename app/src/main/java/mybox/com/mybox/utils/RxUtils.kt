@file:kotlin.jvm.JvmMultifileClass
@file:kotlin.jvm.JvmName("RxUtils")

package mybox.com.mybox.utils

import android.view.View
import com.jakewharton.rxbinding.view.RxView
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import java.util.concurrent.TimeUnit

/**
 * Created by Sergbek on 12.12.2016.
 */

fun unsubscribeIfNotNull(_subscription: CompositeSubscription?) {
    _subscription?.clear()
}

fun getNewCompositeSubIfUnsubscribed(_subscription: CompositeSubscription?): CompositeSubscription {
    if (_subscription === null || _subscription.isUnsubscribed) {
        return CompositeSubscription()
    }
    return _subscription
}

fun click(_view: View, _action: Action1<Any>) {
    RxView.clicks(_view).throttleFirst(800, TimeUnit.MILLISECONDS).subscribe(_action)
}

fun <T> Observable<T>.newThread(): Observable<T> =
        subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())