package mo.inc.eh.products.data.local

import mo.inc.eh.products.data.local.db.ProductsDao
import mo.inc.eh.products.data.model.Product
import javax.inject.Inject

class LocalSourceImp @Inject constructor(
    private val productsDao: ProductsDao
) : LocalSource {
    override suspend fun getLocalProductsList(): List<Product> = productsDao.getAll()

    override suspend fun updateLocalProductsList(list: List<Product>)  = productsDao.addAll(list)

}