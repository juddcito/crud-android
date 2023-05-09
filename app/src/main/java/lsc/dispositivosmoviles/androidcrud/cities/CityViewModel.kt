package lsc.dispositivosmoviles.androidcrud.cities

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import lsc.dispositivosmoviles.androidcrud.data.CityDao
import lsc.dispositivosmoviles.androidcrud.data.CityEntity

class CityViewModel(
    private val cityDao: CityDao
): ViewModel() {

    init {
        viewModelScope.launch {
            cityDao.getCities().collectLatest {
                state = state.copy(cities = it)
            }
        }
    }

    var state by mutableStateOf(CityState())
        private set

    fun getAllCities(){
        viewModelScope.launch {
            cityDao.getCities().collectLatest {
                state = state.copy(cities = it)
            }
        }
    }

    fun deleteCity(city: CityEntity){
        viewModelScope.launch {
            cityDao.deleteCity(city)
        }
    }


}