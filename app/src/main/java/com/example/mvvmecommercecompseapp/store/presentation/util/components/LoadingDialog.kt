package com.example.mvvmecommercecompseapp.store.presentation.util.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

// we have to show the dialog when data is loading so it will accept loading state
// put resuable components here in components folder so that it can be used in differnt screens

@Composable
fun LoadingDialog(isLoading: Boolean) {
    if(isLoading){
        Dialog( // white color dialog box.
            onDismissRequest = { /*TODO*/ },
            properties = DialogProperties(dismissOnClickOutside = false)
        ) { //putting framelayout inside it
            Box( // FrameLayout to put circular Loader in the Dialog
                modifier = Modifier
                    .width(200.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center

            ) { // putting loader inside Box
                CircularProgressIndicator(modifier = Modifier.padding(10.dp))
            }

        }
    }

}