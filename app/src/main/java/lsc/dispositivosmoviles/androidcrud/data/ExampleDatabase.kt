package lsc.dispositivosmoviles.androidcrud.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CountryEntity::class], version = 2)
abstract class ExampleDatabase: RoomDatabase() {
    abstract val dao: CountryDao

}