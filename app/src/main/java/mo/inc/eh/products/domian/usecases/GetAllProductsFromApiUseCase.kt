package mo.inc.eh.products.domian.usecases

import mo.inc.eh.products.domian.repo.Repo
import javax.inject.Inject

class GetAllProductsFromApiUseCase @Inject constructor(
    private val repo : Repo
) {
    operator fun invoke() = repo.getProducts()
}