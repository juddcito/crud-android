package lsc.dispositivosmoviles.androidcrud

import lsc.dispositivosmoviles.androidcrud.data.CountryEntity

data class CountryState(
    val name: String = "",
    val countries: List<CountryEntity> = emptyList()
)
