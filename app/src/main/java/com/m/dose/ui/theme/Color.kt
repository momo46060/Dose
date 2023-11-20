package com.m.dose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFF095d7e)
val PurpleGrey80 = Color(0xFF095d7e)
val Pink80 = Color(0xFF095d7e)

val Purple40 = Color(0xFF095d7e)
val PurpleGrey40 = Color(0xFF095d7e)
val Pink40 = Color(0xFF095d7e)
val Blue = Color(0xFF095d7e)
val lightblue = Color(0xFFE8F5F7)
val darkGray = Color(0xFF2B2D30)
val darkBackgroundgray = Color(0xFF1E1F22)
val BlueLight = Color(0xFF38B5FE)
val heighLight = Color(0xFFccecee)
val contentBackGround = Color(0xFFf1f9ff)



val colorShimmer: List<Color>
    @Composable
    get() = if (isSystemInDarkTheme()) listOf(
        darkGray.copy(alpha = 0.9f),
        darkGray.copy(alpha = 0.2f),
        darkGray.copy(alpha = 0.9f),
    ) else listOf(
        BlueLight.copy(alpha = 0.99f),
        BlueLight.copy(alpha = 0.1f),
        BlueLight.copy(alpha = 0.99f),
    )
val ShdowColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.White else Color.LightGray
val textColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.White else Color.Black
val navbarbackground: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.White else darkGray
val statusbarbackground: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Blue else Blue
val tabbarcontentcolor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color.White else darkGray
val tabbarcontentBackground: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.White else darkGray
val Background: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.White else darkBackgroundgray
val TopAppBarBackGround: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) BlueLight else darkGray
val backGroundtintColor: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) darkGray else Color.White
val CardBackground: Color
    @Composable
    get() = if (!isSystemInDarkTheme()) lightblue else darkGray
