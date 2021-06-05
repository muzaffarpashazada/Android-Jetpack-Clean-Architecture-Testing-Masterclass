package com.anushka.circlecalc

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class MyCalcTest{

    private lateinit var myCalc: MyCalc

    @Before
    fun setUp(){
        myCalc = MyCalc()
    }

    @Test
    fun calculateCircumference_radiusGiven_returnsCorrectResult(){
        val result = myCalc.calculateCircumference(2.1)
        val answer = 13.188
        assertThat(result).isEqualTo(answer)
    }

    @Test
    fun calculateCircumference_zeroRadius_returnsCorrectResult(){
        val result = myCalc.calculateCircumference(0.0)
        val answer = 0.0
        assertThat(result).isEqualTo(answer)
    }

    @Test
    fun calculateCircumference_radiusGiven_returnsWrongResult(){
        val result = myCalc.calculateCircumference(2.1)
        val answer = 13.189
        assertThat(result).isNotEqualTo(answer)
    }


    @Test
    fun calculateArea_radiusGiven_returnsCorrectResult(){
        val result = myCalc.calculateArea(2.1)
        val answer = 13.8474
        assertThat(result).isEqualTo(answer)
    }


    @Test
    fun calculateArea_zeroRadius_returnsCorrectResult(){
        val result = myCalc.calculateArea(0.0)
        val answer = 0.0
        assertThat(result).isEqualTo(answer)
    }


    @Test
    fun calculateArea_radiusGiven_returnsWrongResult(){
        val result = myCalc.calculateArea(2.1)
        val answer = 138.474
        assertThat(result).isNotEqualTo(answer)
    }
}