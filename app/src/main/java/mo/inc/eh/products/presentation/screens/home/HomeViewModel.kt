package mo.inc.eh.products.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import mo.inc.eh.products.data.model.Product
import mo.inc.eh.products.domian.usecases.GetAllProductsFromApiUseCase
import mo.inc.eh.products.domian.usecases.GetAllProductsFromDbUseCase
import mo.inc.eh.products.domian.usecases.UpdateLocalProductsUseCase
import mo.inc.eh.products.utils.UiState
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllProductsFromApiUseCase: GetAllProductsFromApiUseCase,
    private val getAllProductsFromDbUseCase: GetAllProductsFromDbUseCase,
    private val updateLocalProductsUseCase: UpdateLocalProductsUseCase
) :ViewModel(){
    private val _productState : MutableStateFlow<UiState<Product>> = MutableStateFlow(UiState.Loading)
    val productState : StateFlow<UiState<Product>>
        get() =  _productState.asStateFlow()
    private val _productsState : MutableStateFlow<UiState<List<Product>>> = MutableStateFlow(UiState.Loading)

    val productsState : StateFlow<UiState<List<Product>>>
        get() =  _productsState.asStateFlow()
    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllProductsFromApiUseCase.invoke().catch {e->
                _productsState.value = UiState.Failure(e.message.toString())
                getAllProductsLocally()
            }.collectLatest{data ->
                val allProducts :ArrayList<Product> = arrayListOf()
                for(productResponseItem in data) {
                    val product: Product = productResponseItem.Product
                    allProducts.add(product)
                }
                _productsState.value = UiState.Success(allProducts)
                updateLocalProducts()


            }
        }
    }
    fun selectProduct(product: Product){
        viewModelScope.launch(Dispatchers.IO) {
            _productState.value = UiState.Success(product)
        }
    }
    private fun updateLocalProducts(){
        viewModelScope.launch(Dispatchers.IO) {
            updateLocalProductsUseCase.invoke()

        }
    }
    private fun getAllProductsLocally(){
        viewModelScope.launch(Dispatchers.IO) {
            getAllProductsFromDbUseCase.invoke().catch {e->
                _productsState.value = UiState.Failure(e.message.toString())
            }.collectLatest {data->
                _productsState.value = UiState.Success(data)
            }
        }
    }
}