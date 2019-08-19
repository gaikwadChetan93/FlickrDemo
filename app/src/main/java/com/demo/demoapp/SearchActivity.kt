package com.demo.demoapp


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import android.support.v7.app.AppCompatActivity


class SearchActivity : AppCompatActivity() {

    lateinit var edtSearch: EditText
    lateinit var btnSearch: Button
    private val  searchAction = 23

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        edtSearch = findViewById(R.id.edtSearch)
        btnSearch = findViewById(R.id.btnSearch)
        btnSearch.setOnClickListener {
            val message = edtSearch.text.toString()
            val intent = Intent()
            intent.putExtra("MESSAGE", message)
            setResult(searchAction, intent)
            finish()
        }
    }
}
