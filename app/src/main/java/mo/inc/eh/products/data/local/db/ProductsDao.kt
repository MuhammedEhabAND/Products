package mo.inc.eh.products.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mo.inc.eh.products.domian.entity.Product

@Dao
interface ProductsDao {
    @Query("SELECT * FROM products_table")
    suspend fun getAll(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(products: List<Product>)
}