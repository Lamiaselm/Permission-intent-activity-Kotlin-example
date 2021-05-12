package com.example.doctors

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setContentView(R.layout.activity_info_doctor)

        val doc=intent.getSerializableExtra("doctor") as Doctor

        val img= findViewById<ImageView>(R.id.imageView2)
        val nom=findViewById<TextView>(R.id.textView)
        val prenom =findViewById<TextView>(R.id.textView2)
        val specialite=findViewById<TextView>(R.id.textView3)
        val num=findViewById<TextView>(R.id.textView4)

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