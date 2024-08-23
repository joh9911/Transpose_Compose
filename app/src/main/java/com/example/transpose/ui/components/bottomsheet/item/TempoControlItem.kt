package com.example.transpose.ui.components.bottomsheet.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.transpose.R


@Composable
fun TempoControlItem() {
    Column(modifier = Modifier.padding(10.dp)) {
        Text("Tempo")
        Row {
            IconButton(onClick = { /* Decrease tempo */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_exposure_neg_1_24),
                    contentDescription = "Decrease tempo"
                )
            }
            IconButton(onClick = { /* Reset tempo */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_replay_24),
                    contentDescription = "Reset tempo"
                )
            }
            IconButton(onClick = { /* Increase tempo */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_exposure_plus_1_24),
                    contentDescription = "Increase tempo"
                )
            }
        }
    }
}