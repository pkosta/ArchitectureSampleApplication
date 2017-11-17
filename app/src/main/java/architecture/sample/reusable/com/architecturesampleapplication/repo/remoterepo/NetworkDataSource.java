package architecture.sample.reusable.com.architecturesampleapplication.repo.remoterepo;

/*
 * Created by 849501 on 11/15/2017.
 */

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import architecture.sample.reusable.com.architecturesampleapplication.repo.RecallRepoModel;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkDataSource {

    private Retrofit mRetrofit;

    public NetworkDataSource(Retrofit retrofit) {
        this.mRetrofit = retrofit;
    }

    public RecallRepoModel getRecallData() {
        try {
            return mRetrofit.create(RecallService.class).fetchRecallModel().execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*mRetrofit.create(RecallService.class).fetchRecallModel().enqueue(new Callback<RecallRepoModel>() {
            @Override
            public void onResponse(@NonNull Call<RecallRepoModel> call,
                                   @NonNull Response<RecallRepoModel> response) {
                Log.d("BUGS","Response Data: "+ response.body().toString());
            }

            @Override
            public void onFailure(@NonNull Call<RecallRepoModel> call, @NonNull Throwable t) {
                Log.d("BUGS","Error: "+ t.getMessage());
            }
        });*/
        return null;
    }
}
