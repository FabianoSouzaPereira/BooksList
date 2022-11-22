package br.com.fabianospdev.bookslist.ui.home

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fabianospdev.bookslist.model.book.Book
import br.com.fabianospdev.bookslist.rest.api.repository.DefaultRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(val repository: DefaultRepository) : ViewModel() {
    // private var books: MutableList<Book>? = null
    private val _text = MutableLiveData<String>().apply {
        value = "Biblioteca"
    }
    val text: LiveData<String> = _text

    private val _books: MutableLiveData<Book> = MutableLiveData<Book>().also {
        repository.getBooks(Activity(), "flowers", {
            it.items?.toMutableList()!!
        }, {
            print(it)
        })
    }

//    private val _books: MutableLiveData<Book> = MutableLiveData<Book>().observe(this, books){
//
//    }

    val books: MutableLiveData<Book> = _books


    //  @JvmName("getBooksViewModel")
    fun getBooksViewModel(): LiveData<Book> {
        return books
    }

//    @JvmName("getBooksViewModel")
//    fun getBooksViewModel() {
//        val books: MutableLiveData<Book?> = MutableLiveData<Book?>()
//        repository.getBooks(Activity(), "flowers", {}, {})
//    }

}