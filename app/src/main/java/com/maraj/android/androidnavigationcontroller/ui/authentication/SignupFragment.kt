package com.maraj.android.androidnavigationcontroller.ui.authentication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.maraj.android.androidnavigationcontroller.R


class SignupFragment : Fragment() {

    private lateinit var mBtnSignUp: Button
    lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(
            activity!!,
            R.id.my_nav_host_auth_fragment
        )
        mBtnSignUp = view.findViewById(R.id.mBtnSignUp)
        mBtnSignUp.setOnClickListener {
            navController.navigateUp()
        }
    }
}