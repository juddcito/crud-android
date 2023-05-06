package lsc.dispositivosmoviles.androidcrud

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import lsc.dispositivosmoviles.androidcrud.data.CountryDao

class CountryViewModel(
    private val dao: CountryDao
) : ViewModel(){

    init {
        viewModelScope.launch {
            dao.getCountries().collectLatest {
                state = state.copy(countries = it)
            }
        }
    }

    var state by mutableStateOf(CountryState())
        private set

    fun onNameChange(name: String){
        state = state.copy(
            name = name
        )
    }
}