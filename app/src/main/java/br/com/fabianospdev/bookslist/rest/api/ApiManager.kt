package br.com.fabianospdev.bookslist.rest.api

import androidx.lifecycle.MutableLiveData
import br.com.fabianospdev.bookslist.model.book.Book
import br.com.fabianospdev.bookslist.ui.home.HomeViewModel
import br.com.fabianospdev.bookslist.utils.Shared

object ApiManager {

    fun getBooks(mContext: HomeViewModel, aParam: String): MutableLiveData<Book> {
        val items = arrayListOf<Book>()
        ApiClient().getBooks(mContext, aParam,
            {
                Shared.instance.recording = it
                for (item in it.items!!) {
                    items.add(item)
                }

            }
        ) {
            print("Error request Books")
        }
        return items as MutableLiveData<Book>
    }
}