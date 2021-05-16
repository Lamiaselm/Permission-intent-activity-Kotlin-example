package com.example.doctors

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.doctor_element.*

class InfoDoctor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_doctor)

        val doc=intent.getSerializableExtra("doctor") as Doctor

        val img= findViewById<ImageView>(R.id.imageView2) as ImageView
        val nom=findViewById<TextView>(R.id.textView) as TextView
        val prenom =findViewById<TextView>(R.id.textView2) as TextView
        val specialite=findViewById<TextView>(R.id.textView3) as TextView
        val num=findViewById<TextView>(R.id.textView4) as TextView

        nom.text=doc.nom
        prenom.text=doc.prenom
        specialite.text=doc.speciality
        num.text=doc.num

        img.setImageResource(doc.img)
        //CALL  PHONE NUMBER FUNCTION
        num.setOnClickListener { view ->

            val uri = Uri.parse("tel:"+doc.num)
            val intent = Intent(Intent.ACTION_CALL, uri)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }

    }
}