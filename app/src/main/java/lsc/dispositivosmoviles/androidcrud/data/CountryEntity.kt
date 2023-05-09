package lsc.dispositivosmoviles.androidcrud.data

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class CountryEntity(
    @PrimaryKey @ColumnInfo(name = "countryCode") val countryCode: String,
    val name: String?,
    val continent: String?,
    val region: String?,
    val surfaceArea: Float?,
    val indepYear: Int?,
    val population: String?,
    val lifeExpectancy: String?,
    val gnp: Float?,
    val localName: String?,
    val governmentForm: String?,
    val headOfState: String?,
    val capital: String?,
    val code2: String?
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()?: "",
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readFloat(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(countryCode)
        parcel.writeString(name)
        parcel.writeString(continent)
        parcel.writeString(region)
        if (surfaceArea != null) {
            parcel.writeFloat(surfaceArea)
        }
        if (indepYear != null) {
            parcel.writeInt(indepYear)
        }
        parcel.writeString(population)
        parcel.writeString(lifeExpectancy)
        if (gnp != null) {
            parcel.writeFloat(gnp)
        }
        parcel.writeString(localName)
        parcel.writeString(governmentForm)
        parcel.writeString(headOfState)
        parcel.writeString(capital)
        parcel.writeString(code2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CountryEntity> {
        override fun createFromParcel(parcel: Parcel): CountryEntity {
            return CountryEntity(parcel)
        }

        override fun newArray(size: Int): Array<CountryEntity?> {
            return arrayOfNulls(size)
        }
    }

}
