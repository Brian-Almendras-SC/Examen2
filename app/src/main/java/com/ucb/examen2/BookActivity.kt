package com.ucb.examen2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class BookActivity : AppCompatActivity() {
    lateinit var titleBook:EditText
    lateinit var descriptionBook: EditText
    lateinit var btnSave:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)
        titleBook=findViewById(R.id.teb_title)
        descriptionBook=findViewById(R.id.teb_description)
    }



    fun GuardarDatos(view:View){
        var Db=SQLite(this)
        var bookLocal=Book()
        if (titleBook.text.toString().length>=0 && descriptionBook.text.toString().length>=0) {
            bookLocal.title = titleBook.text.toString()
            bookLocal.description = descriptionBook.text.toString()
            var res=Db.insertarDatos(bookLocal)
            Log.d("base de datos ",res)
        }
    }


}