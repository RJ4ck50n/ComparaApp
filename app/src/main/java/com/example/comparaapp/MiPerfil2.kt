package com.example.comparaapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_mi_perfil2.*

enum class ProviderType {
    BASIC,
    GOOGLE
}

class MiPerfil2 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_perfil2)


        // Setup
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email ?: "", provider ?: "")

        //Guardado de datos

        val prefs = getSharedPreferences(getString(R.string.prefs_file),
                Context.MODE_PRIVATE).edit()
        prefs.putString("email", email)
        prefs.putString("provider", provider)
        prefs.apply()


        val bottomNavigationView =
                findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Establecer activity por defecto
        bottomNavigationView.selectedItemId = R.id.MiPerfil

        //Realizar el llamado del Item seleccionado
        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Inicio -> {
                    startActivity(
                            Intent(
                                    applicationContext
                                    , MainActivity::class.java
                            )
                    )
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.Compara -> {
                    startActivity(
                            Intent(
                                    applicationContext
                                    , ComparaActivity::class.java
                            )
                    )
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.MiPerfil -> return@OnNavigationItemSelectedListener true
            }
            false
        })
    }


    private fun setup(email: String, provider: String) {

        // Agregamos los valores a los id de los layouts
        emailTextView.text = email
        providerTextView.text = provider


        btn_CerrarSesion.setOnClickListener {
            //Borrado de datos
            val prefs = getSharedPreferences(getString(R.string.prefs_file),
                    Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()

            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }

        btn_MiActividad.setOnClickListener {
            startActivity(Intent(this, MapActivity::class.java))
        }


    }


}