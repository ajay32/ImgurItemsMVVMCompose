package com.example.mvvmecommercecompseapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.example.mvvmecommercecompseapp.store.presentation.products_screen.GalleryItemScreen
import com.example.mvvmecommercecompseapp.ui.theme.MvvmEcommerceCompseAppTheme
import com.example.mvvmecommercecompseapp.util.Event
import com.example.mvvmecommercecompseapp.util.EventBus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val lifeCycleOwner = LocalLifecycleOwner.current.lifecycle
            LaunchedEffect(key1 = lifeCycleOwner) {
                lifeCycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {// we are making it get event with respect to lifecycle
                    EventBus.events.collect { event ->
                        when(event) {
                            is Event.Toast -> {
                                Toast.makeText(this@MainActivity, event.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            }

            MvvmEcommerceCompseAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GalleryItemScreen()
                }
            }
        }
    }
}

