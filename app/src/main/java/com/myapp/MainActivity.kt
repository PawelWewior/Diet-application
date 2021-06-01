package com.myapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


open class MainActivity : AppCompatActivity() {

    lateinit var wzr: EditText
    lateinit var wag: EditText
    lateinit var age: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Witamy"
       val builder = AlertDialog.Builder(this)
        builder.setTitle("Wystąpił błąd")
        builder.setMessage("Brak wpisanych danych")
       builder.setPositiveButton("Ok",{ dialogInterface: DialogInterface, i: Int -> })

        val btn: Button = findViewById(R.id.button)

       btn.setOnClickListener {

           var wzr =wzrostText.text.toString()
           val wag = wagaText.text.toString()
           val age = wiekText.text.toString()
           if(wzr.isNotEmpty() and wag.isNotEmpty() and age.isNotEmpty()){
              PrzejscieDalej(wzr.toInt(),wag.toInt(),age.toInt())

           }else{
               builder.show()
           }

        }

        button4.setOnClickListener{
            var wzr =wzrostText.text.toString()
            val wag = wagaText.text.toString()
            val age = wiekText.text.toString()
            if(wzr.isNotEmpty() and wag.isNotEmpty() and age.isNotEmpty()){
                PrzejscieDalej2(wzr.toInt(),wag.toInt(),age.toInt())

            }else{
                builder.show()
            }


        }

        button6.setOnClickListener {
            val przejscie = Intent(this@MainActivity, ActivityWHR::class.java)
            startActivity(przejscie)


        }

        button5.setOnClickListener {
            var wzr =wzrostText.text.toString()
            val wag = wagaText.text.toString()
            val age = wiekText.text.toString()
            if(wzr.isNotEmpty() and wag.isNotEmpty() and age.isNotEmpty()){
                PrzejscieDalej3(wzr.toInt(),wag.toInt(),age.toInt())

            }else{
                builder.show()
            }





        }


    }

private fun PrzejscieDalej(wr: Int, wa: Int, wi: Int){
    val dataPass = DataPass()
    dataPass.setWzrost(wr)
    dataPass.setWaga(wa)
    dataPass.setWiek(wi)
    val klik = Intent(this@MainActivity, MainActivity2::class.java)
    val b = Bundle()
    b.putSerializable("serializable", dataPass)
    klik.putExtras(b)
    startActivity(klik)
    }
    private fun PrzejscieDalej2(wr: Int, wa: Int, wi: Int){
        val dataPass = DataPass()
        dataPass.setWzrost(wr)
        dataPass.setWaga(wa)
        dataPass.setWiek(wi)
        val klik = Intent(this@MainActivity, tkankatluszczactivity::class.java)
        val b = Bundle()
        b.putSerializable("serializable", dataPass)
        klik.putExtras(b)
        startActivity(klik)
    }
    private fun PrzejscieDalej3(wr: Int, wa: Int, wi: Int){
        val dataPass = DataPass()
        dataPass.setWzrost(wr)
        dataPass.setWaga(wa)
        dataPass.setWiek(wi)
        val klik = Intent(this@MainActivity, kalkulatoramrActivity::class.java)
        val b = Bundle()
        b.putSerializable("serializable", dataPass)
        klik.putExtras(b)
        startActivity(klik)
    }
}