package com.example.sesi2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindLayoutRes())
        onStartWork()
    }

    abstract fun bindLayoutRes(): View

    abstract fun onStartWork()

}