package mybox.com.mybox.base

import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity

/**
 * Created by Sergbek on 12.12.2016.
 */
interface ActivityView : BaseView {

    var isActivityResumed: Boolean

    val fragmentContainer: Int

    fun setToolbarTitle(@StringRes textRes: Int)

    fun setToolbarTitle(text: String)

    fun finishActivity()

    fun asActivity(): AppCompatActivity
}