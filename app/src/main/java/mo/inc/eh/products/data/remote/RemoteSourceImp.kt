package mo.inc.eh.products.data.remote

import ProductResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteSourceImp @Inject constructor(
    private val productsService: ProductsService
): RemoteSource {
    override fun getProducts(): Flow<ProductResponse>  = flow {
        emit(productsService.getProducts())
    }
}