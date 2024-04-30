package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userName = intent.getStringExtra("user_name") ?: "Usuario"

        navigation = findViewById(R.id.navMenu)
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itemFragment1 -> {
                    val fragment = PrimerFragment.newInstance(userName)
                    supportFragmentManager.commit {
                        replace(R.id.frameContainer, fragment)
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                    true
                }
                R.id.itemFragment2 -> {
                    supportFragmentManager.commit {
                        replace<SegundoFragment>(R.id.frameContainer)
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                    true
                }
                R.id.itemFragment3 -> {
                    supportFragmentManager.commit {
                        replace<TercerFragment>(R.id.frameContainer)
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                    true
                }
                R.id.itemFragment4-> {
                    supportFragmentManager.commit {
                        replace<CuartoFragment>(R.id.frameContainer)
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                    true
                }
                R.id.itemFragment5 -> {
                    supportFragmentManager.commit {
                        replace<QuintoFragment>(R.id.frameContainer)
                        setReorderingAllowed(true)
                        addToBackStack(null)
                    }
                    true
                }
                // Añade los demás casos si tienes más items
                else -> false
            }
        }

        if (savedInstanceState == null) {
            navigation.selectedItemId = R.id.itemFragment1 // Asume que itemFragment1 es el ID del primer elemento.
        }
    }
}
