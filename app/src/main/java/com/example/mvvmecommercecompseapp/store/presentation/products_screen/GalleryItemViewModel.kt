package com.example.mvvmecommercecompseapp.store.presentation.products_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmecommercecompseapp.store.domain.GalleryItemsRepository
import com.example.mvvmecommercecompseapp.store.presentation.util.sendEvent
import com.example.mvvmecommercecompseapp.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GalleryItemViewModel @Inject constructor(private val repository: GalleryItemsRepository) : ViewModel() {

    private val _state = MutableStateFlow(GalleryItemsViewState())
    val state = _state.asStateFlow()

    fun updateSearchQuery(query: String) {
        searchGalleryItems(query)
    }

    private  fun searchGalleryItems(query: String = "cats") {

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            repository.searchGallery(query).onLeft { error ->
                val errorMessage = error.statusCode?.takeIf { it != 0 }
                    ?.let { "${error.error.message} Code: $it" } ?: error.error.message

                _state.update { it.copy(error = errorMessage) }

                sendEvent(Event.Toast(errorMessage))

            }.onRight { galleryItems ->
                _state.update { it.copy(galleryItemList = galleryItems) }
            }

            _state.update { it.copy(isLoading = false) }
        }

    }

}

enum class ViewMode {
    List, Grid
}


