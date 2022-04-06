package com.microgrezm.childvaccination.database

import com.microgrezm.childvaccination.data.ChildData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalRepositoryIpm(private val db: ChildDatabase) : LocalRepository {
    override suspend fun childInsert(childData: ChildData) {
        withContext(Dispatchers.IO) {
            db.childDao().childInsert(childData)
        }
    }

    override suspend fun childGet() = withContext(Dispatchers.IO) {
        db.childDao().childGet()
    }

    override suspend fun deleteChild(child: ChildData) {
        withContext(Dispatchers.IO) {
            db.childDao().deleteChild(child)
        }
    }

    override suspend fun getChildByID( id: Int  ) =

        withContext(Dispatchers.IO) {
            db.childDao().getChildByID(id)
        }

}