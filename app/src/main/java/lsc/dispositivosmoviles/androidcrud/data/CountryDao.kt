package lsc.dispositivosmoviles.androidcrud.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(countryEntity: CountryEntity)

    @Query("SELECT * FROM countries")
    fun getCountries(): Flow<List<CountryEntity>>

    @Delete
    suspend fun deleteCountry(country: CountryEntity)

}