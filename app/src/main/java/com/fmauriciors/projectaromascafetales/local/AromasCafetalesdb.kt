package com.fmauriciors.projectaromascafetales.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Register::class, Product::class], version = 1, exportSchema = false)
abstract class AromasCafetalesdb : RoomDatabase(){

    abstract fun RegisterDao(): RegisterDao

    abstract fun ProductDao(): ProductDao

}