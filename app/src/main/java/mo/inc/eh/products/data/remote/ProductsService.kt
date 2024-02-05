package mo.inc.eh.products.data.remote

import ProductResponse
import retrofit2.http.GET

interface ProductsService {

    @GET("featured.txt")
    suspend fun getProducts(): ProductResponse

}