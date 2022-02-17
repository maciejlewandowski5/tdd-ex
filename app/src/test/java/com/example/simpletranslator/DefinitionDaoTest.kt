package com.example.simpletranslator

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.simpletranslator.database.DefinitionDao
import com.example.simpletranslator.database.DefinitionDatabase
import com.example.simpletranslator.database.DefinitionEntity
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DefinitionDaoTest {

    lateinit var dao: DefinitionDao
    lateinit var database: DefinitionDatabase

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getTargetContext()
        database = Room.inMemoryDatabaseBuilder(context, DefinitionDatabase::class.java).build()
        dao = database.translationDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun shouldStoreDataAndReturnCorrectValue() {
        //given
        val entity = DefinitionEntity("word", "słowo")

        //when
        dao.insertDefinition(entity)

        //then
        val result = dao.getDefinition("word").blockingGet()
        assertEquals("słowo", result)
    }

}