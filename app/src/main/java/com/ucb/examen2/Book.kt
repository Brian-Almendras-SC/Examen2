package com.ucb.examen2

import android.icu.text.CaseMap.Title
import java.io.FileDescriptor

class Book {
    var title: String=""
    var description:String=""
    constructor(){

    }
    constructor(title: String,description:String){
        this.title=title
        this.description=description
    }
}