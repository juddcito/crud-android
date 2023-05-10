package lsc.dispositivosmoviles.androidcrud.countries

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import lsc.dispositivosmoviles.androidcrud.data.CountryDao
import lsc.dispositivosmoviles.androidcrud.data.CountryEntity
import lsc.dispositivosmoviles.androidcrud.data.Language

class CountryViewModel(
    private val dao: CountryDao
) : ViewModel(){

    init {
        viewModelScope.launch {
            dao.getCountries().collectLatest {
                state = state.copy(countries = it)
            }
        }
        viewModelScope.launch {
            dao.getLanguages().collectLatest {
                state = state.copy(languages = it)
            }
        }
    }

    var state by mutableStateOf(CountryState())
        private set

    fun getAllCountries(){
        viewModelScope.launch {
            dao.getCountries().collectLatest {
                state = state.copy(countries = it)
            }
        }
    }

    fun createCountry(country: CountryEntity){
        viewModelScope.launch {
            dao.insertCountry(country)
        }
    }

    fun getFilteredCountriesByContinentAndLanguage(continent: String, language: String){
        viewModelScope.launch {
            dao.getFilteredCountriesByContinentLanguage(continent, language).collectLatest {
                state = state.copy(countries = it)
            }
        }
    }

    fun getFilteredCountriesByContinent(continent: String){
        viewModelScope.launch {
            dao.getFilteredCountriesByContinent(continent).collectLatest {
                state = state.copy(countries = it)
            }
        }
    }

    fun getFilteredCountriesByLanguage(language: String){
        viewModelScope.launch {
            dao.getFilteredCountriesByLanguage(language).collectLatest {
                state = state.copy(countries = it)
            }
        }
    }

    fun deleteCountry(country: CountryEntity){
        viewModelScope.launch {
            dao.deleteCountry(country)
        }
    }
}