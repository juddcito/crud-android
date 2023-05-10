package lsc.dispositivosmoviles.androidcrud.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(cityEntity: CityEntity)

    @Query("SELECT cities.id, cities.name, cities.countryCode, cities.population, cities.district, countries.name FROM cities INNER JOIN countries ON cities.countryCode == countries.countryCode ")
    fun getCities(): Flow<List<CityEntity>>

    @Delete
    suspend fun deleteCity(city: CityEntity)
}