package mx.edu.itson.asignacion4_calculadora_imc

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

   //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular: Button = findViewById(R.id.btnCalcular)
        calcular.setOnClickListener {
            calcular()
        }
    }

    @SuppressLint("ResourceAsColor")
    fun calcular(){


            var etPeso: EditText = findViewById(R.id.peso);
            var etEstatura: EditText = findViewById(R.id.estatura)
            var peso: Double = 0.0
            var estatura: Double = 0.0

            val tvIMC: TextView = findViewById(R.id.IMC)
            val tvEstatus: TextView = findViewById(R.id.estatus)

            if(etPeso.text.toString().isEmpty()||etEstatura.text.toString().isEmpty()){
                tvIMC.setText("Debes ingresar datos")
                return
            }

            try {
                peso= etPeso.text.toString().toDouble()
                estatura = etEstatura.text.toString().toDouble()

            }catch (e: java.lang.Exception){
                tvIMC.setText("Debes ingresar datos")
            }

            var IMC = peso / (estatura * estatura)

            tvIMC.setText(IMC.toString())

            when {
                IMC < 18.5 -> {
                    tvEstatus.setText("Bajo de peso")
                    tvEstatus.setBackgroundResource(R.color.md_brown_400)
                }
                IMC >= 18.5 && IMC <= 24.9 -> {
                    tvEstatus.setText("Saludable")
                    tvEstatus.setBackgroundResource(R.color.md_green_500)
                }
                IMC > 24.9 && IMC <= 29.9 -> {
                    tvEstatus.setText("Sobrepeso")
                    tvEstatus.setBackgroundResource(R.color.md_amber_100)
                }
                IMC > 29.9 && IMC <= 34.9 -> {
                    tvEstatus.setText("Obesidad de grado 1")
                    tvEstatus.setBackgroundResource(R.color.md_yellow_400)
                }
                IMC > 34.9 && IMC <= 39.9 -> {
                    tvEstatus.setText("Obesidad de grado 2")
                    tvEstatus.setBackgroundResource(R.color.md_orange_300)
                }
                IMC >= 40 -> {
                    tvEstatus.setText("Obesidad de grado 3")
                    tvEstatus.setBackgroundResource(R.color.md_red_500)
                }
            }
        }
    }