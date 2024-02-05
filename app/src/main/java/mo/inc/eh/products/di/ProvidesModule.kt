package mo.inc.eh.products.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mo.inc.eh.products.data.remote.ProductsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProvidesModule {
    @Provides
    fun providesProductsService(
        retrofit: Retrofit
    ) : ProductsService{
        return retrofit.create(ProductsService::class.java)
    }
    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://www.nweave.com/wp-content/uploads/2012/09/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

}