package mo.inc.eh.products.domian.repo

import Product
import ProductResponse
import kotlinx.coroutines.flow.Flow

interface Repo {
    fun getProducts () : Flow<ProductResponse>
    fun getLocalProductsList(): Flow<List<Product>>
    suspend fun updateLocalProductsList(list: List<Product>)
}