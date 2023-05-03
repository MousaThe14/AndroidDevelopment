package com.example.stablebuild.ui.coupons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stablebuild.Adapter.adapter
import com.example.stablebuild.Models.CouponViewerModel
import com.example.vafma.R


private lateinit var viewModel : CouponViewerModel
        private lateinit var  recyclerViewer : RecyclerView
lateinit var adapter: adapter

class CouponFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coupon, container, false)
    }


override fun onViewCreated(view: View, savedInstanceState: Bundle?){
    super.onViewCreated(view, savedInstanceState)
    recyclerViewer = view.findViewById(R.id.recyclerView)
    recyclerViewer.layoutManager = LinearLayoutManager(context)
    recyclerViewer.setHasFixedSize(true)
    adapter = adapter()
    recyclerViewer.adapter = adapter

    viewModel = ViewModelProvider(this).get(CouponViewerModel::class.java)
    viewModel.allcoupons.observe(viewLifecycleOwner, Observer {

        adapter.updateCouponList(it)

    }
    )

}

}