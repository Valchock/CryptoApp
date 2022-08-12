package com.example.cryptoapp.data.datasources.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cryptoapp.data.datasources.local.dao.CryptoDao
import com.example.cryptoapp.data.datasources.local.entities.ExchangeInfoEntity

@Database(
    entities = [
        ExchangeInfoEntity::class
    ],
    version = 1
)

abstract class CryptoDataBase : RoomDatabase() {

    companion object {

        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: CryptoDataBase? = null


        fun getDatabase(context: Context): CryptoDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CryptoDataBase::class.java,
                    "crypto"
                ).build()
                return instance
            }
        }

    }

    abstract fun cryptoDao(): CryptoDao

}