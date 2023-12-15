package com.example.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private var clickCount: Int = 0
    private var countLiveData = MutableLiveData<Int>()

    open fun getInitialcount(): MutableLiveData<Int> {
        countLiveData.value = clickCount
        return countLiveData
    }

    open fun getCurrentCount() {
        clickCount += 1
        countLiveData.value = clickCount
    }
}