package com.m.dose.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.m.dose.ui.screens.search.SearchScreen
import com.m.dose.ui.theme.Background
import com.m.dose.ui.theme.Blue
import com.m.dose.ui.theme.TopAppBarBackGround
import com.m.dose.ui.theme.backGroundtintColor
import com.m.dose.ui.theme.darkBackgroundgray
import com.m.dose.ui.theme.tabbarcontentBackground
import com.m.dose.utils.L_PADDING
import com.m.dose.utils.TabItem


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MainView(
) {
    val tabItems = listOf(
        TabItem(
            title = "Home",
            selectedImage = Icons.Outlined.Home,
            unselectedImage = Icons.Filled.Home
        ),
        TabItem(
            title = "Browse",
            selectedImage = Icons.Outlined.ShoppingCart,
            unselectedImage = Icons.Filled.ShoppingCart
        ),
        TabItem(
            title = "Account",
            selectedImage = Icons.Outlined.AccountCircle,
            unselectedImage = Icons.Filled.AccountCircle
        ),

        )
    var selectedIndex by remember { mutableStateOf(0) }
    val pagerstate = rememberPagerState { tabItems.size }
    LaunchedEffect(selectedIndex) { pagerstate.animateScrollToPage(selectedIndex) }
    LaunchedEffect(pagerstate.currentPage, pagerstate.isScrollInProgress) {
        if (!pagerstate.isScrollInProgress) {
            selectedIndex = pagerstate.currentPage
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = TopAppBarBackGround,
                ),
                title = {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Dose",
                        color = Color.White,
                        textAlign = TextAlign.Left
                    )
                },
                navigationIcon = {
                    Spacer(modifier = Modifier.width(L_PADDING))
                },
            )
        },
        bottomBar = {
            TabRow(selectedTabIndex = selectedIndex, indicator = {
            }) {
                tabItems.forEachIndexed { index, tabItem ->
                    Tab(
                        modifier = Modifier.background(tabbarcontentBackground),
                        selected = index == selectedIndex,
                        onClick = { selectedIndex = index },
                        text = {
                            Text(
                                text = tabItem.title,
                                color = backGroundtintColor
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedIndex) tabItem.unselectedImage else tabItem.selectedImage,
                                contentDescription = null,
                                tint = backGroundtintColor
                            )
                        },
                        selectedContentColor = Blue,
                        unselectedContentColor = Color.Gray,

                        )

                }
            }
        }
    ) { paddingValues ->

        HorizontalPager(
            state = pagerstate,
            modifier = Modifier
                .background(darkBackgroundgray)
                .fillMaxWidth()
                .padding(paddingValues)
        ) { index ->
            if (index == 0) {
                SearchScreen(modifier = Modifier.background(Background))
            } else {
                Box(modifier = Modifier
                    .background(Background)
                    .fillMaxSize()) {
                    Text(text = tabItems[index].title)
                }
            }
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Pre() {
    MainView()
}