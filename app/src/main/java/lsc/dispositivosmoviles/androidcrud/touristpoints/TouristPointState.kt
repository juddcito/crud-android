package lsc.dispositivosmoviles.androidcrud.touristpoints

import lsc.dispositivosmoviles.androidcrud.data.CountryEntity
import lsc.dispositivosmoviles.androidcrud.data.TouristPointEntity

data class TouristPointState(
    val touristPoints: List<TouristPointEntity> = emptyList(),
    val countries: List<CountryEntity> = emptyList()
)
