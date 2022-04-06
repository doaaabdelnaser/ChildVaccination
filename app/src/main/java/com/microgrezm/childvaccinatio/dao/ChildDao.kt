package com.microgrezm.childvaccination.dao

import androidx.room.*
import com.microgrezm.childvaccination.data.ChildData
import kotlinx.coroutines.selects.select

@Dao
interface ChildDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun childInsert(childData: ChildData)
    @Query("select * from children_table")
    suspend fun childGet() : List<ChildData>
    @Delete
    suspend fun deleteChild(child : ChildData)

    @Query("select * from children_table where id=:id")
    suspend fun getChildByID(id:Int):List<ChildData>

}

