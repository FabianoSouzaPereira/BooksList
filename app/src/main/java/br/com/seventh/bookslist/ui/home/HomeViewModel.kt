package br.com.seventh.bookslist.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.seventh.bookslist.model.book.Book

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Biblioteca"
    }
    val text: LiveData<String> = _text

    val books: MutableLiveData<List<Book>> by lazy {
        MutableLiveData<List<Book>>().also {
            loadBooks()
        }
    }

    fun getBooks(): LiveData<List<Book>> {
        return books
    }

    private fun loadBooks() {
        val list: MutableList<Book> = arrayListOf()
    }
}