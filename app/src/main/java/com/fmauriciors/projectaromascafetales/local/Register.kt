package com.fmauriciors.projectaromascafetales.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.sql.Types.NULL

@Entity(tableName = "table_register")
data class Register(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="id") var id: Int = NULL,
    @ColumnInfo(name="nameUser") var nameUser: String = "",
    @ColumnInfo(name="phone") var phone: String = "",
    @ColumnInfo(name="email") var email: String = "",
    @ColumnInfo(name="password") var password: String = ""
): Serializable