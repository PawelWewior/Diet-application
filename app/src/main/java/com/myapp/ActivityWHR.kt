package com.myapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.whrlayout.*
import kotlin.math.round
import kotlin.math.roundToInt

class ActivityWHR : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.whrlayout)
        title = "Kalkulator WHR"
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Wystąpił błąd")
        builder.setMessage("Brak wpisanych danych")
        builder.setPositiveButton("Ok", { dialogInterface: DialogInterface, i: Int -> })
        val Komunikat = AlertDialog.Builder(this)
        Komunikat.setTitle("Wynik WHR")

        Komunikat.setPositiveButton("Ok", { dialogInterface: DialogInterface, i: Int -> })




        button7.setOnClickListener {

            var WHRwynik: Float
            var biodra = editTextTextPersonName2.text.toString()
            var pas = editTextTextPersonName3.text.toString()











                 if(radioButtonKobieta.isChecked or radioButtonMen.isChecked and pas.isNotEmpty() and biodra.isNotEmpty() ){
                     WHRwynik = (pas.toFloat() / biodra.toFloat())
                     if(radioButtonKobieta.isChecked){




                         if(WHRwynik > 0.8){

                            Komunikat.setMessage("Twoje WHR to typ androidalny(jabłko)")
                             Komunikat.show()



                         }

                         if(WHRwynik <= 0.8){

                             Komunikat.setMessage("Twoje WHR to typ gynoidalny(gruszka)")
                             Komunikat.show()


                         }






                     }
                     if(radioButtonMen.isChecked){



                         if(WHRwynik > 1){

                             Komunikat.setMessage("Twoje WHR to typ androidalny(jabłko)")
                             Komunikat.show()
                         }

                         if(WHRwynik <= 1){


                             Komunikat.setMessage("Twoje WHR to typ gynoidalny(gruszka)")
                             Komunikat.show()

                         }


                     }



                 }else{

                     builder.show()
                 }








                }

            }




        }



