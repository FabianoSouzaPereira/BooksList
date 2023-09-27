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
        loadData()
    }

    private val _text = MutableLiveData<String>().apply {
        value = repository.context.getString(R.string.library)
    }
    val text: LiveData<String> = _text
    
    private var _books: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks(): LiveData<List<Book>> {
        return _books
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getBooks(
                this@HomeViewModel,
                repository.context.getString(R.string.flower),
                {
                    val success = it.items ?: arrayListOf()
                    val books = MutableLiveData<List<Book>>()
                    books.plusAssign(success)
                    _books.value = books.value
                },
                {
                    println(it)
                }
            )
        }
    }

//    operator fun <T> MutableLiveData<MutableList<T>>.plusAssign(item: MutableList<T>) {
//        val value = this.value ?: mutableListOf()
//        value += item
//        this.value = value
//    }

}

private fun <T> MutableLiveData<List<T>>.plusAssign(item: MutableList<T>) {
    var value = this.value ?: mutableListOf()
    value += item
    this.value = value
}

