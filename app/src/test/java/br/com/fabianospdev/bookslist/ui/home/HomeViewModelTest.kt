package br.com.fabianospdev.bookslist.ui.home

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import br.com.fabianospdev.bookslist.BookFactory
import br.com.fabianospdev.bookslist.model.book.Book
import br.com.fabianospdev.bookslist.rest.api.repository.DefaultRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.notNull

//https://www.youtube.com/watch?v=DPeLiKpZpA8  video com o conteudo
@RunWith(AndroidJUnit4::class)
class HomeViewModelTest {

    @get:Rule //to execute not in main trade but into this
    val rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        instrumentationContext = InstrumentationRegistry.getInstrumentation().context
    }

    private lateinit var instrumentationContext: Context
    private lateinit var repository: io.mockk.mockk<DefaultRepository>()
    private val bookFactory: BookFactory = mockk<BookFactory>()
    private val onDataLoadedObserver = mockk<Observer<List<Book>>>(relaxed = true)


    @Test
    fun `When HomeViewModel fetch data then it should a call to repository`() {
        val viewModel = instantiateViewModel()

        every { viewModel.getBooks() } returns mocklist

        val response = viewModel.getBooks()

        verify { viewModel.getBooks() }

        assertEquals(response.value, notNull())
    }

    private fun instantiateViewModel(): HomeViewModel {
        repository = DefaultRepository(instrumentationContext)
        val viewModel = HomeViewModel(repository)
        viewModel.getBooks().observeForever(onDataLoadedObserver)
        return viewModel
    }

    private val mocklist: LiveData<List<Book>> = MutableLiveData<List<Book>>(
        arrayListOf<Book>(
            //  bookFactory.createBook(
            Book(
                kind = "",
                id = "",
                etag = "",
                selfLink = "",
                volumeInfo = null,
                saleInfo = null,
                accessInfo = null,
                searchInfo = null
            ),
            //   ),
            //   bookFactory.createBook(
            Book(
                kind = "",
                id = "",
                etag = "",
                selfLink = "",
                volumeInfo = null,
                saleInfo = null,
                accessInfo = null,
                searchInfo = null
            )
            // )
        )
    )
}