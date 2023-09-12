package composables.appbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ColorLens
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import themes.AppTheme
import themes.ApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    appBarTitle: String,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    themeState: AppTheme,
    showBackButton: Boolean,
    backButtonListener: () -> Unit,
    themeSwitcherListener: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    var themeSwitcherDialogState by remember { mutableStateOf(false) }

    if (themeSwitcherDialogState) {
        // show theme switcher dialog
    }


    TemplateAppBar(
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        title = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = appBarTitle,
                    style = ApplicationTheme.typography.headlineMedium,
                    color = Color.Black
                )
            }
        },
        showBackButton = showBackButton,
        backButtonListener = backButtonListener,
        actions = {
            // Theme icon
            Icon(
                imageVector = Icons.Outlined.ColorLens,
                tint = Color.Black,
                modifier = Modifier
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = { themeSwitcherDialogState = true }
                    )
                    .padding(horizontal = 12.dp, vertical = 16.dp)
                    .height(24.dp),
                contentDescription = null
            )
            // Info icon
            Icon(
                imageVector = Icons.Outlined.Info,
                tint = Color.Black,
                modifier = Modifier
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = {
                            //todo smth
                        }
                    )
                    .padding(horizontal = 12.dp, vertical = 16.dp)
                    .height(24.dp),
                contentDescription = null
            )
        }
    )
}
