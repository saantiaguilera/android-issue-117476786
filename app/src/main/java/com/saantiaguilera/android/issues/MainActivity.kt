package com.saantiaguilera.android.issues

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val directory = "SHARED_PREFS_DIRECTORY"

    private val registeredObject by lazy {
        SharedPreferences.OnSharedPreferenceChangeListener { _, _ ->
            Toast.makeText(MainActivity@this, "Registered object called by shared preferences", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Register the object. It's kept as a strong ref so it won't get GCed
        getSharedPreferences(directory, Context.MODE_PRIVATE).registerOnSharedPreferenceChangeListener(registeredObject)

        // Find views and add / remove / clear the shared preferences
        findViewById<View>(R.id.add_key).setOnClickListener {
            getSharedPreferences(directory, Context.MODE_PRIVATE).edit().putString("key", "exists").apply()
        }

        findViewById<View>(R.id.remove_key).setOnClickListener {
            getSharedPreferences(directory, Context.MODE_PRIVATE).edit().remove("key").apply()
        }

        findViewById<View>(R.id.clear_keys).setOnClickListener {
            getSharedPreferences(directory, Context.MODE_PRIVATE).edit().clear().apply()
        }
    }
}
