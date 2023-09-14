package com.ruhlanusubov.ecommerceretrofit.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.manager.Lifecycle
import com.ruhlanusubov.ecommerceretrofit.NUM_TABS
import com.ruhlanusubov.ecommerceretrofit.ui.validation.LoginFragment
import com.ruhlanusubov.ecommerceretrofit.ui.validation.RegisterFragment

class ViewPageradapter(fragmentManager: FragmentManager,lifecycle: androidx.lifecycle.Lifecycle)
    :FragmentStateAdapter(fragmentManager,lifecycle){
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->return LoginFragment()
            1->return RegisterFragment()

        }
        return LoginFragment()
    }


}