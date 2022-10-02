package br.com.fabianospdev.bookslist.ui.home

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fabianospdev.bookslist.BookFactory
import br.com.fabianospdev.bookslist.model.book.Book
import br.com.fabianospdev.bookslist.rest.api.ApiManager
import br.com.fabianospdev.bookslist.rest.api.BookCallBack

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
       // val list: MutableList<Book> = arrayListOf()
        ApiManager.getBooks(Activity(),"Lua Nova", object : BookCallBack {
            override fun onBookCallBack(list: MutableList<Book>) {
                list.forEach {
                    BookFactory().createBook(it)
                }
            }
        })
    }
}