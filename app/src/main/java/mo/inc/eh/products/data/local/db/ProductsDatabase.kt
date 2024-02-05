package mo.inc.eh.products.data.local.db


import androidx.room.Database
import androidx.room.RoomDatabase
import mo.inc.eh.products.data.model.Product

@Database(entities = [Product::class] , version = 1 , exportSchema = false)
abstract class ProductsDatabase : RoomDatabase() {
    abstract fun getProductsDao() : ProductsDao
}