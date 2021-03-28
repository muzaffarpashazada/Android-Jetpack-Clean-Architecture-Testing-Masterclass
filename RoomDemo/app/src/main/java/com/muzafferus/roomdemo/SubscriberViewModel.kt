package com.muzafferus.roomdemo

import android.util.Patterns
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
        if (inputName.value == null) {
            statusMessage.value = Event("Please enter Subscriber's name")
        } else if (inputEmail.value == null) {
            statusMessage.value = Event("Please enter Subscriber's email")
        } else if(!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value!!).matches()){
            statusMessage.value = Event("Please enter a correct email address")
        }else {
            val name = inputName.value!!
            val email = inputEmail.value!!
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
        val repositoryId = repository.insert(subscriber)
        if (repositoryId > -1) {
            statusMessage.value = Event("Subscriber Inserted Successfully $repositoryId")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
    }

    private fun update(subscriber: Subscriber): Job = viewModelScope.launch {
        val noOfRows = repository.update(subscriber)
        if (noOfRows > 0) {
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false
            setSaveAndClearAllText()
            statusMessage.value = Event("$noOfRows Row Updated Successfully")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
    }

    private fun delete(subscriber: Subscriber): Job = viewModelScope.launch {
        val noOfRows = repository.delete(subscriber)
        if (noOfRows > 0) {
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false
            setSaveAndClearAllText()
            statusMessage.value = Event("$noOfRows Row Deleted Successfully")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
    }

    private fun clearAll(): Job = viewModelScope.launch {
        val noOfRows = repository.deleteAll()
        if (noOfRows > 0) {
            statusMessage.value = Event("$noOfRows Rows Deleted Successfully")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
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