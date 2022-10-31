package com.example.stablebuild.ui.dashboard

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.stablebuild.R
import com.example.stablebuild.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    //

    override fun onViewCreated(view: View, savedInstanceStance: Bundle?){
        val excursionpage: WebView = view.findViewById(R.id.excursions)
        excursionpage.webViewClient = object: WebViewClient(){
            @Deprecated("Deprecated in Java")
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
        excursionpage.loadUrl("https://www.lovevamarkets.org/blog")
        excursionpage.settings.javaScriptEnabled = true
        excursionpage.settings.allowContentAccess = true
        excursionpage.settings.domStorageEnabled = true
        excursionpage.settings.useWideViewPort = true
    }
}