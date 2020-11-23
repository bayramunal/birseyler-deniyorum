package com.hacib.duygusalbiruygulama.main.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {

    private var modelList = ArrayList<Model>()
    private var mutableList = MutableLiveData<List<Model>>()

    fun getModelList() : LiveData<List<Model>> {
        modelList.add(Model("1","1"))
        modelList.add(Model("2","2"))
        modelList.add(Model("3","3"))
        modelList.add(Model("4","4"))
        mutableList.value = modelList
        return mutableList
    }

}