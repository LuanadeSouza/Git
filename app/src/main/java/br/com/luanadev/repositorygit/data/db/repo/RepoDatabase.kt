package br.com.luanadev.repositorygit.data.db.repo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.luanadev.repositorygit.data.db.remotekeys.RemoteKeys
import br.com.luanadev.repositorygit.data.db.remotekeys.dao.RemoteKeysDao
import br.com.luanadev.repositorygit.data.db.repo.dao.RepoDao
import br.com.luanadev.repositorygit.data.entity.Repo

@Database(
    entities = [Repo::class, RemoteKeys::class], version = 1, exportSchema = false
)
abstract class RepoDatabase : RoomDatabase() {

    abstract fun reposDao(): RepoDao
    abstract fun remoteKeysDao(): RemoteKeysDao

    companion object {

        @Volatile
        private var INSTANCE: RepoDatabase? = null

        fun getInstance(context: Context): RepoDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RepoDatabase::class.java, "Github.db"
            )
                .build()
    }
}