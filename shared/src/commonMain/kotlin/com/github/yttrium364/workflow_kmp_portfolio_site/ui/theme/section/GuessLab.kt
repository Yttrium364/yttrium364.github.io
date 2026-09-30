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

@Composable
fun GuessLab() {
    var state by remember {
        mutableStateOf(GuessGame.start())
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

private fun copy(state: GuessGame.State): String {
    return when (state) {
        is GuessGame.State.Playing -> state.hint
        is GuessGame.State.Correct -> "Correct!"
    }
}