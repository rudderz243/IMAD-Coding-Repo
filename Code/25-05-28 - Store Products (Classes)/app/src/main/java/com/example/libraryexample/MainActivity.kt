package com.example.libraryexample

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // declare variables for our UI components
        val btnView = findViewById<Button>(R.id.btnView)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)

        // we create the array of books for our library
        var libraryBooks = Array<LibraryBook>(5) { LibraryBook("", "", 0, "") }
        // we give a default value of blank for the title and author, 0 for the
        // volume, and blank for the ISBN, as we will set them later

        // we create books to fill our array with information
        libraryBooks[0] = LibraryBook("Harry Potter", "JK Rowling", 24, "123-abc")
        libraryBooks[1] = LibraryBook("Romeo and Juliet", "Willem Wikkelspies", 1, "098-bca")
        libraryBooks[2] = LibraryBook("Tsotsi", "Uhhhh", 21, "21-34-aa")
        libraryBooks[3] = LibraryBook("Diary of a Wimpy Kid", "Unknown", 10, "a-number-1")
        libraryBooks[4] = LibraryBook("Game of Thrones", "George RR Martin", 8, "123-456-fgj")

        // when the user clicks the button, display all information about the books in the library
        btnView.setOnClickListener {
            // looping through all of the books using a FOR loop and i as our counter
            var outputString = ""
            for (i in 0..4) {
                outputString += libraryBooks[i].title + ", "
                outputString += libraryBooks[i].author + ", "
                outputString += libraryBooks[i].volume.toString() + ", "
                outputString += libraryBooks[i].isbn + "\n"
            }

            // looping through all of the books using a WHILE loop and counter variable
            outputString = ""
            var counter = 0
            while (counter < 5) {
                outputString += libraryBooks[counter].title + ", "
                outputString += libraryBooks[counter].author + ", "
                outputString += libraryBooks[counter].volume.toString() + ", "
                outputString += libraryBooks[counter].isbn + "\n"
                // don't forget this line when using a while loop!
                counter++
            }

            // display the output that we built to the user in the textview
            lblOutput.text = outputString
        }
    }
}