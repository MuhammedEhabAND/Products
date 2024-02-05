package mo.inc.eh.products.domian.repo


import ProductResponse
import kotlinx.coroutines.flow.Flow
import mo.inc.eh.products.domian.entity.Product

interface Repo {
    fun getProducts () : Flow<ProductResponse>
    fun getLocalProductsList(): Flow<List<Product>>
    suspend fun updateLocalProductsList(list: List<Product>)
}