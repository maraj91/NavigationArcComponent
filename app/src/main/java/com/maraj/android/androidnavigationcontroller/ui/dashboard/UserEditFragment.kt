package com.maraj.android.androidnavigationcontroller.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.maraj.android.androidnavigationcontroller.R

class UserEditFragment : Fragment() {

    lateinit var btnFinish: Button
    lateinit var btnBack: Button
    lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(activity!!,
            R.id.my_nav_host_fragment
        )
        btnFinish = view.findViewById(R.id.button_finish)
        btnFinish.setOnClickListener {
            navController.navigate(R.id.action_userEditFragment_to_homeFragment2)
        }
        btnBack = view.findViewById(R.id.button_back)
        btnBack.setOnClickListener {
            navController.navigateUp()
        }
    }
}