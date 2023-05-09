package lsc.dispositivosmoviles.androidcrud.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
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
    ],
    indices = [Index(value = ["name"], unique = true)]
)
data class CityEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String?,
    val countryCode: String?,
    val district: String?,
    val population: Int,
    val language: String?
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(countryCode)
        parcel.writeString(district)
        parcel.writeInt(population)
        parcel.writeString(language)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CityEntity> {
        override fun createFromParcel(parcel: Parcel): CityEntity {
            return CityEntity(parcel)
        }

        override fun newArray(size: Int): Array<CityEntity?> {
            return arrayOfNulls(size)
        }
    }

}
