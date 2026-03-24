package zxcoiv.com.github.projetocarreiras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import zxcoiv.com.github.projetocarreiras.screens.LoginScreen
import zxcoiv.com.github.projetocarreiras.screens.MenuScreen
import zxcoiv.com.github.projetocarreiras.screens.PedidosScreen
import zxcoiv.com.github.projetocarreiras.screens.PerfilScreen
import zxcoiv.com.github.projetocarreiras.ui.theme.ProjetoCarreirasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProjetoCarreirasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                    ) {
                        composable(route = "login") {
                            LoginScreen(modifier = Modifier.padding(innerPadding),
                                navController)
                        }
                        composable(route = "menu") {
                            MenuScreen(modifier = Modifier.padding(innerPadding),
                                navController)
                        }
                        composable(
                            route = "pedidos?cliente={cliente}",
                            arguments = listOf(navArgument("cliente") {
                                defaultValue = "Cliente Genérico"
                            })
                        ) {
                            PedidosScreen(modifier = Modifier.padding(innerPadding),
                                navController, it.arguments?.getString("Cliente"))
                        }
                        composable(
                            route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument("nome") { type = NavType.StringType },
                                navArgument("idade") { type = NavType.IntType },
                            )

                        ) {
                            var nome: String? = it.arguments?.getString("nome", "Usuário Genérico")
                            PerfilScreen(modifier = Modifier.padding(innerPadding),
                                navController, nome!!, idade!!)
                        }
                    }
                }
            }
        }
    }
}