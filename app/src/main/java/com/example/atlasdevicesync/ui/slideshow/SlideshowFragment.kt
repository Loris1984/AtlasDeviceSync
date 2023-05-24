package com.example.atlasdevicesync.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.atlasdevicesync.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val webView: WebView = binding.webView
        webView.loadUrl("https://charts.mongodb.com/charts-hackathon-sogei-team1-jawas/embed/charts?id=646b7231-bf43-4734-8206-b2784f4eb495&maxDataAge=3600&theme=light&autoRefresh=true")
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}