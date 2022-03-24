package com.fmauriciors.projectaromascafetales.local;

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao

interface ProductDao {

    @Insert
     suspend fun saveProduct ( product: Product)

    @Query("SELECT * FROM table_products WHERE productName LIKE :nameProduct")
    suspend fun searchProduct (nameProduct:String): Product

    @Delete
    suspend fun deleteProduct(product: Product)

    @Query ("SELECT * FROM table_products")
     suspend fun loadProducts(): MutableList<Product>


}
