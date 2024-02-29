package com.example.mvvmecommercecompseapp.store.presentation.products_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mvvmecommercecompseapp.store.presentation.products_screen.components.GalleryItemCard
import com.example.mvvmecommercecompseapp.store.presentation.products_screen.components.SearchBar
import com.example.mvvmecommercecompseapp.store.presentation.util.components.LoadingDialog
import com.example.mvvmecommercecompseapp.store.presentation.util.components.MyTopAppBar
import kotlin.reflect.KFunction1


@Composable
fun GalleryItemScreen() {
    val viewModel: GalleryItemViewModel = hiltViewModel()
    var viewMode by remember { mutableStateOf(ViewMode.List) }
    val state by viewModel.state.collectAsStateWithLifecycle(initialValue = GalleryItemsViewState())
    GalleryItemContent(state = state, viewModel::updateSearchQuery) // HOF
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GalleryItemContent(state: GalleryItemsViewState, onQueryChanged: (String) -> Unit) {
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopAppBar(text = "GalleryItems")
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            SearchBar(onQueryChanged = onQueryChanged)
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalItemSpacing = 10.dp
            ) {
                items(state.galleryItemList) { galleryItem ->
                    GalleryItemCard(galleryItem = galleryItem)
                }
            }
        }


    }
}

