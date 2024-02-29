package com.example.mvvmecommercecompseapp.store.presentation.products_screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvvmecommercecompseapp.store.presentation.products_screen.ViewMode

@Composable
fun ViewModeToggle(viewMode: ViewMode, onModeChange: (ViewMode) -> Unit) {
    Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
        Text("List")
        Switch(
            checked = viewMode == ViewMode.Grid,
            onCheckedChange = { isChecked ->
                onModeChange(if (isChecked) ViewMode.Grid else ViewMode.List)
            }
        )
        Text("Grid")
    }
}
