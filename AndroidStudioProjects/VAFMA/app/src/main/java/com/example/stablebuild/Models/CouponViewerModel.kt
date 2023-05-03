package com.example.stablebuild.Models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stablebuild.Repository.CouponRepo

class CouponViewerModel : ViewModel() {

    private val repo : CouponRepo
    private val _allcoupons = MutableLiveData<List<coupons>>()
    val allcoupons : LiveData<List<coupons>> = _allcoupons

    init{

        repo = CouponRepo().getInstance()
        repo.loadCoupons(_allcoupons)
    }
}