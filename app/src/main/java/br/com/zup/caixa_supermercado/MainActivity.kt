package br.com.zup.caixa_supermercado

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import br.com.zup.caixa_supermercado.databinding.ActivityMainBinding
import br.com.zup.caixa_supermercado.model.Produto


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //build gradle
    private lateinit var nomeProduto: String
    private lateinit var valorProduto: String
    private lateinit var qtdProduto: String
    private lateinit var produto: Produto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportActionBar?.setTitle(R.string.name_home)
        val buttonCalcular = binding.btCalcular
        buttonCalcular.setOnClickListener {
            nomeProduto = binding.etNomeProduto.text.toString()
            qtdProduto = binding.etQuantidadeProduto.text.toString()
            valorProduto = binding.etValorUnitario.text.toString()

            if (verificarEntradas(nomeProduto, qtdProduto, valorProduto)) {
                val intent = Intent(this, MainActivity2::class.java).apply{
                    putExtra("Produto", produto)

                }
                startActivity(intent)

            } else {
                mostrarMsgErro(
                    nomeProduto.isNotBlank(),
                    binding.etNomeProduto,
                    "Campo obrigatório"
                )
                mostrarMsgErro(
                    valorProduto.isNotBlank(),
                    binding.etValorUnitario,
                    "Campo obrigatório"
                )
                mostrarMsgErro(
                    nomeProduto.isNotBlank(),
                    binding.etQuantidadeProduto,
                    "Campo obrigatório"
                )
            }
        }

    }

    fun verificarEntradas(nome: String, qtd: String, valor: String): Boolean {
        if (nome.isNotBlank() && qtd.isNotBlank() && valor.isNotBlank()) {

            produto = Produto(nome, qtd.toInt(), valor.toDouble())
        }
        return nome.isNotBlank() && qtd.isNotBlank() && valor.isNotBlank()
    }

    fun mostrarMsgErro(ehValido: Boolean, editText: EditText, msg: String) {
        if (!ehValido) {
            editText.error = msg
        }
    }


}