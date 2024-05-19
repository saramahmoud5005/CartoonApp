package com.example.cartoonapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cartoonapp.HomeState
import com.example.domain.usecases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
):ViewModel() {

    private val state = mutableStateOf<HomeState>(HomeState(true,emptyList(),""))
    val stateOfHomePage : MutableState<HomeState> get() = state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                state.value = HomeState(false,getCharactersUseCase().results, "")
            }catch (e:Exception){
                state.value = HomeState(false,emptyList(), "")
            }
        }
    }

}