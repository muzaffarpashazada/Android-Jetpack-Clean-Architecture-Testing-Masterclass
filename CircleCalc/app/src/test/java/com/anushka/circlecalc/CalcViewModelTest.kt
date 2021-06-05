package com.anushka.circlecalc

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CalcViewModelTest {

    private lateinit var calcViewModel: CalcViewModel
    private lateinit var calculations: Calculations

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        calculations = Mockito.mock(Calculations::class.java)
        Mockito.`when`(calculations.calculateArea(2.1)).thenReturn(13.8487)
        Mockito.`when`(calculations.calculateArea(0.0)).thenReturn(0.0)
        Mockito.`when`(calculations.calculateCircumference(1.0)).thenReturn(6.28)
        Mockito.`when`(calculations.calculateCircumference(0.0)).thenReturn(0.0)
        calcViewModel = CalcViewModel(calculations)
    }

    @Test
    fun calculateArea_radiusSet_updateLiveData() {
        calcViewModel.calculateArea(2.1)
        val result = calcViewModel.areaValue.value
        assertThat(result).isEqualTo("13.8487")
    }

    @Test
    fun calculateArea_zeroRadius_updateLiveData() {
        calcViewModel.calculateArea(0.0)
        val result = calcViewModel.areaValue.value
        assertThat(result).isEqualTo("0.0")
    }

    @Test
    fun calculateCircumference_radiusSet_updateLiveData() {
        calcViewModel.calculateCircumference(1.0)
        val result = calcViewModel.circumferenceValue.value
        assertThat(result).isEqualTo("6.28")
    }

    @Test
    fun calculateCircumference_zeroRadius_updateLiveData() {
        calcViewModel.calculateCircumference(0.0)
        val result = calcViewModel.circumferenceValue.value
        assertThat(result).isEqualTo("0.0")
    }
}