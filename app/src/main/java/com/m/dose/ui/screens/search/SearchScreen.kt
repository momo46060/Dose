package com.m.dose.ui.screens.search

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.m.dose.ui.screens.MainViewModel

@Composable
fun SearchScreen(
    viewModel: MainViewModel = hiltViewModel(),
    modifier: Modifier
) {
    val data by viewModel.data.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.Serch("")
    }
    Box(modifier = modifier) {
        SearchContent(data = data)

    }

}