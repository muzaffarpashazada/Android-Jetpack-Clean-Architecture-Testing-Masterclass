package com.anushka.didemo

import dagger.Module
import dagger.Provides

@Module
class NCBatteryModule {

    @Provides
    fun bindsNCBattery(nickelCadmiumBattery:NickelCadmiumBattery): Battery {
        return nickelCadmiumBattery
    }
}