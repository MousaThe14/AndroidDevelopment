package com.example.stablebuild.Repository

import androidx.lifecycle.MutableLiveData
import com.example.stablebuild.Models.coupons
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CouponRepo {

    private val dbRef : DatabaseReference = FirebaseDatabase.getInstance().getReference("coupons")

    @Volatile private var INSTANCE : CouponRepo ?= null

fun getInstance() : CouponRepo{
        return INSTANCE ?: synchronized(this){

            val instance = CouponRepo()
            INSTANCE = instance
            instance
        }
    }

    fun loadCoupons(couponList : MutableLiveData<List<coupons>>){

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
               try{
                   val _couponList : List<coupons> = snapshot.children.map { dataSnapshot ->
                       dataSnapshot.getValue(coupons::class.java)!!
                   }

                   couponList.postValue(_couponList)

               }catch(e: Exception){

               }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }

}