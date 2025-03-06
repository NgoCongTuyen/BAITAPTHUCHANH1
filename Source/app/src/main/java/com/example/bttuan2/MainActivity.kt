package com.example.bttuan2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtHoTen = findViewById<EditText>(R.id.edit_HoTen)
        val edtTuoi = findViewById<EditText>(R.id.edit_Tuoi)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCheck.setOnClickListener({
            val hoTen = edtHoTen.text.toString().trim()
            val tuoi = edtTuoi.text.toString().trim()

            if(hoTen.isEmpty()){
                edtHoTen.error = "Vui lòng nhập tên lại!"
                return@setOnClickListener
            }

            if(tuoi.isEmpty()){
                edtTuoi.error = "Vui lòng nhập tuổi lại!"
                return@setOnClickListener
            }

            val tuoiInt = tuoi.toInt()

            val result = when{
                tuoiInt > 65 ->"Người già"
                tuoiInt in 6..65 -> "Người lớn"
                tuoiInt in 2..5 -> "Trẻ em"
                tuoiInt <2 -> "Em bé"
                else -> "Không hợp lệ"
            }
            edtTuoi.error = null
            edtHoTen.error = null
            tvResult.text = "$hoTen là $result"
        })
    }

}