package mo.inc.eh.products

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import mo.inc.eh.products.presentation.screens.details.DetailScreen
import mo.inc.eh.products.presentation.screens.home.HomeScreen
import mo.inc.eh.products.presentation.viewmodel.SharedViewModel
import mo.inc.eh.products.ui.theme.ProductsTheme
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ProductsApp()
                }
            }
        }
    }
}
@Composable
private fun ProductsApp(){
    val navController = rememberNavController()
    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {

        composable(route = "home") {
            val uiState = sharedViewModel.productsState.collectAsStateWithLifecycle()
            HomeScreen(state = uiState.value , navController = navController , sharedViewModel = sharedViewModel)
        }
        composable(route = "details") {

            val uiState = sharedViewModel.productState.collectAsStateWithLifecycle()
            DetailScreen(state = uiState.value)
        }


    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProductsTheme {
        Greeting("Android")
    }
}