package architecture.sample.reusable.com.architecturesampleapplication

import android.app.Activity
import android.app.Application
import architecture.sample.reusable.com.architecturesampleapplication.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/*
 * Created by 849501 on 11/24/2017.
 */
class ArchitectureKotlinApp : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>;

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
                .application(this)
                .context(this)
                .build()
                .inject(this);

    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }
}