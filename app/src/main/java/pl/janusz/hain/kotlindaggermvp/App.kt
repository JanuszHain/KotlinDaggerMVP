package pl.janusz.hain.kotlindaggermvp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import pl.janusz.hain.kotlindaggermvp.dependency_injection.mvp.components.DaggerAppComponent


/**
 * Created by Janusz Hain on 2018-04-25.
 */
class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()

    }

}