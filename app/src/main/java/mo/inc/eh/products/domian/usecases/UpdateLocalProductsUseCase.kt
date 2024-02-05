package mo.inc.eh.products.domian.usecases

import kotlinx.coroutines.flow.collectLatest
import mo.inc.eh.products.domian.entity.Product
import mo.inc.eh.products.domian.repo.Repo
import javax.inject.Inject

class UpdateLocalProductsUseCase @Inject constructor(
    private val repo: Repo
) {
    suspend operator fun invoke() {
        val products  = arrayListOf<Product>()
        repo.getProducts().collectLatest {
            for(productResponseItem in it){
                val product = productResponseItem.product
                products.add(product)
            }
            repo.updateLocalProductsList(products)
        }
    }
}