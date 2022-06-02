package br.com.zup.caixa_supermercado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.zup.caixa_supermercado.databinding.ActivityMain2Binding
import br.com.zup.caixa_supermercado.databinding.ActivityMainBinding
import br.com.zup.caixa_supermercado.model.Produto

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMain2Binding =  ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val produto  =  intent.getParcelableExtra<Produto>("Produto")
        var textofinal = ""
        val botaoRefazer = binding.btRefazerCompra
        produto?.let {
            val total = it.getQtd() * it.getValor()
           textofinal  = this.getString(R.string.descricao_soma_carrinho, total.toString())

        }
        binding.tvTextoResultado.text = textofinal
        botaoRefazer.setOnClickListener {
            onBackPressed()
        }
    }



}

