package com.awaredevelopers.puzzledroid.utility

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Build
import android.view.Window
import androidx.appcompat.app.AppCompatDelegate
import com.awaredevelopers.puzzledroid.R

object AudioFactory {

    enum class AudioEffect{
        MOVE_LEFT,
        MOVE_RIGHT,
        MOVE_TOP,
        MOVE_BOTTOM,
        GAME_END
    }

    private var backgroundTheme = MediaPlayer()
    private var audioEffects: SoundPool? = null
    private var isEnabledBackgroundAudio: Boolean = true
    private var isEnabledAudioEffects: Boolean = true

    fun createAudio(context: Context, delegate: AppCompatDelegate, window: Window) {
        try {
            //Creating a background theme using a MediaPlayer
            if(isEnabledBackgroundAudio) {
                delegate.setContentView(R.layout.activity_npuzzle)
                window.volumeControlStream = AudioManager.STREAM_MUSIC;
                this.backgroundTheme = MediaPlayer.create(context, R.raw.test)
                backgroundTheme.isLooping = true
                backgroundTheme.start()
            }
            //Creating a collection of audioeffects using a SoundPool
            if (isEnabledAudioEffects) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    var audioAttributes = AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .build()
                    audioEffects = SoundPool.Builder()
                        .setMaxStreams(6)
                        .setAudioAttributes(audioAttributes)
                        .build();
                } else {
                    audioEffects = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
                }
                audioEffects?.load(context, R.raw.se_left, 1);
                audioEffects?.load(context, R.raw.se_rigth, 1);
                audioEffects?.load(context, R.raw.se_success, 1);
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun stopAudio(){
        try {
            backgroundTheme.reset()
            backgroundTheme.prepare()
            backgroundTheme.stop()
            backgroundTheme.release()
            audioEffects?.autoPause()
            audioEffects?.release()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun pauseAudio(){
        try {
            backgroundTheme.pause()
            audioEffects?.autoPause()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun resumeAudio(){
        try {
            backgroundTheme.start()
            audioEffects?.autoResume()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun playAudioEffect(audioEffect: AudioEffect){
        try {
            when (audioEffect) {
                AudioEffect.MOVE_RIGHT, AudioEffect.MOVE_TOP -> audioEffects?.play(1,1F, 1F, 0, 0, 1F)
                AudioEffect.MOVE_LEFT, AudioEffect.MOVE_BOTTOM -> audioEffects?.play(2,1F, 1F, 0, 0, 1F)
                AudioEffect.GAME_END -> audioEffects?.play(3,1F, 1F, 1, 0, 1F)
            }
//            audioEffects?.autoPause();
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}