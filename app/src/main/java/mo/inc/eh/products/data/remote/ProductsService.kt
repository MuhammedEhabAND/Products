package mo.inc.eh.products.data.remote


import mo.inc.eh.products.data.model.ProductResponse
import mo.inc.eh.products.data.model.ProductResponseItem
import retrofit2.http.GET

interface ProductsService {

    @GET("featured.txt")
    suspend fun getProducts(): ProductResponse

}