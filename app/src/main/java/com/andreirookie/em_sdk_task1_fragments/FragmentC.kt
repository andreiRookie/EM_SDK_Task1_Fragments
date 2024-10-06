package com.andreirookie.em_sdk_task1_fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast

class FragmentC : BaseFragment() {

    private lateinit var router: Router

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        router = RouterImpl.getInstance(parentFragmentManager)
    }

    override fun setupNextButton() {
        Toast.makeText(context, "This is the last fragment", Toast.LENGTH_SHORT).show()
    }

    override fun setupBackButton() {
        router.navigate(NavigationType.BackFrom(fragment = this@FragmentC))
    }
}