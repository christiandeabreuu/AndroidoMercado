package br.com.zup.caixa_supermercado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.zup.caixa_supermercado.databinding.ActivityMain2Binding
import br.com.zup.caixa_supermercado.databinding.ActivityMainBinding
import br.com.zup.caixa_supermercado.model.Produto

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var produto = intent.getParcelableExtra<Produto>("Produto")
        val binding: ActivityMain2Binding = ActivityMain2Binding.inflate(layoutInflater)
        if (produto != null) {
            val total = produto.getQtd() * produto.getValor()
            val textofinal = getString(R.string.descricao_soma_carrinho).plus(total)
            binding.tvValorTotal.text = textofinal
            //Toast.makeText(this, textofinal, Toast.LENGTH_LONG).show()
        }
    }
}



