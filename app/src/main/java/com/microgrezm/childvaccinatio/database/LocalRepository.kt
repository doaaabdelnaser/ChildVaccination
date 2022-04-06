package com.microgrezm.childvaccination.database

import com.microgrezm.childvaccination.data.ChildData

interface LocalRepository {
    suspend fun childInsert(childData: ChildData)
    suspend fun childGet() : List<ChildData>
    suspend fun deleteChild(child : ChildData)
    suspend fun getChildByID(id: Int):List<ChildData>
}