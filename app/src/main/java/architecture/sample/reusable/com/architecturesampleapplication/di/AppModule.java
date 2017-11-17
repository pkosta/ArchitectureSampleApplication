package architecture.sample.reusable.com.architecturesampleapplication.di;

/*
 * Created by 849501 on 11/16/2017.
 */

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import architecture.sample.reusable.com.architecturesampleapplication.R;
import architecture.sample.reusable.com.architecturesampleapplication.repo.RecallRepoModel;
import architecture.sample.reusable.com.architecturesampleapplication.repo.Repository;
import architecture.sample.reusable.com.architecturesampleapplication.repo.localrepo.AppDatabase;
import architecture.sample.reusable.com.architecturesampleapplication.repo.localrepo.RecallRepoDao;
import architecture.sample.reusable.com.architecturesampleapplication.repo.remoterepo.NetworkDataSource;
import architecture.sample.reusable.com.architecturesampleapplication.repo.remoterepo.RecallGsonDeserializer;
import architecture.sample.reusable.com.architecturesampleapplication.viewmodel.HomeViewModel;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    @Singleton
    Retrofit providesRetrofit(Context context) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …
        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!

        GsonBuilder gsonBuilder = new GsonBuilder();
        // Adding custom deserializers
        gsonBuilder.registerTypeAdapter(RecallRepoModel.class, new RecallGsonDeserializer());
        Gson recallGsonDeserializer = gsonBuilder.create();

        return new Retrofit.Builder()
                .baseUrl(context.getString(R.string.server_url))
                .addConverterFactory(GsonConverterFactory.create(recallGsonDeserializer))
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Provides
    @Singleton
    NetworkDataSource provideNetworkDataSource(Retrofit retrofit) {
        return new NetworkDataSource(retrofit);
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "architecture-database")
                .build();
    }

    @Provides
    RecallRepoDao provideRecallRepoDao(AppDatabase appDatabase) {
        return appDatabase.recallRepoModelDao();
    }

    @Provides
    @Singleton
    Repository provideRepository(NetworkDataSource networkDataSource,
                                 AppDatabase appDatabase) {
        return new Repository(networkDataSource, appDatabase);
    }

    @Provides
    HomeViewModel provideHomeViewModel(Application application, Repository repository) {
        return new HomeViewModel(application, repository);
    }

    @Provides
    ViewModelFactory getViewModelFactory(HomeViewModel homeViewModel) {
        return new ViewModelFactory(homeViewModel);
    }

}
