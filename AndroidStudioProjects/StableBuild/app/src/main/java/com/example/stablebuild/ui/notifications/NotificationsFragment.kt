package com.example.stablebuild.ui.notifications

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
import com.example.stablebuild.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    //

    override fun onViewCreated(view: View, savedInstanceStance: Bundle?){
        val aboutpage: WebView = view.findViewById(R.id.about)
        aboutpage.webViewClient = object: WebViewClient(){
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
        aboutpage.loadUrl("https://vafma.org/about/")
        aboutpage.settings.javaScriptEnabled = true
        aboutpage.settings.allowContentAccess = true
        aboutpage.settings.domStorageEnabled = true
        aboutpage.settings.useWideViewPort = true
    }
}