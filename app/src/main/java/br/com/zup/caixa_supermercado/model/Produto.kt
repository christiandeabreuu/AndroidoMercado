package br.com.zup.caixa_supermercado.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Produto( private val nome : String, private val qtd : Int, private val valor : Double) :
    Parcelable {

    fun getNome() = this.nome
    fun getValor() = this.valor
    fun getQtd() = this.qtd


}
