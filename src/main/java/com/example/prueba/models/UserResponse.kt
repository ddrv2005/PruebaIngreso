package com.example.prueba.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

class UserResponse : ArrayList<User>()

@Entity(tableName = "users")
@Parcelize
data class User(
    //@SerializedName("address")
    //val address: Address,
    //@SerializedName("company")
    //val company: Company,
    @SerializedName("email")
    val email: String,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("website")
    val website: String
): Parcelable

@Parcelize
data class Address(
    @SerializedName("city")
    val city: String,
    @SerializedName("geo")
    val geo: Geo,
    @SerializedName("street")
    val street: String,
    @SerializedName("suite")
    val suite: String,
    @SerializedName("zipcode")
    val zipcode: String
): Parcelable

@Parcelize
data class Company(
    @SerializedName("bs")
    val bs: String,
    @SerializedName("catchPhrase")
    val catchPhrase: String,
    @SerializedName("name")
    val name: String
): Parcelable

@Parcelize
data class Geo(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lng")
    val lng: String
): Parcelable