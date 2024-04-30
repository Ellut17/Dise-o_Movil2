package com.example.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PrimerFragment : Fragment() {

    private lateinit var welcomeText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_primer, container, false)

        val fab: FloatingActionButton = view.findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/alan_ellud/"))
            startActivity(intent)
        }

        welcomeText = view.findViewById(R.id.welcomeText)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userName = arguments?.getString("user_name", "Usuario") ?: "Usuario"
        welcomeText.text = "Bienvenido $userName"

        // Ocultar el mensaje después de 15 segundos (15000 milisegundos)
        Handler(Looper.getMainLooper()).postDelayed({
            welcomeText.visibility = View.GONE
        }, 15000)
    }

    companion object {
        fun newInstance(userName: String): PrimerFragment {
            val fragment = PrimerFragment()
            val args = Bundle()
            args.putString("user_name", userName)
            fragment.arguments = args
            return fragment
        }
    }
}
