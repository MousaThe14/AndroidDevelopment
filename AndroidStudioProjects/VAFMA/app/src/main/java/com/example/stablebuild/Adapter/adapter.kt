package com.example.stablebuild.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.stablebuild.Models.coupons
import com.example.vafma.R

class adapter : RecyclerView.Adapter<adapter.ListerViewer>() {

    private val couponList  = ArrayList<coupons>()

    @Suppress("UseGetLayoutInflater")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListerViewer {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.lister,
            parent, false)

        return ListerViewer(itemView)
    }


    override fun onBindViewHolder(holder: ListerViewer, position: Int) {
        val currentitem = couponList[position]

        holder.market.text = currentitem.market
        holder.code.text = currentitem.code

    }


    override fun getItemCount(): Int {
        return couponList.size
    }

    fun updateCouponList(couponList : List<coupons>){

        this.couponList.clear()
            this.couponList.addAll(couponList)
            notifyDataSetChanged()

    }


    class ListerViewer(itemView : View) : RecyclerView.ViewHolder(itemView){

        val market : TextView = itemView.findViewById(R.id.market_name)
        val code : TextView = itemView.findViewById(R.id.coupon_code)

    }


}