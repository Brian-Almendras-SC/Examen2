package com.ucb.examen2
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

var DB="bookRepository"
var tabla="book"

class SQLite(context: Context):SQLiteOpenHelper(context,DB,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        var sql= "create table book (title VARCHAR(25),description VARCHAR(25))"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertarDatos(book:Book):String{
        val db=this.writableDatabase
        var contenedor= ContentValues()
        contenedor.put("title",book.title)
        contenedor.put("description",book.description)

        var res=db.insert("book",null,contenedor)
        if(res==-1.toLong()){
            return "existio una falla"
        }
        else{
            return "exitoso "
        }
    }
}