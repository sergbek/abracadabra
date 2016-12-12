package mybox.com.mybox.base

import android.content.Context
import android.os.Bundle

/**
 * Created by Sergbek on 12.12.2016.
 */
interface BaseView {
    val viewArguments: Bundle

    val viewContext: Context
}