package com.example.atlasdevicesync.ui.gallery

import android.R
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.atlasdevicesync.databinding.FragmentGalleryBinding
import io.realm.kotlin.Realm
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.sync.SyncConfiguration
import java.text.SimpleDateFormat
import java.util.Calendar


class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        //connectToMongo();

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.labelKM
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val veicolo: Spinner = binding.veicoliSpinner
        val km: EditText = binding.kmPercorsi
        val invia: Button = binding.inviaKm

        val myCalendar = Calendar.getInstance()
        var editText: EditText

        val pickButtonStart: Button = binding.buttonStart
        val labelStart: TextView = binding.labelStart
        pickButtonStart.setOnClickListener {
            // on below line we are getting
            // the instance of our calendar.
            val c = Calendar.getInstance()

            // on below line we are getting our hour, minute.
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)

            // on below line we are initializing
            // our Time Picker Dialog
            val timePickerDialogStart = TimePickerDialog(
                requireContext(),
                { view, hourOfDay, minute ->
                    // on below line we are setting selected
                    // time in our text view.
                    labelStart.setText("$hourOfDay:$minute")
                },
                hour,
                minute,
                false
            )
            // at last we are calling show to
            // display our time picker dialog.
            timePickerDialogStart.show()
        }

        val pickButtonStop: Button = binding.buttonStop
        val labelStop: TextView = binding.labelStop
        pickButtonStop.setOnClickListener {
            // on below line we are getting
            // the instance of our calendar.
            val c = Calendar.getInstance()

            // on below line we are getting our hour, minute.
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minute = c.get(Calendar.MINUTE)

            // on below line we are initializing
            // our Time Picker Dialog
            val timePickerDialogStop = TimePickerDialog(
                requireContext(),
                { view, hourOfDay, minute ->
                    // on below line we are setting selected
                    // time in our text view.
                    labelStop.setText("$hourOfDay:$minute")
                },
                hour,
                minute,
                false
            )
            // at last we are calling show to
            // display our time picker dialog.
            timePickerDialogStop.show()
        }

        invia.setOnClickListener {
            if(km.text.isEmpty() || labelStart.text.isEmpty() || labelStop.text.isEmpty()) {
                Toast.makeText(activity, "Compilare tutti i campi", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(activity, "Selezionati: " + km.text.toString() + " KM" + " percorsi con " + veicolo.selectedItem.toString(), Toast.LENGTH_LONG).show()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*fun connectToMongo() {
        val app = App.create("http_veicoli_vicini-nehfd")
// use constants for query names so you can edit or remove them later
        val NAME_QUERY = "NAME_QUERY"
        runBlocking {
            val user = app.login(Credentials.anonymous())
            val config = SyncConfiguration.Builder(user, setOf(Toad::class))
                .initialSubscriptions { realm ->
                    add(
                        realm.query<Toad>(
                            "name == $0",
                            "name value"
                        ),
                        "subscription name"
                    )
                }
                .build()
            val realm = Realm.open(config)
            Toast.makeText(activity, "Connessione con realm avvenuta con ${realm.configuration.name}", Toast.LENGTH_LONG).show()
            realm.close()
        }
    }*/

}