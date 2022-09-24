package br.com.seventh.bookslist.utils

object Constants {
    const val API_SERVER_NAME = "https://www.googleapis.com/books/"
    const val API_RESPONSE_TEMPORARYREDIRECT: Int = 307

    const val PREFIX = "V1/"
    const val PARAM_VOLUMES = "volumes"
    const val PARAM_VOLUME_ID = "volumeId"
    const val PARAM_MYLIBRARY = "mylibrary"
    const val PARAM_BOOKSHELVES = "bookshelves"
    const val PARAM_SHELF = "shelf"

    /* Retrofit - Intersepror */
    const val CONNECTTIMEOUT = 30
    const val READTIMEOUT = 20

    object Endpoint {
        const val GET_BOOKS = "${API_SERVER_NAME}${PREFIX}${PARAM_VOLUMES}/q"
        const val GET_VOLUME_ID = "${API_SERVER_NAME}${PREFIX}${PARAM_VOLUMES}/${PARAM_VOLUME_ID}/"
        const val GET_VOLUMES_MYLIBRARY = "${API_SERVER_NAME}${PREFIX}${PARAM_MYLIBRARY}/${PARAM_BOOKSHELVES}/"
        const val GET_VOLUMES_SHELF = "${API_SERVER_NAME}${PREFIX}${PARAM_MYLIBRARY}/${PARAM_BOOKSHELVES}/${PARAM_SHELF}"
        const val GET_BOOKSHELVES_VOLUMES = "${API_SERVER_NAME}${PREFIX}${PARAM_MYLIBRARY}/${PARAM_BOOKSHELVES}/${PARAM_SHELF}/${PARAM_VOLUMES}"
    }
}