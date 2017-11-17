package architecture.sample.reusable.com.architecturesampleapplication.repo.localrepo;

/*
 * Created by 849501 on 11/17/2017.
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import architecture.sample.reusable.com.architecturesampleapplication.repo.RecallRepoModel;

@Database(entities = {RecallRepoModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RecallRepoDao recallRepoModelDao();
}
