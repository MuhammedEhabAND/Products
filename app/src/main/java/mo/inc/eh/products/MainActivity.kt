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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import mo.inc.eh.products.presentation.screens.details.DetailScreen
import mo.inc.eh.products.presentation.screens.home.HomeScreen
import mo.inc.eh.products.presentation.screens.home.HomeViewModel
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
    val homeViewModel: HomeViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {

        composable(route = "home") {
            val uiState = homeViewModel.productsState.collectAsStateWithLifecycle()
            HomeScreen(state = uiState.value , navController = navController , homeViewModel = homeViewModel)
        }
        composable(route = "details") {

            val uiState = homeViewModel.productState.collectAsStateWithLifecycle()
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