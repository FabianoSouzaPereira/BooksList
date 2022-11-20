package br.com.fabianospdev.bookslist.rest.api

import br.com.fabianospdev.bookslist.utils.Constants
import br.com.fabianospdev.bookslist.utils.Constants.API_RESPONSE_TEMPORARYREDIRECT
import br.com.fabianospdev.bookslist.utils.Constants.API_SERVER_NAME
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.*
import java.util.concurrent.TimeUnit

class RetrofitInitializer {

    private val timeout: Long = Constants.CONNECTTIMEOUT.toLong()
    private val readTimeout: Long = Constants.READTIMEOUT.toLong()
    private val interseptor: RedirectInterceptor = RedirectInterceptor()

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interseptor)
        .protocols(Collections.singletonList(Protocol.HTTP_1_1))
        .followRedirects(false)
        .connectTimeout(timeout, TimeUnit.SECONDS)
        .readTimeout(readTimeout, TimeUnit.SECONDS)
        .build()

    private val retrofit = Retrofit.Builder().client(okHttpClient)
        .baseUrl(API_SERVER_NAME)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /** Get a new instance of retrofit */
    fun userService(): ApiService = retrofit.create(ApiService::class.java)

    companion object {

        /** Retorna uma Instância do Client Retrofit para Requisições
         * @param path Caminho Principal da API
         */
        fun getRetrofitInstance(path: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}

/** This interceptor request to avoid redirect error on 307 by response */
class RedirectInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        var response: Response = chain.proceed(chain.request())

        if (response.code() == API_RESPONSE_TEMPORARYREDIRECT) {
            request = response.header("Location")?.let {
                val first = it.slice(0..0)
                val url = if (first == "/") it.substring(1) else it
                request.newBuilder()
                    .url(API_SERVER_NAME + url)
                    .build()
            }!!
            response = chain.proceed(request)
        }
        return response
    }
}