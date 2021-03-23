package com.example.unittestingtutorial

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.unittestingtutorial.data.EmailModel
import com.example.unittestingtutorial.feature.MainViewmodel
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(AndroidJUnit4ClassRunner::class)
class MainViewModelTest: KoinTest {
    private val viewmodel by inject<MainViewmodel>()
    @Test
    fun test_flow_data_satisfied_true() {
        viewmodel.email.value = listOf(EmailModel(1, "123@gmail.com"))
        assertTrue(viewmodel.email.value != null)
    }
    @Test
    fun test_flow_data_clear_true() {
        assertTrue(viewmodel.email.value == null)
    }
    @Test
    fun test_flow_data_clear_false() {
        viewmodel.email.value = listOf(EmailModel(1, "123@gmail.com"))
        assertFalse(viewmodel.email.value == null)
    }
}