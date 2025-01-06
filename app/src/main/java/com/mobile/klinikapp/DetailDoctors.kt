package com.mobile.klinikapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailDoctors : AppCompatActivity() {
    private lateinit var imgDoctors : ImageView
    private lateinit var txtNama : TextView
    private lateinit var txtSpesifikasi : TextView
    private lateinit var txtReview : TextView
    private lateinit var ratingBar : RatingBar
    private lateinit var txtRating : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_doctors)

        txtNama = findViewById(R.id.imgNama)
        txtReview = findViewById(R.id.txtReview)
        txtRating = findViewById(R.id.txtRating)
        txtSpesifikasi = findViewById(R.id.txtSpes)
        imgDoctors = findViewById(R.id.imgDoctor)
        ratingBar = findViewById(R.id.rating)

        //get Data
        val detailNama = intent.getStringExtra("NamaDoctor")
        val detailSpec = intent.getStringExtra("Spesdoctors")
        val detailreview= intent.getStringExtra("JumlahReview")
        val detailRating = intent.getStringExtra("JumlahRating")
        val detailImg = intent.getIntExtra("ImgDoctor",0)
        //set data ke widget

        txtNama.setText(detailNama)
        txtRating.setText(detailRating)
        txtReview.setText(detailreview)
        txtSpesifikasi.setText(detailSpec)
        imgDoctors.setImageResource(detailImg)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}