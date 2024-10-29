package com.pmartin.letsdart2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pmartin.letsdart2.core.presentation.util.AppTheme
import com.pmartin.letsdart2.game.presentation.PlayerState
import com.pmartin.letsdart2.game.presentation.PlayerStats
import com.pmartin.letsdart2.game.presentation.ThrowScore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}

@Preview(widthDp = 393, showBackground = true)
@Composable
fun AppAndroidPreview() {
    AppTheme {

        val playerState = PlayerState(
            playerName = "Pyoter",
            isActive = false,
            totalScore = 200,
            roundScore = 34,
            firstThrowScore = ThrowScore(10, false, false, false),
            secondThrowScore = ThrowScore(8, true, false, false),
            thirdThrowScore = null,
            legs = 1,
            average = 56.4f,
            darts = 4
        )


        PlayerStats(playerState)


//        Column {
//            var value = 0
//            for (i in 0..2) {
//                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
//                    for (j in 0..6) {
//                        PointButton(
//                            value = value,
//                            colorState = ColorState.NORMAL,
//                            onClick = {},
//                            modifier = Modifier.weight(1f)
//                        )
//                        value++
//                    }
//                }
//            }
//            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
//                PointButton(
//                    value = 25,
//                    colorState = ColorState.NORMAL,
//                    onClick = {},
//                    modifier = Modifier.weight(1f)
//                )
//                GameActionButton(
//                    text = "Double",
//                    color = ColorState.DOUBLE.color,
//                    backgroundColor = LightGreen,
//                    onClick = { },
//                    isToggled = true,
//                    modifier = Modifier.weight(2f)
//                )
//                GameActionButton(
//                    text = "Triple",
//                    color = ColorState.TRIPLE.color,
//                    backgroundColor = LightOrange,
//                    onClick = { },
//                    isToggled = true,
//                    modifier = Modifier.weight(2f)
//                )
//                GameActionButton(
//                    text = "Undo",
//                    color = ColorState.UNDO.color,
//                    backgroundColor = null,
//                    onClick = { },
//                    modifier = Modifier.weight(2f)
//                )
//            }
//        }
    }
}