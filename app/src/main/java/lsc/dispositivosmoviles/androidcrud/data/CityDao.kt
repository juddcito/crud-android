package lsc.dispositivosmoviles.androidcrud.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(cityEntity: CityEntity)

    @Query("SELECT * FROM cities")
    fun getCities(): Flow<List<CityEntity>>

    @Delete
    suspend fun deleteCity(city: CityEntity)
}