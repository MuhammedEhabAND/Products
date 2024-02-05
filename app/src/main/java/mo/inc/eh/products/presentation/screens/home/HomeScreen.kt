package mo.inc.eh.products.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
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
fun showData(products: List<Product>) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(products) { product ->
                ProductItem(product = product, onClick = {  })
            }
        }
    }
}


@Composable
fun ProductItem(product: Product, onClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        ProductCard(
            productImageUrl = product.image_url,
            productTitle = product.name,
            productDescription = product.description,
            modifier = Modifier.weight(1f)
        ) {
            onClick() // Handle click on first card
        }
        Spacer(modifier = Modifier.width(8.dp))
        ProductCard(
            productImageUrl = product.image_url,
            productTitle = product.name,
            productDescription = product.description,
            modifier = Modifier.weight(1f)
        ) {
            onClick() // Handle click on second card
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
                contentDescription = null,
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
