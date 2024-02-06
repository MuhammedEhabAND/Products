package mo.inc.eh.products.domian.repo



import kotlinx.coroutines.flow.Flow
import mo.inc.eh.products.domian.entity.Product
import mo.inc.eh.products.data.model.ProductResponse

interface Repo {
    fun getProducts () : Flow<ProductResponse>
    fun getLocalProductsList(): Flow<List<Product>>
    suspend fun updateLocalProductsList(list: List<Product>)
}