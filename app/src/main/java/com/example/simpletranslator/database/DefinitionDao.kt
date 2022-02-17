package com.example.simpletranslator.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Single

@Dao
interface DefinitionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDefinition(entity: DefinitionEntity)
    @Query(
        "SELECT definition FROM definitions " +
            "WHERE phrase = :sourcedPhrase LIMIT 1"
    )
    fun getDefinition(sourcedPhrase: String): Single<DefinitionEntity>
}
