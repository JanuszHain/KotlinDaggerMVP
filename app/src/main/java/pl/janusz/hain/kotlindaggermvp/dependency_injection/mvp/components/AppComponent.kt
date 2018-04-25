package pl.janusz.hain.kotlindaggermvp.dependency_injection.mvp.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import pl.janusz.hain.kotlindaggermvp.App
import pl.janusz.hain.kotlindaggermvp.dependency_injection.mvp.factories.ActivityInjectorFactories
import pl.janusz.hain.kotlindaggermvp.dependency_injection.mvp.factories.FragmentInjectorFactories
import pl.janusz.hain.kotlindaggermvp.dependency_injection.mvp.modules.AppModule
import javax.inject.Singleton


/**
 * Created by Janusz Hain on 2018-04-25.
 */
@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityInjectorFactories::class,
        FragmentInjectorFactories::class
))
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: App)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}