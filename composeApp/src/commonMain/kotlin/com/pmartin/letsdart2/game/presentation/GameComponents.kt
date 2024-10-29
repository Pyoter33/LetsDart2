package com.pmartin.letsdart2.game.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.pmartin.letsdart2.core.presentation.util.Green
import com.pmartin.letsdart2.core.presentation.util.LightGrey
import com.pmartin.letsdart2.core.presentation.util.Orange
import com.pmartin.letsdart2.core.presentation.util.PrimaryColor
import com.pmartin.letsdart2.core.presentation.util.Red
import com.pmartin.letsdart2.core.presentation.util.SPACING_L
import com.pmartin.letsdart2.core.presentation.util.SPACING_M
import com.pmartin.letsdart2.core.presentation.util.SPACING_XXS

enum class ColorState(val color: Color) {
    NORMAL(PrimaryColor),
    DOUBLE(Green),
    TRIPLE(Orange),
    UNDO(Red);
}

data class ThrowScore(
    val score: Int,
    val isDouble: Boolean,
    val isTriple: Boolean,
    val isOverthrow: Boolean
) {
    override fun toString(): String {
        if (isOverthrow) return "OT"
        if (isDouble) return "D$score"
        if (isTriple) return "T$score"
        return score.toString()
    }
}

data class PlayerState(
    val playerName: String,
    val isActive: Boolean,
    val totalScore: Int,
    val roundScore: Int?,
    val firstThrowScore: ThrowScore?,
    val secondThrowScore: ThrowScore?,
    val thirdThrowScore: ThrowScore?,
    val legs: Int,
    val average: Float,
    val darts: Int
)

@Composable
fun PointButton(
    value: Int,
    colorState: ColorState,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            onClick(value)
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        shape = RoundedCornerShape(corner = CornerSize(SPACING_L)),
        border = BorderStroke(ButtonDefaults.OutlinedBorderSize, colorState.color),
        modifier = modifier
    ) {
        Text(
            text = value.toString(),
            style = MaterialTheme.typography.body2,
            overflow = TextOverflow.Visible,
        )
    }
}

@Composable
fun GameActionButton(
    text: String,
    color: Color,
    backgroundColor: Color?,
    onClick: () -> Unit,
    isToggled: Boolean = false,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = if (isToggled) backgroundColor ?: Color.White else Color.White),
        shape = RoundedCornerShape(corner = CornerSize(SPACING_L), ),
        border = BorderStroke(ButtonDefaults.OutlinedBorderSize, color),
        modifier = modifier
    ) {
        Text(
            text = text.uppercase(),
            style = MaterialTheme.typography.body2,
            overflow = TextOverflow.Visible,
        )
    }
}

@Composable
fun PlayerStats(playerState: PlayerState, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.border(
            if (playerState.isActive) BorderStroke(
                1.dp,
                PrimaryColor
            ) else BorderStroke(1.dp, LightGrey)
        ).background(
            shape = RoundedCornerShape(corner = CornerSize(SPACING_L)),
            color = Color.White
        )
    ) {
        Column {
            Text(text = playerState.playerName, style = MaterialTheme.typography.h6)
            Spacer(Modifier.size(SPACING_M))
            with(playerState) {
                PlayerScore(
                    totalScore = totalScore,
                    roundScore = roundScore,
                    firstThrowScore = firstThrowScore,
                    secondThrowScore = secondThrowScore,
                    thirdThrowScore = thirdThrowScore,
                    legs = legs,
                    average = average,
                    darts = darts
                )
            }
        }
    }
}

@Composable
fun PlayerScore(
    totalScore: Int,
    roundScore: Int?,
    firstThrowScore: ThrowScore?,
    secondThrowScore: ThrowScore?,
    thirdThrowScore: ThrowScore?,
    legs: Int,
    average: Float,
    darts: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.height(IntrinsicSize.Min)) {
        MainScoreCell(score = totalScore, darts = darts, modifier = Modifier.weight(2f).fillMaxWidth())
        VerticalDivider(modifier = Modifier.padding(horizontal = SPACING_XXS))
        Column(modifier = Modifier.weight(6f)) {
            Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                StatCell(text = firstThrowScore?.toString(), label = "Throw", modifier = Modifier.weight(1f))
                VerticalDivider(modifier = Modifier.padding(horizontal = SPACING_XXS))
                StatCell(text = secondThrowScore?.toString(), label = null, modifier = Modifier.weight(1f))
                VerticalDivider(modifier = Modifier.padding(horizontal = SPACING_XXS))
                StatCell(text = thirdThrowScore?.toString(), label = null, modifier = Modifier.weight(1f))
            }
            HorizontalDivider(modifier = Modifier.padding(vertical = SPACING_XXS))
            StatCell(text = roundScore?.toString(), label = "Round", modifier = Modifier.weight(6f).fillMaxWidth())
        }
        VerticalDivider(modifier = Modifier.padding(horizontal = SPACING_XXS))
        Column(modifier = Modifier.weight(3f).fillMaxWidth()) {
            StatCell(text = average.toString(), label = "Average", modifier = Modifier.fillMaxWidth().weight(1f))
            HorizontalDivider(modifier = Modifier.padding(vertical = SPACING_XXS))
            StatCell(text = legs.toString(), label = "Legs", modifier = Modifier.fillMaxWidth().weight(1f))
        }
    }
}

@Composable
fun MainScoreCell(
    score: Int,
    darts: Int,
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceBetween, modifier = modifier.fillMaxHeight()) {
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth())  {
            Icon(Icons.Default.Done, contentDescription = null)
            Text(text = darts.toString(), style = MaterialTheme.typography.caption)
        }
        Text(text = score.toString(), style = MaterialTheme.typography.h5)
        Text(text = "Score", style = MaterialTheme.typography.caption, modifier = Modifier.align(Alignment.Start))
    }
}

@Composable
fun StatCell(text: String?, label: String?, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        text?.let {
            Text(text = it, style = MaterialTheme.typography.body1)
        }
        label?.let {
            Text(text = it, style = MaterialTheme.typography.caption, modifier = Modifier.align(Alignment.Start))
        }
    }
}

@Composable
fun HorizontalDivider(modifier: Modifier = Modifier) {
    Divider(
        color = Color.Black,
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun VerticalDivider(modifier: Modifier = Modifier) {
    Divider(
        color = Color.Black,
        modifier = modifier.width(1.dp).fillMaxHeight()
    )
}