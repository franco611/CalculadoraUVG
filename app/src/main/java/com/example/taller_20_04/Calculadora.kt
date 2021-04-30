package com.example.taller_20_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Calculadora : AppCompatActivity() {
    lateinit var txtResultado: TextView
    lateinit var butAC: Button
    lateinit var butDividir: Button
    lateinit var butSiete: Button
    lateinit var butOcho: Button
    lateinit var butNueve: Button
    lateinit var butPor: Button
    lateinit var butCuatro: Button
    lateinit var butCinco: Button
    lateinit var butSeis: Button
    lateinit var butMenos: Button
    lateinit var butUno: Button
    lateinit var butDos: Button
    lateinit var butTres: Button
    lateinit var butMas: Button
    lateinit var butCero: Button
    lateinit var butPunto: Button
    lateinit var butIgual: Button
    var valor1 : Double =0.0
    var valor2 : Double =0.0
    var res : Double = 0.0
    private var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        txtResultado = findViewById(R.id.txtResultado)
        butUno = findViewById(R.id.butUno)
        butDos = findViewById(R.id.butDos)
        butTres = findViewById(R.id.butTres)
        butMas = findViewById(R.id.butMas)
        butAC = findViewById(R.id.butAC)
        butDividir=findViewById(R.id.butDividir)
        butSiete=findViewById(R.id.butSiete)
        butOcho=findViewById(R.id.butOcho)
        butNueve=findViewById(R.id.butNueve)
        butPor=findViewById(R.id.butPor)
        butCuatro=findViewById(R.id.butCuatro)
        butCinco=findViewById(R.id.butCinco)
        butSeis=findViewById(R.id.butSeis)
        butMenos=findViewById(R.id.butMenos)
        butCero=findViewById(R.id.butCero)
        butPunto=findViewById(R.id.butPunto)
        butIgual=findViewById(R.id.butIgual)



        butUno.setOnClickListener {
            Presion("1")
        }

        butDos.setOnClickListener {
            Presion("2")
        }

        butTres.setOnClickListener {
            Presion("3")
        }

        butCuatro.setOnClickListener {
            Presion("4")
        }

        butCinco.setOnClickListener {
            Presion("5")
        }

        butSeis.setOnClickListener {
            Presion("6")
        }

        butSiete.setOnClickListener {
            Presion("7")
        }

        butOcho.setOnClickListener {
            Presion("8")
        }

        butNueve.setOnClickListener {
            Presion("9")
        }

        butCero.setOnClickListener {
            Presion("0")
        }

        butPunto.setOnClickListener {
            Presion(".")
        }

        butMas.setOnClickListener {
            presbut(SUMA)
        }
        butMenos.setOnClickListener {
            presbut(RESTA)
        }
        butPor.setOnClickListener {
            presbut(MULTIPLICACION)
        }
        butDividir.setOnClickListener {
            presbut(DIVISION)
        }

        butAC.setOnClickListener {
            txtResultado.text = "0"
            valor1 = 0.0
            valor2 = 0.0
            operacion = NO_OPERACION
        }

        butIgual.setOnClickListener {
            res = when(operacion){
                SUMA -> valor1+valor2
                RESTA -> valor1 - valor2
                MULTIPLICACION -> valor1 * valor2
                DIVISION -> valor1 / valor2
                else -> 0.0
            }
            txtResultado.text = res.toString()
        }
    }


    private fun Presion (digito: String){
        txtResultado.text = "${txtResultado.text}$digito"

        if (operacion == NO_OPERACION){
            valor1 = txtResultado.text.toString().toDouble()
        } else {
            valor2 = txtResultado.text.toString().toDouble()
        }
    }

    private fun presbut (operacion: Int){
        this.operacion = operacion
        txtResultado.text = "0"
    }

    companion object{
        const val SUMA=1
        const val RESTA=2
        const val MULTIPLICACION=3
        const val DIVISION=4
        const val NO_OPERACION=0
    }
}