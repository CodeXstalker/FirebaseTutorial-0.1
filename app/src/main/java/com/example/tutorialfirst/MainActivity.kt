package com.example.tutorialfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var firebaseReference: DatabaseReference

    lateinit var button :Button
    lateinit var editText: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * This code helps to set value to the database
         */
        firebaseDatabase = FirebaseDatabase.getInstance() // This helps in getting the INSTANCE to whole database
        firebaseReference = firebaseDatabase.reference  // This helps in getting  the reference to the root node

        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)

        button.setOnClickListener{
            val name: String = editText.text.toString()
            firebaseReference.setValue(name)

        }






    }
}