package br.com.IntroAndroid.estaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Abrindo o Shared Preference
        val minhaPreferencia = getSharedPreferences("Minha-preferencia", Context.MODE_PRIVATE)

        //Resgatando as informações do Shared Preference
        val name = minhaPreferencia.getString("name", "Não localizado")
        val email = minhaPreferencia.getString("email", "Não localizado")
        val surname = minhaPreferencia.getString("surname", "Não localizado")
        val senha_cadastro = minhaPreferencia.getString("senha_cadastro", "Não localizado")
        val idade = minhaPreferencia.getString("idade", "Não localizado")

        txtNomeFulano.text = "$name $surname"
        txtEmailFulano.text = email
        txtIdadeFulano.text = "$idade anos"

        btnExit.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finishAffinity()
        }
        btnSite.setOnClickListener {
            startActivity(Intent(this@MainActivity, WebActivity::class.java))
        }
    }
}
