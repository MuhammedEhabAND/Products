package mo.inc.eh.products.domian.usecases

import kotlinx.coroutines.flow.Flow
import mo.inc.eh.products.data.model.ProductResponse
import mo.inc.eh.products.domian.repo.Repo
import javax.inject.Inject

class GetAllProductsFromApiUseCase @Inject constructor(
    private val repo : Repo
) {
    suspend operator fun invoke() : Flow<ProductResponse> {
        return repo.getProducts()
    }

}