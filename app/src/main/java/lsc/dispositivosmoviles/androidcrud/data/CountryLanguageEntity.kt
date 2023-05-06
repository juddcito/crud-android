package lsc.dispositivosmoviles.androidcrud.data

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "language_table",
    primaryKeys = ["countryCode", "language"],
    foreignKeys = [ForeignKey(
        entity = CountryEntity::class,
        parentColumns = ["countryCode"],
        childColumns = ["countryCode"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class CountryLanguageEntity(
    val countryCode: String,
    val language: String,
    val isOfficial: Boolean,
    val percentage: Float
)
