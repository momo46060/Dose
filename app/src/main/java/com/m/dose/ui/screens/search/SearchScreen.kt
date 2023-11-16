package com.m.dose.ui.screens.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.m.dose.ui.screens.MainViewModel
import com.m.dose.ui.theme.BlueLight
import com.m.dose.ui.theme.textColor
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
    var textfield by remember {
        mutableStateOf("")
    }
    val data by viewModel.data.collectAsState()

    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = modifier.fillMaxSize().padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
       Spacer(modifier = Modifier.height(S_PADDING))
        OutlinedTextField(
            modifier = Modifier
                .padding(S_PADDING)
                .fillMaxWidth(.9f)
                ,
            value = textfield, onValueChange = { text ->
                textfield = text
            },
            shape = RoundedCornerShape(S_PADDING),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor =BlueLight,
                textColor = Color.Black,
                focusedBorderColor = textColor, // Custom focused border color
                unfocusedBorderColor = Color.Gray // Custom unfocused border color
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
                Icon(modifier = Modifier.clickable {
                    focusManager.clearFocus(true)
                }, imageVector = Icons.Default.FilterList, contentDescription = null)
            },
            textStyle = TextStyle(color = textColor,textAlign = TextAlign.Left),
            label = { Text(text = "Search for drugs", style = TextStyle(color = textColor,textAlign = TextAlign.Left)) })
        SearchContent(data = data, onsearchClick = {})

    }

}