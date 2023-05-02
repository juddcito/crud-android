package lsc.dispositivosmoviles.androidcrud.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val code: String,
    val name: String
)
