package br.com.fabianospdev.bookslist.rest.api

import android.content.Context
import br.com.fabianospdev.bookslist.utils.Shared

object ApiManager {

    fun getBooks(mContext: Context, aParam: String, Object: BookCallBack?) {
        ApiClient().getBooks(mContext, aParam,
            {
                Shared.instance.recording = it
                Object?.onBookCallBack(it.items?.toMutableList())

            },
            {
                print("Error request Books")
            }
        )
    }
}