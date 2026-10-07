package com.bignerdranch.android.json_ind_v9_pr_31_trifonov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class Login_fragment : Fragment(R.layout.activity_login_fragment) {
    lateinit var logUser:EditText
    lateinit var passUser:EditText
    lateinit var btnLogin:Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logUser=view.findViewById(R.id.logUser)
        passUser=view.findViewById(R.id.passUser)
        btnLogin=view.findViewById(R.id.btnLogin)
    }
}