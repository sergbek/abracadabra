package mybox.com.mybox.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.ViewTreeObserver
import mybox.com.mybox.R

/**
 * Created by Sergbek on 12.12.2016.
 */
abstract class BaseActivity : AppCompatActivity(), ActivityView {
    var presenter: BaseActivityPresenter? = null

    var toolbar: Toolbar? = null

    protected abstract fun initPresenter(): BaseActivityPresenter
    protected abstract fun setupUI()
    protected fun findUI(){}
    protected abstract val layoutResource: Int


    override val viewArguments: Bundle = intent.extras

    override val viewContext: Context
        get() = this

    override var isActivityResumed: Boolean
        get() = throw UnsupportedOperationException()
        set(value) {
        }
    override val fragmentContainer: Int
        get() = throw UnsupportedOperationException()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (layoutResource != 0) setContentView(layoutResource)

        findUI()

        toolbar = findViewById(R.id.toolbar) as Toolbar?

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        setupUI()

        if (presenter == null) {
            presenter = initPresenter()
        }
        presenter?.onCreateView(savedInstanceState)

        window.decorView.rootView.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                window.decorView.rootView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                presenter?.onViewCreated()
            }
        })
    }

    override fun onDestroy() {
        presenter?.onDestroyView()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        isActivityResumed = true
        presenter?.onResume()
    }

    override fun onPause() {
        super.onPause()
        isActivityResumed = false
        presenter?.onPause()
    }

    override fun onBackPressed() {
        presenter?.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun setToolbarTitle(text: String) {
        supportActionBar?.title = text
    }

    override fun setToolbarTitle(@StringRes textRes: Int) {
        supportActionBar?.setTitle(textRes)
    }

    override fun finishActivity() {
        supportFinishAfterTransition()
    }



    override fun asActivity(): AppCompatActivity = this

}