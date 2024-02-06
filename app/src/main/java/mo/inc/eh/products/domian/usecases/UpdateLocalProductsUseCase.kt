package mo.inc.eh.products.domian.usecases

import android.util.Log
import kotlinx.coroutines.flow.collectLatest
import mo.inc.eh.products.domian.entity.Product
import mo.inc.eh.products.domian.repo.Repo
import javax.inject.Inject

class UpdateLocalProductsUseCase @Inject constructor(
    private val repo: Repo,
) {
    suspend operator fun invoke() {
        try {
            val products = arrayListOf<Product>()
            repo.getProducts().collectLatest { responseItems ->
                for (productResponseItem in responseItems) {
                    val product = productResponseItem.Product
                    Log.d("ProductResponses", "Received response items: $responseItems")
                    products.add(product)

                }
            }
            Log.d("TAG", "invoke: $products")
            repo.updateLocalProductsList(products)

        } catch (e: Exception) {
            Log.d("TAG", "invoke: ${e.localizedMessage} ")
        }
    }
}