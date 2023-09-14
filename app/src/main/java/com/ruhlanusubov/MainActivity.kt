package com.ruhlanusubov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.ruhlanusubov.ecommerceretrofit.R
import com.ruhlanusubov.ecommerceretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)


        navController.addOnDestinationChangedListener { _, destination, _ ->

            when(destination.id){
                    R.id.introFragment,
                    R.id.tabFragment,
                    R.id.startFragment ,
                    R.id.detailsFragment->{
                        binding.bottomNavigationView.visibility= View.GONE
                    }else->{
                        binding.bottomNavigationView.visibility=View.VISIBLE
                    }
            }

        }
    }
}