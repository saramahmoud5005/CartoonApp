package com.example.cartoonapp

import android.util.Log
import androidx.activity.viewModels
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cartoonapp.model.CharacterResponse
import com.example.cartoonapp.model.Location
import com.example.cartoonapp.model.Origin
import com.example.cartoonapp.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val apiService: ApiService
):ViewModel() {

    val results  = mutableStateOf<List<Result>>(listOf(Result(
        " ",
        listOf(""),
        "",
        1,
        "",
        Location("", ""),
        "",
        Origin("", ""),
        "",
        "", "", ""
    ), Result(
        " ",
        listOf(""),
        "",
        1,
        "",
        Location("", ""),
        "",
        Origin("", ""),
        "",
        "", "", ""
    )))

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val charResponse: CharacterResponse = apiService.getCharacters()
            Log.d("TAG1000", "response : "+charResponse)
            results.value= charResponse.results
        }
    }

}