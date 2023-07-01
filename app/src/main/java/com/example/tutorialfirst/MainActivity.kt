package com.example.tutorialfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var firebaseReference: DatabaseReference

    lateinit var button: Button
    lateinit var editText: EditText
    lateinit var Text: TextView
    lateinit var Button2: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * This code helps to set value to the database
         */
        firebaseDatabase =
            FirebaseDatabase.getInstance() // This helps in getting the INSTANCE to whole database
        firebaseReference =
            firebaseDatabase.reference  // This helps in getting  the reference to the root node

        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)
        Text = findViewById(R.id.Text)
        Button2 = findViewById(R.id.button2)

        button.setOnClickListener {
            val name: String = editText.text.toString()
            firebaseReference.setValue(name)

        }

        /**
         * This code helps to read dats from the database
         */


        Button2.setOnClickListener {

            firebaseReference.addListenerForSingleValueEvent(object : ValueEventListener {  // Getting the node from where I want to read data
                override fun onDataChange(snapshot: DataSnapshot) {
                    val data: String? = snapshot.getValue(String::class.java)
                    Text.text = data

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(applicationContext, "Something Went Wrong", Toast.LENGTH_SHORT)
                        .show()

                }

            })

        }


    }
}