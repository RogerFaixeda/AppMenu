package com.faixeda.appmenu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenusSharedViewModel: ViewModel(){

    private var _plat = MutableLiveData<MenuModel>()
    var plat: LiveData<MenuModel> = _plat

    private var _beguda = MutableLiveData<MenuModel>()
    var beguda: LiveData<MenuModel> = _beguda

    private var _preuTotalPrimerPlat = MutableLiveData<Int>()
    val preuTotalPrimerPlat: LiveData<Int>  = _preuTotalPrimerPlat

    private var _preuTotalBeguda = MutableLiveData<Int>()
    val preuTotalBeguda: LiveData<Int> = _preuTotalBeguda

    private var _preuTotal = MutableLiveData<Int>()
    val preuTotal: LiveData<Int> = _preuTotal

    fun afegirAlMenu(menuModel : MenuModel) {
        if (menuModel.tipus == "plat"){
            _plat.value = menuModel
        } else {
            _beguda.value = menuModel
        }
    }
    fun calcularPreu(){
        _preuTotalPrimerPlat.value = (plat.value?.preuUnitari ?: 0) * (plat.value?.quantitat ?: 0)
        _preuTotalBeguda.value = (beguda.value?.preuUnitari ?: 0) * (beguda.value?.quantitat ?: 0)

        _preuTotal.value = _preuTotalPrimerPlat.value!! + _preuTotalBeguda.value!!
    }

}