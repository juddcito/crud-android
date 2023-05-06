package lsc.dispositivosmoviles.androidcrud.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class CountryEntity(
    @ColumnInfo(name = "countryCode") @PrimaryKey val countryCode: String,
    val name: String,
    val continent: String,
    val region: String,
    val surfaceArea: Float,
    val indepYear: Int,
    val population: String,
    val lifeExpectancy: String,
    val gnp: Float,
    val localName: String,
    val governmentForm: String,
    val headOfState: String,
    val capital: String,
    val code2: String
)
