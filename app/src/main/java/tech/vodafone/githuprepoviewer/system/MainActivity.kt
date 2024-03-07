package tech.vodafone.githuprepoviewer.system

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.talhafaki.composablesweettoast.util.SweetToastUtil
import dagger.hilt.android.AndroidEntryPoint
import tech.vodafone.githuprepoviewer.R
import tech.vodafone.githuprepoviewer.data.source.remote.NetworkMonitor
import tech.vodafone.githuprepoviewer.presentation.navigation.AppNavigation
import tech.vodafone.githuprepoviewer.presentation.theme.GithupRepoViewerTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var dataStoreUtil: DataStoreUtil

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    private var firstOpen = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataStoreUtil = DataStoreUtil(applicationContext)
        val systemTheme =
            when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                Configuration.UI_MODE_NIGHT_YES -> true
                Configuration.UI_MODE_NIGHT_NO -> false
                else -> false
            }

        setContent {
            val theme = dataStoreUtil.getTheme(systemTheme).collectAsState(initial = systemTheme)

            GithupRepoViewerTheme(
                darkTheme = theme.value,
            ) {
                val online by networkMonitor.isOnline.collectAsStateWithLifecycle(true)

                if (!online) {
                    SweetToastUtil.SweetError(message = getString(R.string.there_is_no_internet_connection))
                } else {
                    if (!firstOpen) {
                        SweetToastUtil.run { SweetSuccess(message = getString(R.string.internet_connection_come_back)) }
                        firstOpen = false
                    }
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(
                        modifier = Modifier,
                        dataStoreUtil = dataStoreUtil,
                        navHostController = rememberNavController()
                    )
                }
            }
        }
    }

}


