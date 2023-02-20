//Fragment solution sourced from Stack Overflow:
// https://stackoverflow.com/questions/65401994/webview-in-fragment-doesnt-load-any-webpage-kotlin-android

package com.example.vafma.ui.map

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.databinding.DataBindingUtil
import com.example.vafma.R
import android.webkit.WebSettings
import com.example.vafma.R.layout
import com.example.vafma.databinding.FragmentMapBinding

class MapFragment : Fragment() {

    // private var _binding: FragmentMapBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
  //  private val binding get() = _binding!!
  //  private lateinit var _binding: FragmentMapBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    //
    //mappage.webViewClient = object : WebViewClient() {
        override fun onViewCreated(view: View, savedInstanceStance: Bundle?){
        val mappage: WebView = view.findViewById(R.id.map)
            mappage.webViewClient = object: WebViewClient(){
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: String

        ): Boolean {
                    if (view != null) {
                        view.loadUrl(request)
                    }
            return true
        }
    }
        mappage.loadUrl("https://marketspread.com/virginia/?stripped=1")
        mappage.settings.javaScriptEnabled = true
        mappage.settings.allowContentAccess = true
        mappage.settings.domStorageEnabled = true
        mappage.settings.useWideViewPort = true
        //_binding = FragmentMapBinding.inflate(inflater, container, false)
     //   val binding: FragmentMapBinding = DataBindingUtil.setContentView(this, R.layout.fragment_home)

        //binding.map.loadUrl("http://www.example.com")


        //
       //  val root: View = binding.root


       // return root
  //  }

   // override fun onDestroyView() {
      //  super.onDestroyView()
      //  _binding = null
    }
}