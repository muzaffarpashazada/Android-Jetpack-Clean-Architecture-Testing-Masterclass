package com.anushka.didemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var smartPhone: SmartPhone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSmartPhoneComponent
            .builder()
            .memoryCardModule(MemoryCardModule(66))
            .build()
            .inject(this)
        smartPhone.makeACallWithRecording()
    }
}
