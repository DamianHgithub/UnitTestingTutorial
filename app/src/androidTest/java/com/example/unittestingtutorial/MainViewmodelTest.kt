package com.example.unittestingtutorial

import com.example.unittestingtutorial.data.EmailModel
import com.example.unittestingtutorial.db.MainDao
import com.example.unittestingtutorial.db.MainDatabase
import com.example.unittestingtutorial.di.testModule
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.core.qualifier.named
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(JUnit4::class)
class MainViewmodelTest: KoinTest {
    private val database by inject<MainDatabase>(named("testdb"))
    private val dao by inject<MainDao>(named("testdao"))
    @Before
    fun setup() {
        loadKoinModules(testModule)
    }
    @Test
    fun testInsert() {
        runBlocking {
            val entities = listOf(EmailModel(1,"123@gmail.com"))
            dao.insertEmail(entities)
            val collectedEntities = dao.getEmails().first()
            Assert.assertEquals(entities, collectedEntities)
        }
    }
    @After
    fun teardown() {
        database.close()
        stopKoin()
    }
}