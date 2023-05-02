package lsc.dispositivosmoviles.androidcrud.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(countryEntity: CountryEntity)

    @Query("SELECT * FROM Country")
    suspend fun getCountries(): List<CountryEntity>
}