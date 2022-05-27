package binar.ganda.challengechapter7.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.lifecycle.asLiveData
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import binar.ganda.challengechapter7.R
import binar.ganda.challengechapter7.datastore.UserManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_splash_screen.*
import kotlinx.android.synthetic.main.fragment_splash_screen.view.*

@AndroidEntryPoint
class SplashScreen : Fragment() {

    private lateinit var userManager: UserManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userManager = UserManager(requireContext())

        userManager.userUsername.asLiveData().observe(viewLifecycleOwner){
            if (it != ""){
                Navigation.findNavController(requireView()).navigate(R.id.action_splashScreen_to_homeFragment)
            } else {
                Handler().postDelayed({
                    Navigation.findNavController(requireView()).navigate(R.id.action_splashScreen_to_loginFragment)
                }, 3000)
            }
        }




    }


}

