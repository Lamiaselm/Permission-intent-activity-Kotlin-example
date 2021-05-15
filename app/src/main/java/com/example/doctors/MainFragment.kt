package com.example.doctors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val vm = ViewModelProvider(this).get(DocViewModel::class.java)
        list_doc.apply {
            list_doc.layoutManager = LinearLayoutManager(activity)
            list_doc.adapter = MyAdapter(context,loadData())
            list_doc.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }


    }
    fun loadData():List<Doctor> {
        val data = mutableListOf<Doctor>()
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic1,36.72242413411826, 3.168844018174953))
        data.add(Doctor("Selmane","Lamia","05554678","pediate",R.drawable.pic2,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Souha","05554678","dentiste",R.drawable.pic3,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Issam","05554678","dentiste",R.drawable.pic4,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Abdelkader","05554678","dentiste",R.drawable.pic5,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Halim","05554678","dentiste",R.drawable.pic6,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic8,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic1,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic3,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic4,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic5,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic6,36.71132958509183, 3.160282609052669))
        data.add(Doctor("Nekamiche","Noha","05554678","dentiste",R.drawable.pic7,36.71132958509183, 3.160282609052669))
        return data
    }
}