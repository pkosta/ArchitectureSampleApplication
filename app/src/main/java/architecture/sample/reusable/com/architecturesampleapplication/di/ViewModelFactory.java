package architecture.sample.reusable.com.architecturesampleapplication.di;

/*
 * Created by 849501 on 11/17/2017.
 */

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import architecture.sample.reusable.com.architecturesampleapplication.viewmodel.HomeViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private HomeViewModel mViewModel;

    public ViewModelFactory(HomeViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(HomeViewModel.class)) {
            return (T) mViewModel;
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}