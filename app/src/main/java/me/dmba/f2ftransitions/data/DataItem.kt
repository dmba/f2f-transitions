package me.dmba.f2ftransitions.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by dmba on 6/10/18.
 */
@Parcelize
data class DataItem(

    val id: String,

    val name: String,

    val imgUrl: String

) : Parcelable
