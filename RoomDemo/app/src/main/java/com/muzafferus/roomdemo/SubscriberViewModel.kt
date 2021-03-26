package com.muzafferus.roomdemo

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muzafferus.roomdemo.db.Subscriber
import com.muzafferus.roomdemo.db.SubscriberRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel(), Observable {

    val subscribers = repository.subscribers
    private var isUpdateOrDelete = false
    private lateinit var subscriberToUpdateOrDelete: Subscriber

    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage

    init {
        setSaveAndClearAllText()
    }

    private fun setSaveAndClearAllText() {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }


    fun saveOrUpdate() {
        val name = inputName.value
        val email = inputEmail.value
        if (name == null || email == null) {
            return
        } else {
            if (isUpdateOrDelete) {
                subscriberToUpdateOrDelete.name = name
                subscriberToUpdateOrDelete.email = email
                update(subscriberToUpdateOrDelete)
            } else {
                insert(Subscriber(0, name, email))
            }
            inputName.value = null
            inputEmail.value = null
        }
    }

    fun clearOrDelete() {
        if (isUpdateOrDelete) {
            delete(subscriberToUpdateOrDelete)
        } else {
            clearAll()
        }
    }

    private fun insert(subscriber: Subscriber): Job = viewModelScope.launch {
        repository.insert(subscriber)
        statusMessage.value = Event("Subscriber Inserted Successfully")
    }

    private fun update(subscriber: Subscriber): Job = viewModelScope.launch {
        repository.update(subscriber)

        inputName.value = null
        inputEmail.value = null
        isUpdateOrDelete = false
        setSaveAndClearAllText()
        statusMessage.value = Event("Subscriber Updated Successfully")
    }

    private fun delete(subscriber: Subscriber): Job = viewModelScope.launch {
        repository.delete(subscriber)

        inputName.value = null
        inputEmail.value = null
        isUpdateOrDelete = false
        setSaveAndClearAllText()
        statusMessage.value = Event("Subscriber Deleted Successfully")
    }

    private fun clearAll(): Job = viewModelScope.launch {
        repository.deleteAll()
        statusMessage.value = Event("All Subscribers Deleted Successfully")
    }

    fun initUpdateOrDelete(subscriber: Subscriber) {
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email
        isUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriber

        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }


    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}