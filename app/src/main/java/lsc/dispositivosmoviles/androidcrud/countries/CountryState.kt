package lsc.dispositivosmoviles.androidcrud.countries

import lsc.dispositivosmoviles.androidcrud.data.CountryEntity
import lsc.dispositivosmoviles.androidcrud.data.Language

data class CountryState(
    val name: String = "",
    val countries: List<CountryEntity> = emptyList(),
    var languages: List<String> = emptyList()
)
