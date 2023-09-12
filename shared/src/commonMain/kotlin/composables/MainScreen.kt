package composables

import MainViewModel
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Composable
@Suppress("FunctionName")
fun MainScreen(
    viewModel: MainViewModel,
) {
    val scrollState = rememberLazyListState()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val screenState by viewModel.screenState.collectAsState()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerShape = NavShape(300.dp, 0f),
    ) {
        when (screenState) {
            AppScreenState.STATE_1 -> {
                AnimatedVisibility(screenState == AppScreenState.STATE_1) {
                    Template()
                }
            }

            AppScreenState.STATE_2 -> {
                AnimatedVisibility(screenState == AppScreenState.STATE_2) {

                }
            }
        }
    }
}

enum class AppScreenState{
   STATE_1,
   STATE_2
}

private class NavShape(
    private val widthOffset: Dp,
    private val scale: Float,
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        return Outline.Rectangle(
            Rect(
                Offset.Zero,
                Offset(
                    size.width * scale + with(density) { widthOffset.toPx() },
                    size.height
                )
            )
        )
    }
}