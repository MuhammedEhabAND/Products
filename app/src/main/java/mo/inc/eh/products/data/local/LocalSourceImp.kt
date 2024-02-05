package mo.inc.eh.products.data.local

import Product
import mo.inc.eh.products.data.local.db.ProductsDao
import javax.inject.Inject

class LocalSourceImp @Inject constructor(
    private val productsDao: ProductsDao
) : LocalSource {
    override suspend fun getLocalProductsList(): List<Product> = productsDao.getAll()

    override suspend fun updateLocalProductsList(list: List<Product>) {
        productsDao.addAll(list)
    }
}