package mo.inc.eh.products.data.repo

import Product
import ProductResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mo.inc.eh.products.data.local.LocalSource
import mo.inc.eh.products.data.remote.RemoteSource
import mo.inc.eh.products.domian.repo.Repo
import javax.inject.Inject

class RepoImp @Inject constructor(
    private val remoteSource: RemoteSource,
    private val localSource: LocalSource
): Repo {
    override fun getProducts(): Flow<ProductResponse> = flow {
        remoteSource.getProducts()
    }

    override fun getLocalProductsList(): Flow<List<Product>> = flow{
        localSource.getLocalProductsList()
    }

    override suspend fun updateLocalProductsList(list: List<Product>) {
        localSource.updateLocalProductsList(list)
    }
}