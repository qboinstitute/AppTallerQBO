package qbo.com.apptallerqbo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main2.*
import java.text.DecimalFormat

class Main2Activity : AppCompatActivity() {

    val lstimc = ArrayList<String>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        btncalcularimckt.setOnClickListener {
            if(etpesokt.text.toString() ==""){
                etpesokt.error = "Ingrese su peso"
            }else if(ettallakt.text.toString() == ""){
                ettallakt.error = "Ingrese su talla"
            }else{
                var peso : Double = etpesokt.text.toString().toDouble()
                var talla: Double = ettallakt.text.toString().toDouble()
                var tallam: Double
                var imc: Double
                var resultadoimc: String
                tallam = talla / 100
                imc = peso / (tallam * tallam)
                if(imc <= 18.5){
                    resultadoimc = "por debajo del peso"
                }else if(imc <= 25){
                    resultadoimc = "con peso normal"
                }else if(imc <= 30){
                    resultadoimc = "con sobrepeso"
                }else if(imc <= 35){
                    resultadoimc = "con obesidad leve"
                }else if(imc <= 39){
                    resultadoimc = "con obesidad media"
                }else{
                    resultadoimc = "con obesidad mórbida"
                }
                val df = DecimalFormat("##.00")
                tvresultadoimckt.text = ("Su valor de imc: "+ df.format(imc)
                        +" ud se encuentra: "+ resultadoimc)
                lstimc.add("Valor IMC: " +df.format(imc) +" "+resultadoimc)
                val adapter = ArrayAdapter(
                        this,
                        android.R.layout.simple_list_item_1,
                        lstimc
                )
                lvimckt.adapter = adapter


            }
        }


    }

    private fun MetodoQBO(numero: Int): String {
        val nombre = "Luis"
        var apellido: String
        apellido = "Salvatierra"
        var edad: Int
        var peso: Double
        return "QBO"
    }
}
