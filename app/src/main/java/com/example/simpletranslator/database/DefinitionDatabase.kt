package com.example.simpletranslator.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [DefinitionEntity::class], version = 1)
abstract class DefinitionDatabase : RoomDatabase() {

    abstract fun translationDao(): DefinitionDao
}
