package com.ucb.examen2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list= arrayListOf<Book>(
            Book("1","1","Primer libro","hola")
        )
        val linearLayoutManager= LinearLayoutManager(this)
        linearLayoutManager.orientation= LinearLayoutManager.VERTICAL

        recyclerView=findViewById(R.id.recycler_view)
        recyclerView.layoutManager=linearLayoutManager
        recyclerView.adapter=BookListAdapter(list,this)

    }
}