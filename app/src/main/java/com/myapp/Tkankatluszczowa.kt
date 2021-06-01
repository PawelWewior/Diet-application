package com.myapp
import java.io.Serializable
class Tkankatluszczowa: Serializable {
    private  var masaobecna: Int = 0
    private  var masadocelowa: Int = 0

    fun getMasaobecna(): Int {
        return masaobecna
    }
    @JvmName("setMasaoobecna")
    fun setMasaoobecna(masaobecna: Int) {
        this.masaobecna = masaobecna!!
    }

    fun getMasadocelowa(): Int {
        return masadocelowa
    }
    @JvmName("setMasadocelowa")
    fun setMasadocelowa(masadocelowa: Int) {
        this.masadocelowa = masadocelowa!!
    }


}