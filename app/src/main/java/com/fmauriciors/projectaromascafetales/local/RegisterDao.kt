package com.fmauriciors.projectaromascafetales.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao

interface RegisterDao {

    @Insert
    suspend fun saveRegister ( register: Register)

    @Query("SELECT * FROM table_register WHERE nameUser LIKE :userName")
    suspend fun searchRegister (userName:String): Register

    @Query("SELECT * FROM table_register")
    suspend fun loadRegisters(): MutableList<Register>


}
