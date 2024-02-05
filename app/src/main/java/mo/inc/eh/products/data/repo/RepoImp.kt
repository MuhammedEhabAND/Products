package mo.inc.eh.products.data.repo

import ProductResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mo.inc.eh.products.data.remote.RemoteSource
import mo.inc.eh.products.domian.repo.Repo
import javax.inject.Inject

class RepoImp @Inject constructor(
    private val remoteSource: RemoteSource
): Repo {
    override fun getProducts(): Flow<ProductResponse> = flow {
        remoteSource.getProducts()
    }
}