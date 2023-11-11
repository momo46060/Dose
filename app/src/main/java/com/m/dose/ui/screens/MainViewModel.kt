package com.m.dose.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.m.domain.model.Medecin
import com.m.domain.model.Resource
import com.m.domain.usecase.searchBySintNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    var usecase : searchBySintNameUseCase
):ViewModel() {

    private var _data: MutableStateFlow<Resource<List<Medecin>>> =  MutableStateFlow(Resource.Unspecified())
    val data: StateFlow<Resource<List<Medecin>>> = _data

    suspend fun Serch(set:String){
         usecase(set).collect{
             _data.value = it
         }
    }


}