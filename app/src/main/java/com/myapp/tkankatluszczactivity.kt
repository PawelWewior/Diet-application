package com.myapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.DialogInterface
import android.content.Intent

import android.widget.*
import androidx.appcompat.app.AlertDialog

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.kalkulator_tkanki_tluszczowej.*
import org.w3c.dom.Text
import kotlin.math.pow

class tkankatluszczactivity : AppCompatActivity()


{
    private var dataPass: DataPass? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kalkulator_tkanki_tluszczowej)
        title = "Kalkulator tkanki tłuszczowej"

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Wystąpił błąd")
        builder.setMessage("Brak wpisanych danych")
        builder.setPositiveButton("Ok", { dialogInterface: DialogInterface, i: Int -> })
        val Komunikat = AlertDialog.Builder(this)
        Komunikat.setTitle("Wynik tkanki")

        Komunikat.setPositiveButton("Ok", { dialogInterface: DialogInterface, i: Int -> })


          dataPass = intent.getSerializableExtra("serializable") as DataPass?
        Sprawdzwynik.setOnClickListener {
            if(obecnamasatluszczowa.text.isNotEmpty() && docelowamasatluszczowa.text.isNotEmpty()) {
                val tkankatluszczowa = Tkankatluszczowa()
                tkankatluszczowa.setMasaoobecna(obecnamasatluszczowa.text.toString().toInt())
                tkankatluszczowa.setMasadocelowa(docelowamasatluszczowa.text.toString().toInt())

                val Waga: String = dataPass?.getWaga().toString()
                var ileschodnac = (((Waga.toInt() * (100 - tkankatluszczowa.getMasaobecna())) * 0.97).toInt()) / (100 - tkankatluszczowa.getMasadocelowa())


                Komunikat.setMessage("By osiągnąć docelową masę tłuszczową waga powinna wynosić " + ileschodnac.toString() + " kilogramów.")
                Komunikat.show()
            }
            else {
            builder.show()
            }
            }

        }


    }
