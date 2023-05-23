package com.example.atlasdevicesync.ui.slideshow

import android.os.Bundle
import android.os.StrictMode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.atlasdevicesync.bean.Veicoli
import com.example.atlasdevicesync.databinding.FragmentSlideshowBinding
import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL


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
        //webView.loadUrl("https://www.google.it")
        val iframe = "<iframe style=\"background: #FFFFFF;border: none;border-radius: 2px;box-shadow: 0 2px 10px 0 rgba(70, 76, 79, .2);\" width=\"640\" height=\"480\" src=\"https://charts.mongodb.com/charts-hackathon-sogei-team1-jawas/embed/charts?id=646b7231-bf43-4734-8206-b2784f4eb495&maxDataAge=3600&theme=light&autoRefresh=true\"></iframe>";
        webView.loadData(iframe,"text/html", null);
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val connection = URL("https://eu-central-1.aws.data.mongodb-api.com/app/http_veicoli_vicini-nehfd/endpoint/veicolivicini?arg1=12.485572&arg2=41.797275").openConnection() as HttpURLConnection
        try {
            val dataInput = connection.inputStream.bufferedReader().use { it.readText() }
            //val doc: Document = Document.parse(dataInput)
            val gson = Gson()
            val veicoli: Array<Veicoli> = gson.fromJson(dataInput, Array<Veicoli>::class.java)
            val veicolo = veicoli.get(0)
            val a = 1
        } catch(e: Exception) {
            val error = e.message;
        } finally {
            connection.disconnect()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}