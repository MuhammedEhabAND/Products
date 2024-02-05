package mo.inc.eh.products.data.remote


import kotlinx.coroutines.flow.Flow
import mo.inc.eh.products.data.model.ProductResponse

interface RemoteSource {
    fun getProducts(): Flow<ProductResponse>

}