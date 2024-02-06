package mo.inc.eh.products.presentation.screens.details

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import mo.inc.eh.products.R
import mo.inc.eh.products.domian.entity.Product
import mo.inc.eh.products.presentation.components.ErrorState
import mo.inc.eh.products.presentation.components.LoadingState
import mo.inc.eh.products.utils.UiState

@Composable
fun DetailScreen(state: UiState<Product>) {
    when (state) {
        is UiState.Failure -> ErrorState(state.error)
        UiState.Loading -> LoadingState()
        is UiState.Success -> ProductInDetailed(state.data)

    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun ProductInDetailed(product: Product) {


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Portrait layout
            Text(text = product.name)
            Spacer(modifier = Modifier.height(16.dp))
            GlideImage(
                model = product.image_url,
                failure = placeholder(R.drawable.jetpack_compose_icon),

                contentDescription = null,
                modifier = Modifier.size(200.dp),
            )
        } else {
            // Landscape layout
            Row(modifier = Modifier.fillMaxWidth()) {
                GlideImage(
                    model = product.image_url,
                    failure = placeholder(R.drawable.jetpack_compose_icon),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp),
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = product.name)
            }
        }
    }
}


