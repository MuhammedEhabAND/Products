package mo.inc.eh.products.domian.repo

import ProductResponse
import kotlinx.coroutines.flow.Flow

interface Repo {
    fun getProducts () : Flow<ProductResponse>
}