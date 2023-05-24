package com.example.atlasdevicesync.ui.home

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.provider.Settings.Secure
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.atlasdevicesync.R
import com.example.atlasdevicesync.bean.Punteggio
import com.example.atlasdevicesync.databinding.FragmentHomeBinding
import com.example.atlasdevicesync.ui.CustomAdapter
import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL
import java.util.Arrays
import java.util.Collections


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var adapter: CustomAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var punteggi: Array<Punteggio>

    lateinit var posizione: Array<String>
    lateinit var punti: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val android_id = Secure.getString(
            requireContext().contentResolver,
            Secure.ANDROID_ID
        )


        val connection = URL("https://eu-central-1.aws.data.mongodb-api.com/app/classifica_http-skyrk/endpoint/getclassifica").openConnection() as HttpURLConnection
        try {
            val dataInput = connection.inputStream.bufferedReader().use { it.readText() }
            val gson = Gson()
            val punteggi: Array<Punteggio> = gson.fromJson(dataInput, Array<Punteggio>::class.java)

            Arrays.sort(punteggi, Collections.reverseOrder());

            for (i in 0..punteggi.size - 1) {
                if(punteggi[i]._id.equals(android_id)) {
                    punteggi[i].isUtente = true
                }
                punteggi[i]._id = Integer.toString(i+1)
            }

            val layoutManager = LinearLayoutManager(context)
            recyclerView = root.findViewById(R.id.classifica)
            recyclerView.layoutManager = layoutManager
            recyclerView.setHasFixedSize(true)
            adapter = CustomAdapter(punteggi)
            recyclerView.adapter = adapter

        } catch(e: Exception) {
            val error = e.message;
        } finally {
            connection.disconnect()
        }

        var identificativo = android_id
        if (android_id.equals("b6bbd4294eaedc5d")) {
            identificativo = android_id + ": Tu "
        }

        val classifica: RecyclerView = binding.classifica
        val list = ArrayList<String>()
        list.add("Dog");
        list.add("Cat");


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}