package com.example.cartoonapp.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cartoonapp.CharacterDetailsState
import com.example.cartoonapp.HomeState
import com.example.domain.model.Episode
import com.example.domain.usecases.GetEpisodesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    val getEpisodesUseCase: GetEpisodesUseCase,
):ViewModel() {

    private val state = mutableStateOf<CharacterDetailsState>(CharacterDetailsState(true,emptyList(),""))
    val stateOfCharacterDetailsPage : MutableState<CharacterDetailsState> get() = state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                state.value = CharacterDetailsState(false,getEpisodesUseCase().results, "")
                Log.d("TAG1000", "episodes view model : "+state.value)
            }catch (e:Exception){
                state.value = CharacterDetailsState(false,emptyList(), "")
            }
        }
    }
}