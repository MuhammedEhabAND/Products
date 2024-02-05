package mo.inc.eh.products.data.local

import mo.inc.eh.products.data.model.Product

interface LocalSource {
    suspend fun getLocalProductsList(): List<Product>
    suspend fun updateLocalProductsList(list: List<Product>)
}