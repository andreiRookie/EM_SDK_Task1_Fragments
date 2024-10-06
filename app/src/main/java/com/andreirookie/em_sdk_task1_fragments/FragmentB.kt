package com.andreirookie.em_sdk_task1_fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentB : Fragment(R.layout.fragment_layout) {

    private lateinit var router: Router

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        router = RouterImpl.getInstance(parentFragmentManager)

        view.findViewById<Button>(R.id.go_next_button).apply {
            setOnClickListener {
                router.navigate(NavigationType.Add(FragmentC()), R.id.container)
            }
        }

        view.findViewById<Button>(R.id.go_back_button).apply {
            setOnClickListener {
                router.navigate(NavigationType.BackFrom(this@FragmentB))
            }
        }
    }
}