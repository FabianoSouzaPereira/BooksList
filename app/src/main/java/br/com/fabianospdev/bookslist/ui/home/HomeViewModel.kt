package br.com.fabianospdev.bookslist.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fabianospdev.bookslist.R
import br.com.fabianospdev.bookslist.model.book.Book
import br.com.fabianospdev.bookslist.rest.api.repository.DefaultRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: DefaultRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            loadData()
        }
    }

    private val _text = MutableLiveData<String>().apply {
        value = repository.context.getString(R.string.library)
    }
    val text: LiveData<String> = _text

    private var _books: MutableLiveData<MutableList<Book>> = MutableLiveData<MutableList<Book>>()
    val books: LiveData<MutableList<Book>>
        get() = _books

    private suspend fun loadData() {
        repository.getBooks(
            this,
            repository.context.getString(R.string.flower),
            {
                val success = it.items ?: arrayListOf()
                val books = MutableLiveData<MutableList<Book>>()
                books.plusAssign(success)
                _books = books
            }
        ) {
            println(it)
        }
    }

    operator fun <T> MutableLiveData<MutableList<T>>.plusAssign(item: MutableList<T>) {
        val value = this.value ?: mutableListOf()
        value += item
        this.value = value
    }

}



