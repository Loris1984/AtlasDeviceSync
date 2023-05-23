package com.example.atlasdevicesync.ui.home

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.provider.Settings.Secure
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.atlasdevicesync.databinding.FragmentHomeBinding
import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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

        var identificativo = android_id
        if (android_id.equals("b6bbd4294eaedc5d")) {
            identificativo = android_id + ": Tu "
        }
        val textView: TextView = binding.texthome
        textView.text = identificativo;

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