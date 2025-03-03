package vcmsa.ci.helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // AUTOMATICALLY GENERATED - DO NOT TOUCH
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // END OF AUTOMATICALLY GENERATED CODE

        // declaring variables for the different components we added to the layout
        val btn_click = findViewById<Button>(R.id.btn_click)
        val lbl_output = findViewById<TextView>(R.id.lbl_output)
        val txt_name = findViewById<EditText>(R.id.txt_name)

        // telling android studio what to do when the button is clicked
        btn_click.setOnClickListener {
            // getting the text from the textbox, and assigning it to a variable
            val name: String = txt_name.text.toString()
            // changing the text in the label
            lbl_output.text = "Hello, " + name
        }
    }
}