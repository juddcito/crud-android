package lsc.dispositivosmoviles.androidcrud.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(countryEntity: CountryEntity)

    @Query("SELECT * FROM countries")
    fun getCountries(): Flow<List<CountryEntity>>

    @Query("SELECT * FROM countries INNER JOIN language_table ON countries.countryCode == language_table.countryCode WHERE countries.continent = :Continent AND language_table.language = :Language")
    fun getFilteredCountriesByContinentLanguage(Continent: String, Language: String): Flow<List<CountryEntity>>

    @Query("SELECT * FROM countries  WHERE countries.continent = :Continent")
    fun getFilteredCountriesByContinent(Continent: String): Flow<List<CountryEntity>>

    @Query("SELECT * FROM countries INNER JOIN language_table ON countries.countryCode == language_table.countryCode WHERE language_table.language = :Language")
    fun getFilteredCountriesByLanguage(Language: String): Flow<List<CountryEntity>>

    @Delete
    suspend fun deleteCountry(country: CountryEntity)
}