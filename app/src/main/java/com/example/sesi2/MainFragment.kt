package com.example.sesi2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sesi2.databinding.FragmentMainBinding
import com.example.sesi2.extension.gone
import com.example.sesi2.extension.showToast
import com.example.sesi2.extension.visible
import java.util.regex.Pattern

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tieEmail.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                // Validasi alamat email saat kehilangan fokus
                validateEmail(binding.tieEmail.text.toString())
            }
        }

        binding.buttonSubmit.setOnClickListener {
            if(formValidate()){
                requireContext().showToast("Your account has been registered :)")
               val intent=Intent(requireContext(), SecondActivity::class.java)
                requireContext().startActivity(intent.putExtra("email", binding.tieEmail.text.toString()));
            }else{
                requireContext().showToast("Complete this form, then submit")
            }

        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun validateEmail(email: String, ) {
        val email = email.trim()

        if (isValidEmail(email)) {
            binding.tilEmail.error = ""
        } else {
            binding.tilEmail.error = "Invalid Email"
        }
    }
    private fun formValidate(): Boolean{
        if(isValidEmail(binding.tieEmail.text.toString()) && binding.tiePassword.text.toString().isNotEmpty()){
            return true;
        }
        return false;
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        val pattern = Pattern.compile(emailPattern)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
}