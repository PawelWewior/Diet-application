package com.myapp


import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlin.math.pow


class MainActivity2 : AppCompatActivity() {

    private lateinit var listaAdapter: ListaAdapter

    private var dataPass: DataPass? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        title = "Aplikacja Posiłkowa"
        listaAdapter = ListaAdapter(mutableListOf())
        recyclerView2.adapter = listaAdapter
        recyclerView2.layoutManager = LinearLayoutManager(this)
        dataPass = intent.getSerializableExtra("serializable") as DataPass?

        val Wzrost: String = dataPass?.getWzrost().toString()
        val Waga: String = dataPass?.getWaga().toString()
        val Wiek: String = dataPass?.getWiek().toString()

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Wystąpił błąd")
        builder.setMessage("Brak wpisanych danych")
        builder.setPositiveButton("Ok", { dialogInterface: DialogInterface, i: Int -> })
        val komunikatLimit = AlertDialog.Builder(this)
        komunikatLimit.setTitle("Uwaga")
        komunikatLimit.setMessage("Twoje dzisiejsze dania przekraczają twoje dzienne zapotrzebowanie dla kobiety")
        komunikatLimit.setPositiveButton("Ok", { dialogInterface: DialogInterface, i: Int -> })
        val komunikatLimitMen = AlertDialog.Builder(this)
        komunikatLimitMen.setTitle("Uwaga")
        komunikatLimitMen.setMessage("Twoje dzisiejsze dania przekraczają twoje dzienne zapotrzebowanie dla kobiety i mężczyzny")
        komunikatLimitMen.setPositiveButton("Ok", { dialogInterface: DialogInterface, i: Int -> })

        var suma: Int = 0;
        val sumaTekst: TextView = findViewById(R.id.textView12)
        var Bmi: Float
        var wzrostwmetrach = Wzrost.toFloat()/100
        Bmi =    Waga.toFloat() / (wzrostwmetrach.pow(2))
        val jedzenie: TextView = findViewById(R.id.Ilejesc)

        var Bmrkobieta: Float
        var Bmrmezczyzna: Float
        Bmrkobieta = ((655 + (9.6*Waga.toFloat() + (1.8 * Wzrost.toFloat()) - (4.7*Wiek.toFloat()))).toFloat())
        Bmrmezczyzna = ((66 + (13.7*Waga.toFloat() +(5*Wzrost.toFloat()) - (6.76 * Wiek.toFloat()))).toFloat())



        if (Bmi < 18.5) {
            jedzenie.text = "Powinieneś przytyć, jedząc ponad:  " + Bmrkobieta.toString() + System.lineSeparator() + " kalorii będąc kobietą, a będąc mężczyzną " +
                    Bmrmezczyzna.toString() + " kalorii."
        }
        if(Bmi > 18.5 || Bmi < 25)
        {
            jedzenie.text = "Twoja waga jest prawidłowa, jedz przynajmniej  " + System.lineSeparator() + Bmrkobieta.toString() + " kalorii będąc kobietą, a będąc mężczyzną " +
                    Bmrmezczyzna.toString() + " kalorii."
        }

        if(Bmi > 25)
        {
            jedzenie.text = "Masz nadwagę, jedz poniżej " + System.lineSeparator() + Bmrkobieta.toString() + " kalorii będąc kobietą, a będąc mężczyzną " +
                    Bmrmezczyzna.toString() + " kalorii."
        }





        button3.setOnClickListener{
            val Przedmiot = editTextTextPersonName4.text.toString()
            val Kalorie = editTextTextPersonName.text
            val Kalorie2 = Kalorie.toString()
            if(Przedmiot.isNotEmpty() and  Kalorie2.isNotEmpty()){
                val dod = Produkty(Przedmiot, Kalorie2.toInt())
                listaAdapter.dodajItem(dod)
                suma = suma + Kalorie2.toInt()
                sumaTekst.setText("Suma:" + " " + suma.toString() + " " + "kcal")
                editTextTextPersonName4.text.clear()
                editTextTextPersonName.text.clear()
                if(suma > Bmrmezczyzna){
                    komunikatLimitMen.show()
                }else {
                    if (suma > Bmrkobieta) {

                        komunikatLimit.show()


                    }

                }

            }else{

                builder.show()
            }



        }

        button2.setOnClickListener {
            suma = suma - listaAdapter.sumaUsun

            listaAdapter.usunItem()


        }




        val wzrTekst: TextView = findViewById(R.id.textView3)
        val wagTekst: TextView = findViewById(R.id.textView4)
        val wiekTekst: TextView = findViewById(R.id.textView5)
        val BmiTekst: TextView = findViewById(R.id.textBMI)



        wzrTekst.text = "Twój wzrost wynosi " + Wzrost + " cm"
        wagTekst.text = "Twoja waga wynosi " + Waga + " kg"
        wiekTekst.text = "Twój wiek wynosi " + Wiek + " lat"
        BmiTekst.text = "Twoje BMI wynosi: " + Bmi.toString()

















    }




}
