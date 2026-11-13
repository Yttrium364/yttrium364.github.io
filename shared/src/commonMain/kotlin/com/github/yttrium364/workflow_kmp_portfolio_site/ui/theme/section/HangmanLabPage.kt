package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.HangState
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.Hangman

@Composable
fun HangmanPage() {
    val secret = "KOTLIN"
    var state by remember { mutableStateOf<HangState>(Hangman.start(secret)) }
    val playing = state as? HangState.Playing

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text("Hangman", style = MaterialTheme.typography.headlineMedium)
        Text(Hangman.mask(state), style = MaterialTheme.typography.headlineSmall)
        Text("Misses: ${(playing?.misses ?: Hangman.maxMisses)} / ${Hangman.maxMisses}")
        when (val currentState = state) {
            is HangState.Won -> Text("You win!")
            is HangState.Lost -> Text("Game over. The word was ${currentState.secret}.")
            is HangState.Playing -> Unit
        }
        ('A'..'Z').toList().chunked(7).forEach { letters ->
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                letters.forEach { letter ->
                    KeyChip(
                        label = letter.toString(),
                        enabled = playing != null && letter !in playing.guessed,
                        onClick = { state = Hangman.guess(state, letter) },
                    )
                }
            }
        }
        Button(onClick = { state = Hangman.start(secret) }) {
            Text("Restart")
        }
    }
}
