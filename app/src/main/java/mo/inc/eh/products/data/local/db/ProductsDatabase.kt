package mo.inc.eh.products.data.local.db

import Product
import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [Product::class] , version = 1 , exportSchema = false)
abstract class ProductsDatabase : RoomDatabase() {
    abstract fun getProductsDao() : ProductsDao
}