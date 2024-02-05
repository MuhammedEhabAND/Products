package mo.inc.eh.products.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mo.inc.eh.products.data.local.db.ProductsDao
import mo.inc.eh.products.data.local.db.ProductsDatabase
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

    @Provides
    fun providesProductsDao(
        database : ProductsDatabase
    ) :ProductsDao {
        return database.getProductsDao()
    }
    @Singleton
    @Provides
    fun providesProductsDatabase(
        @ApplicationContext context: Context
    ) : ProductsDatabase {
        return  Room.databaseBuilder(
            context ,
            ProductsDatabase::class.java,
            "products_db"
        ).build()
    }
}