package mo.inc.eh.products.presentation.screens.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import mo.inc.eh.products.data.model.Product
import mo.inc.eh.products.presentation.components.ErrorState
import mo.inc.eh.products.presentation.components.LoadingState
import mo.inc.eh.products.utils.UiState


@Composable
fun HomeScreen(
    state: UiState<List<Product>>
) {
    when (state) {
        is UiState.Failure -> ErrorState(state.error)
        UiState.Loading -> LoadingState()
        is UiState.Success -> showData(state.data)

    }
}
@Composable
fun showData(data: List<Product>) {
    Text(text = "there is ${data.size}")
}
