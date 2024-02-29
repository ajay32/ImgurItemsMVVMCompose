package com.example.mvvmecommercecompseapp.store.presentation.products_screen

import app.cash.turbine.test
import arrow.core.Either
import com.example.mvvmecommercecompseapp.store.domain.GalleryItemsRepository

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher

import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Rule
import org.junit.rules.TestRule

import org.junit.runner.Description
import org.junit.runners.model.Statement

import org.mockito.Mockito.*
import kotlin.time.ExperimentalTime


@ExperimentalCoroutinesApi
@ExperimentalTime
class GalleryItemViewModelTest {

    @get:Rule
    val coroutinesTestRule = CoroutineTestRule()

    private lateinit var viewModel: GalleryItemViewModel
    private val repository = mockk<GalleryItemsRepository>()

    @Before
    fun setUp() {
        // Setup Dispatchers.Main to use TestCoroutineDispatcher
        Dispatchers.setMain(coroutinesTestRule.testDispatcher)

        // Arrange: Mock the repository's searchGallery function to return a successful but empty result
        coEvery { repository.searchGallery(any()) } returns Either.Right(listOf())

        // Initialize the ViewModel with the mocked repository
        viewModel = GalleryItemViewModel(repository)
    }

    @Test
    fun `updateSearchQuery triggers loading state then updates with gallery items`() = runTest {
        // Arrange: Prepare a list to collect states emitted by the ViewModel
        val stateHistory = mutableListOf<GalleryItemsViewState>()

        // Act: Start collecting states in a coroutine
        val job = launch(coroutinesTestRule.testDispatcher) {
            viewModel.state.test {
                stateHistory.add(awaitItem()) // Collect initial state
                stateHistory.add(awaitItem()) // Collect loading state
                stateHistory.add(awaitItem()) // Collect final state after search
            }
        }

        // Act: Trigger the search query update in the ViewModel
        viewModel.updateSearchQuery("cats")

        // Wait for the coroutine collecting states to finish
        job.join()

        // Assert: Verify that the states changed as expected
        assertEquals(true, stateHistory[1].isLoading) // "The ViewModel should indicate loading after search query update.")
        assertEquals(false, stateHistory.last().isLoading) // "The ViewModel should not be loading after search results are loaded.")
        assertEquals(0, stateHistory.last().galleryItemList.size) // "The search result should be an empty list.")

        // Cleanup after the test
        job.cancel()
    }

    @After
    fun tearDown() {
        // Reset the main dispatcher to its original state
        Dispatchers.resetMain()
    }
}

@ExperimentalCoroutinesApi
class CoroutineTestRule(val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()) : TestRule {
    override fun apply(base: Statement?, description: Description?): Statement = object : Statement() {
        @Throws(Throwable::class)
        override fun evaluate() {
            Dispatchers.setMain(testDispatcher)

            base?.evaluate()

            Dispatchers.resetMain() // Reset after test
            testDispatcher.cleanupTestCoroutines()
        }
    }
}
