package com.microgrezm.childvaccination.database

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.microgrezm.childvaccination.dao.ChildDao
import com.microgrezm.childvaccination.data.ChildData
import java.security.AccessControlContext

@Database( entities = [ChildData::class],version = 3 ,exportSchema = false )
abstract class ChildDatabase : RoomDatabase() {

    abstract fun childDao() : ChildDao
   companion object{
       @Volatile
       private var instance : ChildDatabase? = null
      fun  getInstance (context: Context) : ChildDatabase {
        if (instance == null){
            instance = Room.databaseBuilder(context.applicationContext,
                ChildDatabase::class.java,"children_table")
                .fallbackToDestructiveMigration()
                .build()
        }
   return instance as ChildDatabase
    }

   }
}