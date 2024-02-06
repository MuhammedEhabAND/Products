package mo.inc.eh.products.presentation.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import mo.inc.eh.products.R
import mo.inc.eh.products.domian.entity.Product
import mo.inc.eh.products.presentation.components.ErrorState
import mo.inc.eh.products.presentation.components.LoadingState
import mo.inc.eh.products.presentation.viewmodel.SharedViewModel
import mo.inc.eh.products.utils.UiState


@Composable
fun HomeScreen(
    state: UiState<List<Product>>,
    navController: NavController,
    sharedViewModel: SharedViewModel

    ) {
    when (state) {
        is UiState.Failure -> ErrorState(state.error)
        UiState.Loading -> LoadingState()
        is UiState.Success -> ProductsList(state.data , navController , sharedViewModel )

    }
}

@Composable
fun ProductsList(products: List<Product>, navController: NavController, sharedViewModel: SharedViewModel) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(products) { product ->
            ProductCard(
                productImageUrl = product.image_url,
                productTitle = product.name,
                productDescription = product.description
            ) {
                sharedViewModel.selectProduct(product)
                navController.navigate("details")
            }

        }
    }


}



@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ProductCard(
    productImageUrl: String,
    productTitle: String,
    productDescription: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Surface(
        modifier = modifier.clickable { onClick() },
        shape = MaterialTheme.shapes.medium,

        ) {
        Column(modifier = Modifier.padding(16.dp)) {
            GlideImage(
                model = productImageUrl,
                failure = placeholder(R.drawable.jetpack_compose_icon),
                contentDescription = "ProductImage",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = productTitle,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = productDescription,

                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
