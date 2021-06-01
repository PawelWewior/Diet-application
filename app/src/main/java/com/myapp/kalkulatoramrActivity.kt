package com.myapp

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.kalkulator_amr.*
import java.io.Serializable

class kalkulatoramrActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kalkulator_amr)
        title = "Kalkulator AMR"
        var dataPass = intent.getSerializableExtra("serializable") as DataPass?

        val Wzrost: String = dataPass?.getWzrost().toString()
        val Waga: String = dataPass?.getWaga().toString()
        val Wiek: String = dataPass?.getWiek().toString()

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Wystąpił błąd")
        builder.setMessage("Brak wpisanych danych")
        builder.setPositiveButton("Ok",{ dialogInterface: DialogInterface, i: Int -> })

        var bmrkobieta: Float
        var bmrmezczyzna: Float
        bmrkobieta = ((655 + (9.6*Waga.toFloat() + (1.8 * Wzrost.toFloat()) - (4.7*Wiek.toFloat()))).toFloat())
        bmrmezczyzna = ((66 + (13.7*Waga.toFloat() +(5*Wzrost.toFloat()) - (6.76 * Wiek.toFloat()))).toFloat())

        obliczamr.setOnClickListener {
            if(kobieta.isChecked or mezczyzna.isChecked and bardzomała.isChecked or mała.isChecked or umiarkowana.isChecked or dużo.isChecked or Bardzodużo.isChecked){

                if(kobieta.isChecked && bardzomała.isChecked)
                    textView15.text = "Twoje AMR wynosi: " + (bmrkobieta * 1.2).toInt().toString() + " kalorii."

                if(kobieta.isChecked && mała.isChecked)
                    textView15.text = "Twoje AMR wynosi: " + (bmrkobieta * 1.375).toInt().toString() + " kalorii."

                if(kobieta.isChecked && umiarkowana.isChecked)
                    textView15.text = "Twoje AMR wynosi: " + (bmrkobieta * 1.55).toInt().toString() + " kalorii."

                if(kobieta.isChecked && dużo.isChecked)
                    textView15.text = "Twoje AMR wynosi: " + (bmrkobieta * 1.725).toInt().toString() + " kalorii."

                if(kobieta.isChecked && Bardzodużo.isChecked)
                    textView15.text = "Twoje AMR wynosi: " + (bmrkobieta * 1.9).toInt().toString() + " kalorii."



                if(mezczyzna.isChecked && bardzomała.isChecked)
                    textView15.text = "Twoje AMR wynosi: " + (bmrmezczyzna * 1.2).toInt().toString() + " kalorii."

                if(mezczyzna.isChecked && mała.isChecked)
                    textView15.text = "Twoje AMR wynosi: " + (bmrmezczyzna * 1.375).toInt().toString() + " kalorii."

                if(mezczyzna.isChecked && umiarkowana.isChecked)
                    textView15.text = "Twoje AMR wynosi: " + (bmrmezczyzna * 1.55).toInt().toString() + " kalorii."

                if(mezczyzna.isChecked && dużo.isChecked)
                    textView15.text = "Twoje AMR wynosi: " + (bmrmezczyzna * 1.725).toInt().toString() + " kalorii."

                if(mezczyzna.isChecked && Bardzodużo.isChecked)
                    textView15.text = "Twoje AMR wynosi: " + (bmrmezczyzna * 1.9).toInt().toString() + " kalorii."
            }else{

                builder.show()


            }
    }


}}