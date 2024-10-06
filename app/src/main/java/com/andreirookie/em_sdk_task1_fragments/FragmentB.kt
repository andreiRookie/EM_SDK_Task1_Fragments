package com.andreirookie.em_sdk_task1_fragments

import android.os.Bundle
import android.view.View

class FragmentB : BaseFragment() {

    private lateinit var router: Router
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        router = RouterImpl.getInstance(parentFragmentManager)
    }

    override fun setupNextButton() {
        router.navigate(NavigationType.Add(FragmentC()), R.id.container)
    }

    override fun setupBackButton() {
        router.navigate(NavigationType.BackFrom(this@FragmentB))
    }
}