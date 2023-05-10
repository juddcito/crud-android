package lsc.dispositivosmoviles.androidcrud.touristpoints

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import lsc.dispositivosmoviles.androidcrud.countries.CountryState
import lsc.dispositivosmoviles.androidcrud.data.CountryDao
import lsc.dispositivosmoviles.androidcrud.data.CountryEntity
import lsc.dispositivosmoviles.androidcrud.data.TouristPointDao
import lsc.dispositivosmoviles.androidcrud.data.TouristPointEntity

class TouristPointViewModel(
    private val touristDao: TouristPointDao
) : ViewModel() {
    init {
        viewModelScope.launch {
            touristDao.getTouristPoints().collectLatest {
                state = state.copy(touristPoints = it)
            }
        }
    }

    var state by mutableStateOf(TouristPointState())
        private set

    fun getAllTouristPoints(){
        viewModelScope.launch {
            touristDao.getTouristPoints().collectLatest {
                state = state.copy(touristPoints = it)
            }
        }
    }

    fun deleteTouristPoint(touristPoint: TouristPointEntity){
        viewModelScope.launch {
            touristDao.deleteTouristPoint(touristPoint = touristPoint)
        }
    }

    fun createTouristPoint(touristPoint: TouristPointEntity){
        viewModelScope.launch {
            touristDao.insertTouristPoint(touristPoint)
        }
    }

}