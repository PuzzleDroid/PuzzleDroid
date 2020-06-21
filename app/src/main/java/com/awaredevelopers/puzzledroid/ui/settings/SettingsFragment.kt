package com.awaredevelopers.puzzledroid.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.awaredevelopers.puzzledroid.R

class SettingsFragment : Fragment() {

    private lateinit var settingsModel: SettingsModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        settingsModel =
                ViewModelProviders.of(this).get(SettingsModel::class.java)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)
        val textView: TextView = root.findViewById(R.id.text_settings)
        settingsModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
