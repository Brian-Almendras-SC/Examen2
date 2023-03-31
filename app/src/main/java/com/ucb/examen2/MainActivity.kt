package com.ucb.examen2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    val restApiAdapter = RestApiAdapter()
    val endPoint = restApiAdapter.connectionApi()
    val bookResponseCall = endPoint.getAllPost()
    val listPost= ArrayList<Post>()
    var count=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list=
            Post(2,1,"Primer","ASDASdad")
        val linearLayoutManager= LinearLayoutManager(this)
        linearLayoutManager.orientation= LinearLayoutManager.VERTICAL
        Log.d("entre","entre")

        bookResponseCall.enqueue( object : Callback<List<Post>>{

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            Log.d("error","No se puede conectar")
            t?.printStackTrace()
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                Log.d("entre","entre onResponse")
                //Log.d("esto tiene response",response.body().toString())
                val posts = response.body()

                Log.d("RESP POST", Gson().toJson(posts))
                posts?.forEach {
                    Log.d("RESP POST", it.body)
                    listPost.add(it)
                }
            }
        })
        recyclerView=findViewById(R.id.recycler_view)
        recyclerView.layoutManager=linearLayoutManager
        //
        recyclerView.adapter=BookListAdapter(listPost,this)
    }
}