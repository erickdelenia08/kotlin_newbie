package com.example.sesi2

import android.util.Log
import android.view.View
import com.example.sesi2.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    val tag = "check lifecycle"

    override fun bindLayoutRes(): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStartWork() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_main, MainFragment())
        }.commit()
        Log.i(tag, "onCreate main executed")
    }

    override fun onStart() {
        super.onStart()
        Log.i(tag, "onStart main executed")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "onResume main executed")
    }

    override fun onPause() {
        super.onPause()
        Log.i(tag, "onPause main executed")
    }

    override fun onStop() {
        super.onStop()
        Log.i(tag, "onStop main executed")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag, "onDestroy main executed")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(tag, "onRestart main executed")
    }

}