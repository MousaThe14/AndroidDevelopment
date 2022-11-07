package com.example.stablebuild.ui.drawing

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
import com.example.stablebuild.databinding.FragmentDrawingBinding

class DrawingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_drawing, container, false)
    }

    //

    override fun onViewCreated(view: View, savedInstanceStance: Bundle?){
        val drawingpage: WebView = view.findViewById(R.id.drawing)
        drawingpage.webViewClient = object: WebViewClient(){
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
        drawingpage.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSfF_XxDDwY6gKmPuG1pVmU3zMgGN0SPCIbfq8KBwDhweFT68g/viewform")
        drawingpage.settings.javaScriptEnabled = true
        drawingpage.settings.allowContentAccess = true
        drawingpage.settings.domStorageEnabled = true
        drawingpage.settings.useWideViewPort = true
    }
}