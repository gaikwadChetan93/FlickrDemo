package com.demo.demoapp


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText


class SearchActivity : AppCompatActivity() {

    lateinit var edtSearch: EditText
    lateinit var btnSearch: Button
    private val searchAction = 23

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        edtSearch = findViewById(R.id.edtSearch)
        btnSearch = findViewById(R.id.btnSearch)
        btnSearch.setOnClickListener {
            hideSoftKeyboard(btnSearch)
            val message = edtSearch.text.toString()
            val intent = Intent()
            intent.putExtra("MESSAGE", message)
            setResult(searchAction, intent)
            finish()
        }
    }

    fun hideSoftKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
    }
}
