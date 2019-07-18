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
import kotlinx.android.synthetic.main.fragment_forgot.*


class ForgotFragment : Fragment() {

    lateinit var btnSubmit: Button
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_forgot, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(
            activity!!,
            R.id.my_nav_host_auth_fragment
        )
        //set data in email EditText
        mETForgotEmail.setText(ForgotFragmentArgs.fromBundle(arguments!!).email)
        btnSubmit = view.findViewById(R.id.mBtnSubmit)
        btnSubmit.setOnClickListener {
            navController.navigateUp()
        }
    }
}