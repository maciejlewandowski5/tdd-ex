package com.example.simpletranslator.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "definitions")
data class DefinitionEntity(var phrase: String, var definition: String){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
