package architecture.sample.reusable.com.architecturesampleapplication.di.submodule;

/*
 * Created by 849501 on 11/17/2017.
 */

import android.app.Activity;

import architecture.sample.reusable.com.architecturesampleapplication.HomeActivity;
import architecture.sample.reusable.com.architecturesampleapplication.di.subcomponent.HomeActivityDaggerSubComponent;
import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = HomeActivityDaggerSubComponent.class)
public abstract class HomeActivitySubModule {

    @Binds
    @IntoMap
    @ActivityKey(HomeActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindYourActivityInjectorFactory(HomeActivityDaggerSubComponent.Builder builder);

}
