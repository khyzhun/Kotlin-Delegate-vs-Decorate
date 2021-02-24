package com.khyzhun.kotlindelegates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

	private lateinit var editTextFirstName: EditText
	private lateinit var editTextLastName: EditText
	private lateinit var textView: TextView
	private lateinit var button: Button

	private val person = Person()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		editTextFirstName = findViewById(R.id.editTextFirstName)
		editTextLastName = findViewById(R.id.editTextLastName)
		textView = findViewById(R.id.textView)
		button = findViewById(R.id.button)

		button.setOnClickListener {
			person.firstName = editTextFirstName.text.toString()
			person.lastName = editTextLastName.text.toString()
			textView.text = "${person.firstName} ${person.lastName} | ${person.updateCount}"
		}


	}






}