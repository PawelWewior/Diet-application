package com.myapp

import java.io.Serializable
import kotlin.properties.Delegates


data class Produkty(
    val nazwa: String,
    val kcal: Int,
    var isChecked: Boolean=false

)