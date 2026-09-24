package com.github.yttrium364.workflow_kmp_portfolio_site.ui.theme.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.DiceRoll
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.DiceWinner
import com.github.yttrium364.workflow_kmp_portfolio_site.domain.winner
import kotlin.random.Random

@Composable
fun DicePage() {
    var firstDie by remember { mutableStateOf<Int?>(null) }
    var secondDie by remember { mutableStateOf<Int?>(null) }
    var roll by remember { mutableStateOf<DiceRoll?>(null) }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text("Dice", style = MaterialTheme.typography.headlineMedium)
        Text("First: ${firstDie ?: "—"}")
        Button(onClick = { firstDie = Random.nextInt(1, 7) }) {
            Text("Roll first die")
        }
        Text("Second: ${secondDie ?: "—"}")
        Button(onClick = { secondDie = Random.nextInt(1, 7) }) {
            Text("Roll second die")
        }
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Text("First: ${roll?.first ?: "—"}")
            Text("Second: ${roll?.second ?: "—"}")
        }
        roll?.let {
            Text(
                when (it.winner()) {
                    DiceWinner.First -> "First player wins!"
                    DiceWinner.Second -> "Second player wins!"
                    DiceWinner.Tie -> "It's a tie!"
                },
                style = MaterialTheme.typography.titleMedium,
            )
        }
        Button(onClick = {
            roll = DiceRoll(Random.nextInt(1, 7), Random.nextInt(1, 7))
        }) {
            Text("Roll")
        }
    }
}
