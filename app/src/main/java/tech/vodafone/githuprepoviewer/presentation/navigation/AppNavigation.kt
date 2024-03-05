package tech.vodafone.githuprepoviewer.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tech.vodafone.githuprepoviewer.presentation.feature.details.RepoDetailsScreen
import tech.vodafone.githuprepoviewer.presentation.feature.issues.IssuesScreen
import tech.vodafone.githuprepoviewer.presentation.feature.main.ReposScreen

enum class Screen {
    Repos,
    Details,
    Issues,
}
sealed class NavigationItem(val route: String) {
    object Repos : NavigationItem(Screen.Repos.name)
    object Details : NavigationItem(Screen.Details.name)
    object Issues : NavigationItem(Screen.Issues.name)
}
//class test{
//    fun addArgs(){
//
//    }
//
//    fun build():String{
//        return ""
//    }
//}
@Composable
fun AppNavigation(
    modifier: Modifier  = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Repos.route,
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavigationItem.Repos.route) { ReposScreen(
            navController = navController,
            modifier = modifier
        )
        }

        composable(NavigationItem.Details.route) {
            RepoDetailsScreen(
                navController = navController,
                modifier = modifier
            )
        }

        composable(NavigationItem.Issues.route) { IssuesScreen(navController = navController,modifier = modifier) }

    }



}
