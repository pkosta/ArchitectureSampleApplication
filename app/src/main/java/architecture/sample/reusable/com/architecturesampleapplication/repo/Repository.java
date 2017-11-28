package architecture.sample.reusable.com.architecturesampleapplication.repo;

/*
 * Created by 849501 on 11/14/2017.
 */

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;
import android.util.Log;

import architecture.sample.reusable.com.architecturesampleapplication.datamodel.RecallModel;
import architecture.sample.reusable.com.architecturesampleapplication.repo.localrepo.AppDataKotlin;
import architecture.sample.reusable.com.architecturesampleapplication.repo.localrepo.AppDatabase;
import architecture.sample.reusable.com.architecturesampleapplication.repo.mapper.ConverterUtils;
import architecture.sample.reusable.com.architecturesampleapplication.repo.mapper.RepoToUiMapper;
import architecture.sample.reusable.com.architecturesampleapplication.repo.remoterepo.NetworkDataSource;

public class Repository {

    private NetworkDataSource mRemoteDataSource;

    private AppDataKotlin mDatabase;

    private MutableLiveData<RecallModel> data;

    private MutableLiveData<Boolean> isDataUpdated;

    public Repository(NetworkDataSource networkDataSource,
                      AppDataKotlin appDatabase) {
        data = new MutableLiveData<>();
        isDataUpdated = new MutableLiveData<>();
        isDataUpdated.setValue(false);
        mRemoteDataSource = networkDataSource;  // dagger dependency
        mDatabase = appDatabase;
        loadRecallData();
    }

    @SuppressLint("StaticFieldLeak")
    private void loadRecallData() {
        new AsyncTask<Void, Void, RecallModel>() {

            @Override
            protected RecallModel doInBackground(Void... voids) {

                RecallRepoModel repoModel = mRemoteDataSource.getRecallData();

                Log.d("BUGS", "Saving the sata into the database");
                // mDatabase.recallRepoModelDao().insertAll(repoModel);

                Log.d("BUGS", "Getting data from Room Database");
                Log.d("BUGS", "Data: "
                        +mDatabase.recallRepoModelDao().getRecallModel().toString());

                //return new RepoToUiMapper().map(repoModel); // dispatch the result.
                return ConverterUtils.getRecallModelWithRepoModel(repoModel);
            }

            @Override
            protected void onPostExecute(RecallModel recallModel) {
                isDataUpdated.setValue(true);
                super.onPostExecute(recallModel);
                Log.d("BUGS","On Load Finished Called -- Recall Model" + recallModel);
                data.setValue(recallModel);
            }
        }.execute();
    }

    public LiveData<RecallModel> getRecallData() {
        return data;
    }

    public LiveData<Boolean> getUpdatedFlag() {
        return isDataUpdated;
    }
}
