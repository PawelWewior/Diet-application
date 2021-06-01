package com.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.przedmiot_lista.view.*
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG

class ListaAdapter (private val przedmioty: MutableList<Produkty>) : RecyclerView.Adapter<ListaAdapter.ListaViewHolder>() {

    var sumaUsun: Int = 0

    class ListaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
       return ListaViewHolder(
           LayoutInflater.from(parent.context).inflate(
               R.layout.przedmiot_lista,
               parent,
               false
           )
       )
    }

    fun dodajItem(produkty: Produkty){
        przedmioty.add(produkty)
        notifyItemInserted(przedmioty.size -1)
    }

    fun usunItem(){



        przedmioty.removeAll { produkty -> produkty.isChecked  }
        notifyDataSetChanged()
    }

    fun modifyItem(){


    }





    private fun str (tvListaNazwa: TextView,tvListaKcal:TextView, isChecked: Boolean){
        if(isChecked){
            tvListaNazwa.paintFlags = tvListaNazwa.paintFlags or STRIKE_THRU_TEXT_FLAG
            tvListaKcal.paintFlags = tvListaKcal.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{
            tvListaNazwa.paintFlags = tvListaNazwa.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
            tvListaKcal.paintFlags = tvListaKcal.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()

        }
    }

    override fun getItemCount(): Int {

        return przedmioty.size


    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {

        val curItem = przedmioty[position]
        holder.itemView.apply {
            tvListaNazwa.text = curItem.nazwa
            tvListaKcal.text = curItem.kcal.toString()
            cb1.isChecked = curItem.isChecked
            str(tvListaNazwa,tvListaKcal, curItem.isChecked)
            cb1.setOnCheckedChangeListener { _, isChecked ->
                str(tvListaNazwa,tvListaKcal, isChecked)
                curItem.isChecked = !curItem.isChecked
            }
        }

    }
}