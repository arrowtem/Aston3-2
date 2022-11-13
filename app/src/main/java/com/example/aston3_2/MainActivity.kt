package com.example.aston3_2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


class MainActivity : AppCompatActivity() {
    private lateinit var editText:EditText
    private lateinit var imageView:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText=  findViewById(R.id.urlContainer)
        imageView = findViewById(R.id.imageContainer)
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int,
                                           before: Int, count: Int) {
                loadImage(s)
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })

    }

    fun loadImage(s: CharSequence){
        try {
            Picasso.get()
                .load(s.toString())
                .into(imageView, object : Callback {
                    override fun onSuccess() {
                    }
                    override fun onError(e: Exception?) {
                        Toast.makeText(
                            applicationContext,
                            "Error loading picture",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        }
        catch (e: IllegalArgumentException){

        }

    }

}