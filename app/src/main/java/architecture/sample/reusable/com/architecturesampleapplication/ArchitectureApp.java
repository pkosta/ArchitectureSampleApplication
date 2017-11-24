package architecture.sample.reusable.com.architecturesampleapplication;

/*
 * Created by 849501 on 11/16/2017.
 */

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import architecture.sample.reusable.com.architecturesampleapplication.di.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class ArchitectureApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        /*DaggerAppComponent
                .builder()
                .application(this)
                .context(getApplicationContext())
                .build()
                .inject(this);*/

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }
}
