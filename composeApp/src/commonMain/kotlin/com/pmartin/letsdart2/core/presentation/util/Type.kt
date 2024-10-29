package com.pmartin.letsdart2.core.presentation.util

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import letsdart2.composeapp.generated.resources.Res
import letsdart2.composeapp.generated.resources.lato_black
import letsdart2.composeapp.generated.resources.lato_bold
import letsdart2.composeapp.generated.resources.lato_light
import letsdart2.composeapp.generated.resources.lato_regular
import letsdart2.composeapp.generated.resources.lato_thin
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AppFontFamily() = FontFamily(
    Font(Res.font.lato_light, weight = FontWeight.Light),
    Font(Res.font.lato_thin, weight = FontWeight.Thin),
    Font(Res.font.lato_regular, weight = FontWeight.Normal),
    Font(Res.font.lato_regular, weight = FontWeight.Medium),
    Font(Res.font.lato_bold, weight = FontWeight.SemiBold),
    Font(Res.font.lato_bold, weight = FontWeight.Bold),
    Font(Res.font.lato_black, weight = FontWeight.Black)
)

@Composable
fun AppTypography() = Typography().apply {
        val fontFamily = AppFontFamily()
        copy(
            h1 = h1.copy(fontFamily = fontFamily),
            h2 = h2.copy(fontFamily = fontFamily),
            h3 = h3.copy(fontFamily = fontFamily),
            h4 = h4.copy(fontFamily = fontFamily),
            h5 = h5.copy(fontFamily = fontFamily),
            h6 = h6.copy(fontFamily = fontFamily),
            subtitle1 = subtitle1.copy(fontFamily = fontFamily),
            subtitle2 = subtitle2.copy(fontFamily = fontFamily),
            body1 = body1.copy(fontFamily = fontFamily),
            body2 = body2.copy(fontFamily = fontFamily),
            button = button.copy(fontFamily = fontFamily),
            caption = caption.copy(fontFamily = fontFamily, color = LightGrey),
            overline = overline.copy(fontFamily = fontFamily)
        )
    }
