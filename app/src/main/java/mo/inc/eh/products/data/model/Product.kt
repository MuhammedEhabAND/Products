package mo.inc.eh.products.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_table")
data class Product(
    val description: String,
    @PrimaryKey
    val id: String,
    val image_url: String,
    val name: String,
    val price: String,

)