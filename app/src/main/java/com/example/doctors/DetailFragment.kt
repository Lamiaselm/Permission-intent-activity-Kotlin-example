package com.example.doctors

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        textView.text = arguments?.getString("nom")
        textView2.text = arguments?.getString("prenom")
        textView4.text = arguments?.getString("num")
        textView3.text = arguments?.getString("spec")
        val img= arguments?.getInt("img")

        if (img != null) {
            imageView2.setImageResource(img)
        }
         //CALL  PHONE NUMBER FUNCTION
      val num = arguments?.getString("num")

         textView4.setOnClickListener { view ->

             val uri = Uri.parse("tel:"+num)
             val intent = Intent(Intent.ACTION_CALL, uri)
             if (context?.packageManager?.let { intent.resolveActivity(it) } != null) {
                 context?.startActivity(intent)
             }

             }
         }
    }
