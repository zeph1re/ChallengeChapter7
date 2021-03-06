package binar.ganda.challengechapter7.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: String,
    val overview: String?,
    val poster_path : String,
    val original_title : String
): Parcelable {
    val basaeUrl get() = "https://image.tmdb.org/t/p/w500"
}
