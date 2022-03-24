package com.fmauriciors.projectaromascafetales

import android.app.Application
import androidx.room.Room
import com.fmauriciors.projectaromascafetales.local.AromasCafetalesdb

class AromasCafetalesProyect : Application() {

    companion object{

        lateinit var database: AromasCafetalesdb
    }

    override fun onCreate() {
        super.onCreate()

        database  = Room.databaseBuilder(

            this,
            AromasCafetalesdb::class.java,
            "AromasCafetales_db"
        )
            .build()
    }
}