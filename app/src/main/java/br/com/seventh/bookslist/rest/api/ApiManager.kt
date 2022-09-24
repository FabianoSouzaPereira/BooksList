package br.com.seventh.bookslist.rest.api

import android.content.Context

object ApiManager {
    val accept = "Accept: application/json,text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"
    val contentType = "Content-Type: application/octet-stream"

    fun getBooks(mContext: Context, aParam: String, Object: BookCallBack?){
        ApiClient().getBooks(mContext, accept, contentType, aParam,
            {
                if(it.isNotEmpty()){
                    Object?.onBookCallBack(it.toMutableList())
                }
            },
            {
                print("Error request Books")
            }
        )
    }
}