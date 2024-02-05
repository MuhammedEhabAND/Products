package mo.inc.eh.products.data.repo


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mo.inc.eh.products.data.local.LocalSource
import mo.inc.eh.products.data.model.Product
import mo.inc.eh.products.data.model.ProductResponse
import mo.inc.eh.products.data.model.ProductResponseItem
import mo.inc.eh.products.data.remote.RemoteSource

import mo.inc.eh.products.domian.repo.Repo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoImp @Inject constructor(
    private val remoteSource: RemoteSource,
    private val localSource: LocalSource
): Repo {
    override fun getProducts(): Flow<ProductResponse> =
        remoteSource.getProducts()


    override fun getLocalProductsList(): Flow<List<Product>> = flow{
       val products =  localSource.getLocalProductsList()
        emit(products)
    }

    override suspend fun updateLocalProductsList(list: List<Product>) =  localSource.updateLocalProductsList(list)

}