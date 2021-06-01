package com.myapp

import java.io.Serializable

open class DataPass: Serializable {
    private  var wzrost: Int = 0
    private  var waga: Int = 0
    private  var wiek: Int = 0

    fun getWzrost(): Int? {
        return wzrost
    }
    @JvmName("setWzrost")
    fun setWzrost(wzrost: Int?) {
        this.wzrost = wzrost!!
    }

    fun getWaga(): Int? {
        return waga
    }
    @JvmName("setWaga")
    fun setWaga(waga: Int?) {
        this.waga = waga!!
    }

    fun getWiek(): Int?{
        return wiek
    }
    @JvmName("setWiek")
    fun setWiek(wiek:Int?){
        this.wiek = wiek!!
    }
}
