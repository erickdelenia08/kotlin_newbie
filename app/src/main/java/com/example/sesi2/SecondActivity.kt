package com.example.sesi2

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.sesi2.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity() {

    private lateinit var binding: ActivitySecondBinding
    val tag = "check lifecycle"
    override fun bindLayoutRes(): View {
        binding = ActivitySecondBinding.inflate(layoutInflater)

        val bundle :Bundle ?=intent.extras
        val message = bundle!!.getString("email")
        binding.txtEmail.setText("Wellcome "+message)
        return binding.root
    }

    override fun onStartWork() {
        Log.i(tag, "onCreate second executed")
    }

    override fun onStart() {
        super.onStart()
        Log.i(tag, "onStart second executed")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "onResume second executed")
    }

    override fun onPause() {
        super.onPause()
        Log.i(tag, "onPause second executed")
    }

    override fun onStop() {
        super.onStop()
        Log.i(tag, "onStop second executed")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag, "onDestroy second executed")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(tag, "onRestart second executed")
    }

}