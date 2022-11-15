package br.com.fabianospdev.bookslist.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fabianospdev.bookslist.rest.api.repository.DefaultRepository
import javax.inject.Inject

class NotificationsViewModel @Inject constructor(val repository: DefaultRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}