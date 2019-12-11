package br.com.IntroAndroid.estaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Manipular a execução - PostDelayed
        Handler().postDelayed({ //O que estiver dentro desta chave será executado após os 3s do delay
            //Crianco uma intent explicita
            val intentLogin = Intent(this@SplashActivity,LoginActivity::class.java)//Dentro desse parametro, você tem que colocar de onde você está, para onde você precisa ir
            //Executando a intent
            startActivity(intentLogin) //Dentro do parametro deve-se colocar a intent que quer executar

        },4000)  //Manipula uma tred, ele pausa o sistema, neste caso por 3s
    }
}
