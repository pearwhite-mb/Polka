package ru.anlyashenko.feature.aura.impl

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.pearwhitemb.aura.Aura
import io.github.pearwhitemb.aura.AuraDefaults
import io.github.pearwhitemb.aura.AuraPalette
import kotlin.collections.map
import kotlin.random.Random

@Composable
fun AuraGeneratorScreen(modifier: Modifier = Modifier) {
    var palette by remember { mutableStateOf(AuraDefaults.Palette) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Aura(
            palette = palette,
            modifier = Modifier.size(320.dp),
        )

        Spacer(Modifier.height(48.dp))

        OutlinedButton(
            onClick = { palette = randomPalette() }
        ) {
            Text("Change colors")
        }
    }
}

private fun randomPalette(): AuraPalette {
    val colors = AuraDefaults.harmonicPalette(count = Random.nextInt(3, 6))
    return AuraPalette.weighted(colors.map { it to 0.3f + Random.nextFloat() })
}
