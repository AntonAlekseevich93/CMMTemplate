
import androidx.compose.runtime.Stable
import composables.AppScreenState
import data.TemplateUiState
import di.Inject.instance
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import repository.Repository
import themes.AppTheme

@Stable
class MainViewModel() {
    private val scope = CoroutineScope(Dispatchers.Unconfined + SupervisorJob())
    private val repository = Repository(instance())
    private var selectedThemeFromStorage = AppTheme.LIGHT

    private val _templateUiState: MutableStateFlow<TemplateUiState> =
        MutableStateFlow(TemplateUiState())
    val templateUiState: StateFlow<TemplateUiState> = _templateUiState

    private val httpClient = HttpClient {
        install(HttpTimeout)

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })

        }
    }
    private val authorizationKey: String = ""
    private val _screenState: MutableStateFlow<AppScreenState> =
        if (authorizationKey.isNotEmpty())
            MutableStateFlow(AppScreenState.STATE_2)
        else
            MutableStateFlow(AppScreenState.STATE_1)
    val screenState: StateFlow<AppScreenState> = _screenState

    private val _themeMode: MutableStateFlow<AppTheme> = MutableStateFlow(selectedThemeFromStorage)
    val themeMode: StateFlow<AppTheme> = _themeMode

    fun switchTheme() {
        scope.launch {
            when (_themeMode.value) {
                AppTheme.DARK -> {
                    _themeMode.value = AppTheme.LIGHT
                }

                else -> {
                    _themeMode.value = AppTheme.DARK
                }
            }
        }
    }

//    private suspend fun sendRequest(messageRequest: String) {
//        val httpResponse = httpClient
//            .post("URL") {
//                timeout {
//                    requestTimeoutMillis = 60000
//                }
//                url {
//                    contentType(ContentType.Application.Json)
//                    parameters.append("model", "cmmtemplate-4")
//                    retry {
//                        retryOnException(retryOnTimeout = true, maxRetries = 3)
//                    }
//                    header(
//                        "Authorization",
//                        "Bearer $authorizationKey"
//                    )
//                    setBody(
//                        BodyDto(
//                            model = template,
//                            messages = listOf(
//                                Template()
//                            )
//                        )
//                    )
//                }
//            }.body<DTO>()
//    }
}

