package lsc.dispositivosmoviles.androidcrud.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TouristPointEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val countryCode: String?,
    val cityId: Int?,
    val name: String?,
    val description: String?,
    val cost: Float?,
    val latitude: String?,
    val longitude: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(countryCode)
        if (cityId != null) {
            parcel.writeInt(cityId)
        }
        parcel.writeString(name)
        parcel.writeString(description)
        if (cost != null) {
            parcel.writeFloat(cost)
        }
        parcel.writeString(latitude)
        parcel.writeString(longitude)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TouristPointEntity> {
        override fun createFromParcel(parcel: Parcel): TouristPointEntity {
            return TouristPointEntity(parcel)
        }

        override fun newArray(size: Int): Array<TouristPointEntity?> {
            return arrayOfNulls(size)
        }
    }
}

