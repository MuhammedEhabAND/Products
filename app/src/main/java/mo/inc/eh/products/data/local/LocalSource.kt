package mo.inc.eh.products.data.local

import Product

interface LocalSource {
    suspend fun getLocalProductsList(): List<Product>
    suspend fun updateLocalProductsList(list: List<Product>)
}