package com.example.cartoonapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.getCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharactersUseCase: getCharactersUseCase
):ViewModel() {

    private val state = mutableStateOf<State>(State(true,emptyList(),""))
    val stateOfHomePage : MutableState<State> get() = state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                state.value = State(false,getCharactersUseCase().results, "")
            }catch (e:Exception){
                state.value = State(false,emptyList(), "")
            }
        }
    }

}