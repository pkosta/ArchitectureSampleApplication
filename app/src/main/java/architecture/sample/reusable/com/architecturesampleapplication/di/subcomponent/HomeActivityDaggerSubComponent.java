package architecture.sample.reusable.com.architecturesampleapplication.di.subcomponent;

/*
 * Created by 849501 on 11/17/2017.
 */

import architecture.sample.reusable.com.architecturesampleapplication.HomeActivity;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface HomeActivityDaggerSubComponent extends AndroidInjector<HomeActivity> {

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<HomeActivity> {

    }

}
