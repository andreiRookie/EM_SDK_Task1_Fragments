package com.andreirookie.em_sdk_task1_fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(R.layout.fragment_layout) {

    abstract fun setupNextButton()
    abstract fun setupBackButton()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.go_next_button).apply {
            setOnClickListener { setupNextButton() }
        }

        view.findViewById<Button>(R.id.go_back_button).apply {
            setOnClickListener { setupBackButton() }
        }
    }
}