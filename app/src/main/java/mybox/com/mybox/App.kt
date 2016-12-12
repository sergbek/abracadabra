package mybox.com.mybox

import android.app.Application
import android.content.Context
import com.crashlytics.android.Crashlytics
import com.facebook.stetho.Stetho
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager
import com.squareup.leakcanary.LeakCanary
import com.squareup.picasso.Picasso
import io.fabric.sdk.android.Fabric
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

/**
 * Created by Sergbek on 12.12.2016.
 */
class App : Application(){

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        if (BuildConfig.LEAK_CANARY_ENABLED) {
            LeakCanary.install(this)
        }

        if (BuildConfig.ANALYTICS_ENABLED) {
            Fabric.with(this, Crashlytics())
        }

        val picasso = Picasso.Builder(this)
                .indicatorsEnabled(BuildConfig.LOGGING_ENABLED)
                .build()
        Picasso.setSingletonInstance(picasso)

        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Regular.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )

        FlowManager.init(FlowConfig.Builder(this).build())
        Stetho.initializeWithDefaults(this)
    }


    companion object {

        @JvmStatic
        lateinit var appContext: Context
            private set
    }
}