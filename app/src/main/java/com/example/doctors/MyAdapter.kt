package com.example.doctors

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class MyAdapter (val context: Context, var data:List<Doctor>): RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.doctor_element, parent, false))
    }

    override fun getItemCount()=data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.nom.text=data[position].nom
        holder.prenom.text=data[position].prenom
        holder.num.text=data[position].num
        holder.spec.text=data[position].speciality
        holder.img.setImageResource(data[position].img)
        //CALL  PHONE NUMBER FUNCTION
        holder.num.setOnClickListener { view ->

            val uri = Uri.parse("tel:" + data[position].num)
            val intent = Intent(Intent.ACTION_CALL, uri)
            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
            }
        }
        //CALL  MAP FUNCTION

        val lat=data[position].lat
        val lang=data[position].lang
        holder.location.setOnClickListener{ view->
            val url=Uri.parse("geo:$lat,$lang")
            val intent= Intent(Intent.ACTION_VIEW,url)
            context.startActivity(intent)
        }
        //SHOW DOCTOR PROFILE FUNCTION

        val doc=data[position]
        holder.doc.setOnClickListener { v->
            if(isTwoPane()) {
                val activity = context as Activity
                val img = activity.findViewById(R.id.imageView2) as ImageView
                img.setImageResource(data[position].img)
                val name = activity.findViewById<TextView>(R.id.textView)
                name.text=data[position].nom
                val prenom = activity.findViewById<TextView>(R.id.textView2)
                prenom.text=data[position].prenom
                val spec = activity.findViewById<TextView>(R.id.textView3)
                spec.text=data[position].speciality
                val num = activity.findViewById<TextView>(R.id.textView4)
                num.text=data[position].num


            }else {
                val intent=Intent(context,InfoDoctor::class.java).apply {
                    putExtra("doctor",doc)

                }
                context.startActivity(intent)
            }

        }
    }
    private fun isTwoPane():Boolean{
        val activity = context as Activity
        return activity.findViewById<View>(R.id.fragment2)!=null
    }

}


class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nom= view.findViewById<TextView>(R.id.textViewNom)
    val prenom= view.findViewById<TextView>(R.id.textViewPrenom)
    val num= view.findViewById<TextView>(R.id.textViewNum)
    val spec= view.findViewById<TextView>(R.id.textViewSpecialite)
    val img= view.findViewById<ImageView>(R.id.imageView)
    val location =view.findViewById<ImageView>(R.id.loc)
    val doc=view.findViewById<ConstraintLayout>(R.id.doc)
}