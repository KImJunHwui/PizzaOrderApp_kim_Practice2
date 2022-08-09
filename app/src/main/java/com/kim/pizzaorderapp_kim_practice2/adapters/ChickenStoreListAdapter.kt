package com.kim.pizzaorderapp_kim_practice2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.kim.pizzaorderapp_kim_practice2.R
import com.kim.pizzaorderapp_kim_practice2.datas.Store

class ChickenStoreListAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : List<Store>) : ArrayAdapter<Store>(mContext, resId, mList) {

    val inflater  = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView

        if(tempRow == null){

            tempRow = inflater.inflate(R.layout.chickenstore_list_item, null)

        }

        val row = tempRow!!

        val data = mList[position]

        val chickenStoreImg = row.findViewById<ImageView>(R.id.chickenStoreImg)
        val chickenStoreNameTxt = row.findViewById<TextView>(R.id.chickenStoreNameTxt)

        chickenStoreNameTxt.text = data.name

        Glide.with(mContext).load(data.imgUrl).into(chickenStoreImg)

        return row

    }


}