package lsc.dispositivosmoviles.androidcrud.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CountryEntity::class, CityEntity::class, CountryLanguageEntity::class, TouristPointEntity::class], version = 1)
abstract class ExampleDatabase: RoomDatabase() {
    abstract val countryDao: CountryDao
    abstract val cityDao: CityDao
    abstract val TouristPointDao: TouristPointDao
}