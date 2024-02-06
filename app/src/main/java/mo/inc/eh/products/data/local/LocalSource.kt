package mo.inc.eh.products.data.local

import mo.inc.eh.products.domian.entity.Product

interface LocalSource {
    suspend fun getLocalProductsList(): List<Product>
    suspend fun updateLocalProductsList(list: List<Product>)
}