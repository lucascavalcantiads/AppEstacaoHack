package br.com.IntroAndroid.estaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btnRegister

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val listaIdades  = arrayListOf<String>("Selecione a idade")  //Criação de lista >>> <colocar o tipo de dados>, no caso se você quisse colocar os nomes manualemnte, não precisa setar o tipo e dentro dos parenteses, colocar o nome depois virgula, outro nome até nao querer mais

        for(i in 1..100){ //Criando o for para colocar o numero de 1 a 100
            listaIdades.add("$i")
        }
        val adapterIdades = ArrayAdapter(this@CadastroActivity, android.R.layout.simple_spinner_dropdown_item, listaIdades) //1°Parametro contexto, tela aonde sera exibida, 2°Parametro formato da lista, como ela vai ser exibida, 3°Parametro a lista que sera exibida
        spnIdade.adapter = adapterIdades

        //Configurando o Shared Preferences
        val minhaPrefenrecia = getSharedPreferences("Minha-preferencia", Context.MODE_PRIVATE) //1°Nome do arquivo que vai criar, 2°Modo de como você acessa esse arquivo, no caso o privite só essa variavel acessa o arquivo, 3°
        val meuEditor = minhaPrefenrecia.edit() //Variavel que vai ser utilizada para incluir coisas no Shared Preference


        btnRegister.setOnClickListener {//Botão de cadastro

            //Variáveis utilizadas
            val name = edtNome.text.toString().trim()
            val surname = edtSobrenome.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val senha_cadastro = edtPassword1.text.toString()

            if(name.isEmpty() || surname.isEmpty() || email.isEmpty() || senha_cadastro.isEmpty()){ //Testando se o valor de algum botão esta vazio
                Toast.makeText(this@CadastroActivity, "Verificar o preenchimento", Toast.LENGTH_LONG).show()//Vai exibir uma mensagem no rodapé do aplicativo, 1°Parametro tela que você está, 2°Parametro texto, 3°Parametro tempo da mensagem (Toast.LENGTH_SHORT), o comando showé para exibir
            }
            else{
                if (spnIdade.selectedItemPosition == 0){//Validando o Spinner
                    Toast.makeText(this@CadastroActivity, "Verificar o preenchimento", Toast.LENGTH_LONG).show()//Vai exibir uma mensagem no rodapé do aplicativo, 1°Parametro tela que você está, 2°Parametro texto, 3°Parametro tempo da mensagem (Toast.LENGTH_SHORT), o comando showé para exibir
                }
                else{//Quando tudo der certo
                    //Colocando as informações dentro das chaves que ficam no meuEditor, que é  o Shared Preferences
                    meuEditor.putString("name",name).apply()
                    meuEditor.putString("surname",surname).apply()
                    meuEditor.putString("email",email).apply()
                    meuEditor.putString("senha_cadastro",senha_cadastro).apply()
                    meuEditor.putString("idade",spnIdade.selectedItem.toString()).apply()

                    //Alertando que o cadastro foi efetuado
                    AlertDialog.Builder(this@CadastroActivity)
                        .setTitle("Sucesso") //Titulo
                        .setMessage("Usuário Cadastrado")
                        .setPositiveButton("OK"){_,_ ->
                            //Indo para a próxima tela
                            val intentMain = Intent(this@CadastroActivity, MainActivity::class.java)
                            startActivity(intentMain)
                        }
                        .setCancelable(false)//Ele bloqueia que o usuario feche o alerta clicando fora do alerta
                        .create()
                        .show()
                }
            }
        }
    }
}
