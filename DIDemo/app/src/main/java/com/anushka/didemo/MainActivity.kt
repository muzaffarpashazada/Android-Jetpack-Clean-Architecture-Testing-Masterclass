package com.anushka.didemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var smartPhone: SmartPhone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSmartPhoneComponent
            .create()
            .getSmartPhone()
            .makeACallWithRecording()

//        val battery = Battery()
//        val memoryCard = MemoryCard()
//        val serviceProvider = ServiceProvider()
//        val simCard = SIMCard(serviceProvider)
//
//        val smartPhone = SmartPhone(battery, simCard, memoryCard)
//        smartPhone.makeACallWithRecording()
    }
}
