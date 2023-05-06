package lsc.dispositivosmoviles.androidcrud.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "cities",
    foreignKeys = [
        ForeignKey(
            entity = CountryEntity::class,
            parentColumns = ["countryCode"],
            childColumns = ["countryCode"],
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CityEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val countryCode: String,
    val district: String,
    val population: Int
)
