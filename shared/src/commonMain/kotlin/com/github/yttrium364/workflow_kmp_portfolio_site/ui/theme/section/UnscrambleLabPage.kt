package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.UnscrambleBank
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.scramble
import com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.LocalCopy

@Composable
fun UnscramblePage() {
    val copy = LocalCopy.current
    var typed by remember { mutableStateOf("") }
    var solved by remember { mutableStateOf(false) }
    var state by remember { mutableStateOf(UnscrambleBank.nextRound()) }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(state.mixed)
        OutlinedTextField(
            value = typed,
            onValueChange = { typed = it },
            singleLine = true
        )
        Button(
            onClick = {
                solved = UnscrambleBank.matches(state.secret, typed)
            }
        ) {
            Text(copy.check)
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    state = state.copy(mixed = scramble(state.secret))
                    typed = ""
                    solved = false
                }
            ) {
                Text(copy.newLetters)
            }
            Button(
                onClick = {
                    state = UnscrambleBank.nextRound(previousSecret = state.secret)
                    typed = ""
                    solved = false
                }
            ) {
                Text(copy.start)
            }
        }
    }
}
