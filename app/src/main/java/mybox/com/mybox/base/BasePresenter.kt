package mybox.com.mybox.base

import android.os.Bundle

/**
 * Created by Sergbek on 12.12.2016.
 */
interface BasePresenter{
    fun onCreateView(savedInstanceState: Bundle?)

    fun onDestroyView()

    fun onPause()

    fun onResume()

    fun onViewCreated()

    fun onBackPressed()

    fun onSaveInstanceState(outState: Bundle)

    fun onRestoreInstanceState(savedInstanceState: Bundle)
}