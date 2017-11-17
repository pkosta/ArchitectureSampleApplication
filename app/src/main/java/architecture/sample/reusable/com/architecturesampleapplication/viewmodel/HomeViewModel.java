package architecture.sample.reusable.com.architecturesampleapplication.viewmodel;

/*
 * Created by 849501 on 11/14/2017.
 */

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import architecture.sample.reusable.com.architecturesampleapplication.datamodel.RecallModel;
import architecture.sample.reusable.com.architecturesampleapplication.repo.Repository;

public class HomeViewModel extends AndroidViewModel {

    private LiveData<RecallModel> recallModel;

    private Repository mRepo;

    public HomeViewModel(@NonNull Application application,
                         @NonNull Repository repo) {
        super(application);

        mRepo = repo;
        recallModel = Transformations.switchMap(mRepo.getUpdatedFlag(),
                input -> {
                    if (input) {
                        return mRepo.getRecallData();
                    }
                    return recallModel;
                });
    }


    public LiveData<RecallModel> getRecallModel() {
        return recallModel;
    }


        /*
        new Function<Boolean, LiveData<RecallModel>>() {
                    @Override
                    public LiveData<RecallModel> apply(Boolean input) {
                        if (input) {
                            return mRepo.getRecallData();
                        }
                        return recallModel;
                    }
                });
         */
}
