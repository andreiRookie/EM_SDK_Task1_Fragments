package com.andreirookie.em_sdk_task1_fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class FragmentC : Fragment(R.layout.fragment_layout) {

    private lateinit var router: Router

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        router = RouterImpl.getInstance(parentFragmentManager)

        view.findViewById<Button>(R.id.go_next_button).apply {
            setOnClickListener {
                Toast.makeText(context, "This is the last fragment", Toast.LENGTH_SHORT).show()
            }
        }

        view.findViewById<Button>(R.id.go_back_button).apply {
            setOnClickListener {
                router.navigate(NavigationType.BackFrom(fragment = this@FragmentC))
            }
        }
    }
}