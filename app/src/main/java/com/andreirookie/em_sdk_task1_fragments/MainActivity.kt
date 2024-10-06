package com.andreirookie.em_sdk_task1_fragments

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    private lateinit var router: Router
    private lateinit var title: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        router = RouterImpl.getInstance(supportFragmentManager)
        router.navigate(NavigationType.Add(FragmentA()), R.id.container)

        title = findViewById(R.id.title)

        supportFragmentManager.addOnBackStackChangedListener {
            val entryCount = supportFragmentManager.backStackEntryCount
            var entry: FragmentManager.BackStackEntry
            (0 until entryCount).forEach {
                entry = supportFragmentManager.getBackStackEntryAt(it)
                title.text = entry.name.toString()
            }
        }
    }
}

val Any.TAG: String get() = this::class.java.simpleName