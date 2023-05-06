package lsc.dispositivosmoviles.androidcrud.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TouristPointDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTouristPoint(touristPointEntity: TouristPointEntity)

    @Query("SELECT * FROM touristpointentity")
    fun getTouristPoints(): Flow<List<TouristPointEntity>>

    @Delete
    suspend fun deleteTouristPoint(touristPoint: TouristPointEntity)
}