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
        setContentView(R.layout.activity_main2)
        val binding = ActivityMain2Binding.inflate(layoutInflater)

        val produto = intent.getParcelableExtra<Produto>("Produto")


        Toast.makeText(this, "${produto?.getValor()}", Toast.LENGTH_LONG)
        produto?.let {
            val total = it.getQtd() * it.getValor()

            binding.tvValorTotal.text = "O VALOR TOTAL DA COMPRAaaa É DE: R$ ${total}"
        }
    }
}