package mo.inc.eh.products.data.remote


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mo.inc.eh.products.data.model.ProductResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteSourceImp @Inject constructor(
    private val productsService: ProductsService
): RemoteSource {
    override fun getProducts(): Flow<ProductResponse>  = flow {
        val products = productsService.getProducts()
        emit(products)
    }
}