import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import composables.MainScreen
import themes.AppTheme

@Composable
@Suppress("FunctionName")
fun Application(anyEvent : () -> Unit) {
    val viewModel = remember { MainViewModel() }
    val theme by viewModel.themeMode.collectAsState()
    AppTheme(appTheme = theme) {
        MainScreen(
            viewModel = viewModel
        )
    }
}