package com.hacib.duygusalbiruygulama.main.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hacib.duygusalbiruygulama.R
import com.hacib.duygusalbiruygulama.main.list.Model

class ViewHolder(
    private val inflater: LayoutInflater,
    private val parent: ViewGroup
) : RecyclerView.ViewHolder(inflater.inflate(R.layout.recycler_list_item, parent, false)){

    private var txtUserName : TextView?= null
    private var txtEmail : TextView?= null

    init {
        txtUserName = itemView.findViewById(R.id.txtUserName)
        txtEmail = itemView.findViewById(R.id.txtEmail)
    }

    fun bind(model: Model) {
        txtUserName?.text = model.userName
        txtEmail?.text = model.email
    }
}