package architecture.sample.reusable.com.architecturesampleapplication.di;

/*
 * Created by 849501 on 11/16/2017.
 */

import android.app.Application;
import android.content.Context;
import android.databinding.BindingConversion;

import javax.inject.Singleton;

import architecture.sample.reusable.com.architecturesampleapplication.ArchitectureApp;
import architecture.sample.reusable.com.architecturesampleapplication.di.submodule.HomeActivitySubModule;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        HomeActivitySubModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        @BindsInstance
        Builder context(Context context);
        AppComponent build();
    }

    void inject(ArchitectureApp app);

}
