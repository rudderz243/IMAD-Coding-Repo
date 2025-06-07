package com.example.libraryexample

class LibraryBook {
    // when creating a class, we start off with its attributes
    // the attributes are any information that we want to store about the class
    var title: String = ""
    var author: String = ""
    var volume: Int = 0
    var isbn: String = ""

    // then, we created a special method, called a constructor
    // the constructor tells android studio exactly what to expect when we
    // create a new library book
    constructor(title: String, author: String, volume: Int, isbn: String) {
        // we take the information from the main program, and set the values
        // inside the class
        this.title = title
        this.author = author
        this.volume = volume
        this.isbn = isbn
    }
}