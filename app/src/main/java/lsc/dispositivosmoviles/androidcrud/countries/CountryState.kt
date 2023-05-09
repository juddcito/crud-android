package lsc.dispositivosmoviles.androidcrud.countries

import lsc.dispositivosmoviles.androidcrud.data.CountryEntity

data class CountryState(
    val name: String = "",
    val countries: List<CountryEntity> = emptyList()
)
