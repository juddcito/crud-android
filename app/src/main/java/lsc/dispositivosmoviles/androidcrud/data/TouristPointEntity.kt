package lsc.dispositivosmoviles.androidcrud.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TouristPointEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val cost: Float,
    val latitude: String,
    val longitude: String
)
