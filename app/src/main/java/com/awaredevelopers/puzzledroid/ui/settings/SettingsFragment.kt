package com.awaredevelopers.puzzledroid.ui.settings

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.awaredevelopers.puzzledroid.MainActivity
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.db.AppDatabase
import com.google.android.material.switchmaterial.SwitchMaterial
import com.shawnlin.numberpicker.NumberPicker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class SettingsFragment : Fragment(), CoroutineScope {

    private lateinit var settingsModel: SettingsModel
    private var job: Job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsModel =
                ViewModelProviders.of(this).get(SettingsModel::class.java)
        val root = inflater.inflate(R.layout.fragment_settings, container, false)
        val textView: TextView = root.findViewById(R.id.settings_text)
        settingsModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        //Setting user name info
        var user = root.findViewById(R.id.settings_user) as EditText;
        user.setText(MainActivity.user.name)
        user.addTextChangedListener { text ->
            MainActivity.user.name = text.toString()
            launch {
                val db = context?.let { AppDatabase.getInstance(it) }
                db?.userDao()?.updateUser(MainActivity.user)
            }
        }

        //Setting background audio
        var backgroundAudio = root.findViewById(R.id.switch_button_audio_background) as SwitchMaterial;
        backgroundAudio.isChecked = MainActivity.user.isEnabledBackgroundAudio == 1
        backgroundAudio.setOnCheckedChangeListener { buttonView, isChecked ->
            MainActivity.user.isEnabledBackgroundAudio = if (isChecked) 1 else 0
            launch {
                val db = context?.let { AppDatabase.getInstance(it) }
                db?.userDao()?.updateUser(MainActivity.user)
            }
        }

        //Setting audio effects
        var audioEffects = root.findViewById(R.id.switch_button_audio_effects) as SwitchMaterial;
        audioEffects.isChecked = MainActivity.user.isEnabledAudioEffects == 1
        audioEffects.setOnCheckedChangeListener { buttonView, isChecked ->
            MainActivity.user.isEnabledAudioEffects = if (isChecked) 1 else 0
            launch {
                val db = context?.let { AppDatabase.getInstance(it) }
                db?.userDao()?.updateUser(MainActivity.user)
            }
        }

        val openFile: Button = root.findViewById(R.id.button_custom_audio_file) as Button
        openFile.setOnClickListener {
//            Toast.makeText(context, "Item 1 pressed", Toast.LENGTH_LONG).show()
                val intent = Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, 1125)
        }

        //Setting level
        val numberPicker = root.findViewById(R.id.number_picker) as NumberPicker
        val typeface = context?.let { ResourcesCompat.getFont(it, R.font.baby_monsta) }
        numberPicker.typeface = typeface
        numberPicker.value = MainActivity.user.level

        numberPicker.setOnScrollListener { picker, scrollState ->
            if (scrollState == NumberPicker.OnScrollListener.SCROLL_STATE_IDLE) {
                MainActivity.user.level = picker.value
                launch {
                    val db = context?.let { AppDatabase.getInstance(it) }
                    db?.userDao()?.updateUser(MainActivity.user)
                }
            }
        }

        return root
    }
}
