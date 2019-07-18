package com.maraj.android.androidnavigationcontroller.ui.authentication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.maraj.android.androidnavigationcontroller.R
import com.maraj.android.androidnavigationcontroller.ui.dashboard.MainActivity
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    private lateinit var btnLogin: Button
    private lateinit var btnForgot: Button
    private lateinit var btnSignUp: Button
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(
            activity!!,
            R.id.my_nav_host_auth_fragment
        )
        btnLogin = view.findViewById(R.id.mBtnLogin)
        btnLogin.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
            activity!!.finish()
        }
        btnForgot = view.findViewById(R.id.mBtnForgot)
        btnForgot.setOnClickListener {
            val email = mEtEmail.text.toString()
            val action = LoginFragmentDirections.actionLoginFragmentToForgotFragment(email)
            navController.navigate(action)
        }
        btnSignUp = view.findViewById(R.id.mBtnRegister)
        btnSignUp.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }
}