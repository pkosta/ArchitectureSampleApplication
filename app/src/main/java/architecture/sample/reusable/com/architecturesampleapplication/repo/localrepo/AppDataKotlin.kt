package architecture.sample.reusable.com.architecturesampleapplication.repo.localrepo

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import architecture.sample.reusable.com.architecturesampleapplication.repo.RecallRepoModel

/*
 * Created by 849501 on 11/24/2017.
 */
@Database(entities = arrayOf(RecallRepoModel::class), version = 1)
abstract class AppDataKotlin: RoomDatabase() {
    abstract fun recallRepoModelDao(): RecallRepoDao;
}