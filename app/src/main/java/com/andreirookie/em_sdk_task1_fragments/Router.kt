package com.andreirookie.em_sdk_task1_fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface Router {
    fun navigate(navType: NavigationType, containerId: Int = 0)
}

class RouterImpl private constructor(private val fm: FragmentManager) : Router {

    override fun navigate(navType: NavigationType, containerId: Int) {
        when (navType) {
            is NavigationType.Add -> {
                fm.beginTransaction()
                    .add(containerId, navType.fragment)
                    .addToBackStack(navType.fragment.TAG)
                    .commit()
            }

            is NavigationType.ReplaceWith -> {
                fm.beginTransaction()
                    .replace(containerId, navType.fragment)
                    .addToBackStack(navType.fragment.TAG)
                    .commit()
            }

            is NavigationType.BackFrom -> {
                if (fm.backStackEntryCount > 1) {
                    fm.popBackStack()
                } else {
                    navType.fragment.requireActivity().onBackPressedDispatcher.onBackPressed()
                }
            }
        }
    }
    companion object {
        private var instance: RouterImpl? = null
        fun getInstance(fm: FragmentManager) = instance ?: RouterImpl(fm).also { instance = it }
    }
}

sealed interface NavigationType {
    data class Add(val fragment: Fragment) : NavigationType
    data class ReplaceWith(val fragment: Fragment) : NavigationType
    data class BackFrom(val fragment: Fragment) : NavigationType
}
