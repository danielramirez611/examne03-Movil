package com.tecsup.municipalidad.muniview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tecsup.municipalidad.R
import com.tecsup.municipalidad.database.Information


class InformationViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_information, parent, false))
{
    private var textTitle : TextView? = null
    private var textPlace : TextView? = null
    private var textEditorial: TextView?=null
    private var textGenero: TextView?=null
    private var textCommet: TextView? = null


    init {
        textTitle = itemView.findViewById(R.id.textTitle)
        textPlace = itemView.findViewById(R.id.textPlace)
        textEditorial = itemView.findViewById(R.id.textEditorial)
        textGenero = itemView.findViewById(R.id.textGenero)
        textCommet = itemView.findViewById(R.id.textContext)


    }

    fun bind(information: Information){
        textTitle?.text = information.title
        textPlace?.text = information.place
        textEditorial?.text=information.editorial
        textGenero?.text=information.genero
        textCommet?.text = information.comment

    }


}