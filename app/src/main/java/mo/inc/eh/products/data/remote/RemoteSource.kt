package mo.inc.eh.products.data.remote

import ProductResponse
import kotlinx.coroutines.flow.Flow

interface RemoteSource {
    fun getProducts(): Flow<ProductResponse>

}