package com.awaredevelopers.puzzledroid.utility

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.net.Uri
import android.os.Build
import android.view.Window
import com.awaredevelopers.puzzledroid.MainActivity
import com.awaredevelopers.puzzledroid.R

object AudioFactory {

    enum class AudioEffect{
        MOVE_LEFT,
        MOVE_RIGHT,
        MOVE_TOP,
        MOVE_BOTTOM,
        GAME_END
    }

    var customTheme: Uri? = null
    private lateinit var backgroundTheme: MediaPlayer
    private lateinit var audioEffects: SoundPool

    private fun isEnabledBackgroundAudio():Boolean {
        return MainActivity.user.isEnabledBackgroundAudio == 1
    }

    private fun isEnabledAudioEffects():Boolean {
        return MainActivity.user.isEnabledAudioEffects == 1
    }

    fun createAudio(context: Context, window: Window) {
        try {
            //Creating a background theme using a MediaPlayer
            window.volumeControlStream = AudioManager.STREAM_MUSIC;
            if (customTheme == null){
                backgroundTheme = MediaPlayer.create(context, R.raw.background_theme)
            } else {
                backgroundTheme = MediaPlayer.create(context, customTheme)
            }
            backgroundTheme.isLooping = true
            if (isEnabledBackgroundAudio()) backgroundTheme.start()

            //Creating a collection of audioeffects using a SoundPool
            audioEffects =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    var audioAttributes = AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .build()
                    SoundPool.Builder()
                        .setMaxStreams(6)
                        .setAudioAttributes(audioAttributes)
                        .build();
                } else {
                    SoundPool(6, AudioManager.STREAM_MUSIC, 0)
                }
            audioEffects.load(context, R.raw.se_left, 1);
            audioEffects.load(context, R.raw.se_rigth, 1);
            audioEffects.load(context, R.raw.se_cheers, 1);
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun stopAudio(){
        try {
            if(isEnabledBackgroundAudio()) {
                backgroundTheme.reset()
                backgroundTheme.prepare()
                backgroundTheme.stop()
                backgroundTheme.release()
            }
            if (isEnabledAudioEffects()) {
                audioEffects.autoPause()
                audioEffects.release()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun pauseAudio(){
        try {
            if(isEnabledBackgroundAudio()) {
                backgroundTheme.pause()
            }
            if (isEnabledAudioEffects()) {
                audioEffects.autoPause()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun resumeAudio(){
        try {
            if(isEnabledBackgroundAudio()) {
                backgroundTheme.start()
            }
            if (isEnabledAudioEffects()) {
                audioEffects.autoResume()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun playAudioEffect(audioEffect: AudioEffect){
        try {
            if (isEnabledAudioEffects()) {
                when (audioEffect) {
                    AudioEffect.MOVE_RIGHT, AudioEffect.MOVE_TOP -> audioEffects.play(
                        1,
                        1F,
                        1F,
                        0,
                        0,
                        1F
                    )
                    AudioEffect.MOVE_LEFT, AudioEffect.MOVE_BOTTOM -> audioEffects.play(
                        2,
                        1F,
                        1F,
                        0,
                        0,
                        1F
                    )
                    AudioEffect.GAME_END -> audioEffects.play(3, 1F, 1F, 1, 0, 1F)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}