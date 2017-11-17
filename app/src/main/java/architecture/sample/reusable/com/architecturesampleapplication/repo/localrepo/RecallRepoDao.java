package architecture.sample.reusable.com.architecturesampleapplication.repo.localrepo;

/*
 * Created by 849501 on 11/17/2017.
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import architecture.sample.reusable.com.architecturesampleapplication.repo.RecallRepoModel;

@Dao
public interface RecallRepoDao {

    @Query("SELECT * from RecallRepoModel")
    RecallRepoModel getRecallModel();

    @Insert
    void insertAll(RecallRepoModel... repoModels);
}
