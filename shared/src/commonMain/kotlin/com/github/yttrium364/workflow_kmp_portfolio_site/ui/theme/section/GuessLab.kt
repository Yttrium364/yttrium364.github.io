package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.yttrium364.workflow_kmp_portfolio_site.GuessGame
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.GuessHint
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.GuessState

@Composable
fun GuessLab() {
    var state by remember {
        mutableStateOf<GuessState>(GuessGame.start())
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(copy(state))

        (GuessGame.min..GuessGame.max)
            .chunked(3)
            .forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    row.forEach { n ->
                        KeyChip(
                            label = "$n",
                            onClick = {
                                state = GuessGame.guess(state, n)
                            }
                        )
                    }
                }
            }
    }
}

@Composable
private fun KeyChip(
    label: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick
    ) {
        Text(label)
    }
}

private fun copy(state: GuessState): String {
    return when (state) {
        is GuessState.Playing -> when (state.lastHint) {
            GuessHint.Low -> "Too low"
            GuessHint.High -> "Too high"
            null -> "Guess a number from ${GuessGame.min} to ${GuessGame.max}"
        }
        is GuessState.Won -> "Correct in ${state.tries} tries!"
    }
}
