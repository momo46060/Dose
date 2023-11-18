package com.m.dose.ui.screens.search

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.m.dose.R
import com.m.dose.ui.screens.MainViewModel
import com.m.dose.ui.theme.BlueLight
import com.m.dose.ui.theme.colorShimmer
import com.m.dose.ui.theme.textColor
import com.m.dose.utils.L_PADDING
import com.m.dose.utils.S_PADDING
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(
    viewModel: MainViewModel = hiltViewModel(),
    modifier: Modifier
) {
    val transition = rememberInfiniteTransition(label = "").animateFloat(
        initialValue = 0.0f,
        targetValue = 390f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    val brush = Brush.linearGradient(
        colorShimmer,
        start = Offset.Zero,
        end = Offset(x = transition.value, y = transition.value)
    )
    var textFieldText by remember {
        mutableStateOf("")
    }
    var searchKind by remember {
        mutableStateOf("")
    }
    val data by viewModel.data.collectAsState()
    var showSheet by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        if (showSheet) {
            BottomSheet(onSelect = { value: String ->
                searchKind = value
            }, onDismiss = {
                showSheet = false
            })
        }
        Spacer(modifier = Modifier.height(S_PADDING))
        OutlinedTextField(
            modifier = Modifier
                .padding(S_PADDING)
                .fillMaxWidth(.9f),
            value = textFieldText, onValueChange = { text ->
                textFieldText = text
            },
            shape = RoundedCornerShape(S_PADDING),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor = BlueLight,
                focusedBorderColor = textColor,
                unfocusedBorderColor = Color.Gray
            ),
            maxLines = 1,
            keyboardOptions = KeyboardOptions.Default.copy(
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    keyboardController?.hide()
                    focusManager.clearFocus(true)
                    CoroutineScope(IO).launch {
                        viewModel.Serch("")
                    }
                }),
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
            trailingIcon = {
                Icon(modifier = Modifier
                    .height(40.dp)
                    .graphicsLayer(alpha = 0.99f)
                    .drawWithCache {
                        onDrawWithContent {
                            drawContent()
                            drawRect(brush, blendMode = BlendMode.SrcAtop)
                        }
                    }
                    .clickable {
                        focusManager.clearFocus(true)
                        showSheet = true
                    }  , painter = painterResource(id = R.drawable.filtters), contentDescription = null)
            },
            textStyle = TextStyle(color = textColor, textAlign = TextAlign.Left),
            label = {
                Text(
                    text = stringResource(R.string.search_for_drugs),
                    style = TextStyle(color = textColor, textAlign = TextAlign.Left)
                )
            })
        SearchContent(data = data, onsearchClick = {})
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit, onSelect: (String) -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()
    val radioOptions = listOf(
        stringResource(R.string.Trade_Name),
        stringResource(R.string.Generic_name), stringResource(R.string.The_company)
    )
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1]) }
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Column {
            radioOptions.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (text == selectedOption),
                            onClick = {
                                onOptionSelected(text)
                                onSelect(text)
                            }
                        )
                ) {
                    RadioButton(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                            onSelect(text)
                        }
                    )
                    Text(
                        text = text,
                        modifier = Modifier

                            .fillMaxWidth(0.32f)
                            .padding(start = 5.dp, top = 16.dp),
                        color = Color.White,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                    )

                }
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp))

            }

            Box(modifier = Modifier
                .padding(L_PADDING)
                .padding(horizontal = L_PADDING)
                .background(BlueLight)
                .padding(S_PADDING)
                .clickable { onDismiss() }
                .fillMaxWidth()) {
                Text(modifier = Modifier
                    .clip(RoundedCornerShape(L_PADDING))
                    .fillMaxWidth(), text = stringResource(R.string.confirm), style = TextStyle(
                    color = textColor,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                ))
            }
        }

    }

}
