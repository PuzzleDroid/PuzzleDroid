package com.awaredevelopers.puzzledroid.ui.nPuzzle

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.SystemClock
import android.util.Log
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.lifecycle.LiveData
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.db.AppDatabase
import com.awaredevelopers.puzzledroid.db.entity.ScoreEntity
import com.awaredevelopers.puzzledroid.MainActivity
import com.awaredevelopers.puzzledroid.model.NPuzzle
import com.awaredevelopers.puzzledroid.utility.AudioFactory
import com.awaredevelopers.puzzledroid.utility.AudioFactory.AudioEffect
import com.awaredevelopers.puzzledroid.utility.NPuzzlePortion
import com.awaredevelopers.puzzledroid.utility.NPuzzleRules
import com.awaredevelopers.puzzledroid.utility.NPuzzleRules.getEmptySpace
import kotlinx.android.synthetic.main.activity_npuzzle.*
import kotlinx.coroutines.*
import java.util.*
import kotlin.coroutines.CoroutineContext


/**
 * Custom Adapter. It allows to control what is painted in the GridView as well as its behavior.
 * The main object is the nPuzzleList collection with sliced pieces of the NPuzzle.
 */
class NPuzzleAdapter() : BaseAdapter(), CoroutineScope {
    private lateinit var nPuzzleList: MutableList<NPuzzlePortion>
    private lateinit var list: List<NPuzzlePortion>
    private lateinit var nPuzzle: NPuzzle
    private var isFirstRun = true
    private var movementsCounter = 0
    private lateinit var context: Context
    private var isSolved = false

    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    constructor (nPuzzle: NPuzzle, context: Context) : this() {
        this.nPuzzleList = nPuzzle.nPuzzlePortions as MutableList<NPuzzlePortion>
        this.list = nPuzzle.nPuzzlePortions
        this.nPuzzle = nPuzzle
        this.context = context
    }

    companion object{
        private const val TAG = "NPuzzleAdapter"
    }
    /*
        **** reference source developer.android.com ***

        View getView (int position, View convertView, ViewGroup parent)
            Get a View that displays the data at the specified position in the data set. You can
            either create a View manually or inflate it from an XML layout file. When the View
            is inflated, the parent View (GridView, ListView...) will apply default layout
            parameters unless you use inflate(int, android.view.ViewGroup, boolean)
            to specify a root view and to prevent attachment to the root.
    */
    @SuppressLint("ViewHolder", "InflateParams", "ClickableViewAccessibility")
    override fun getView(position:Int, convertView: View?, parent: ViewGroup?):View{
        // Inflate the custom view
        val inflater = parent?.context?.
        getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_view,null)

        // Get the custom view widgets reference
        val gridPiece = view.findViewById<ImageView>(R.id.gridPiece)
        val cardContainer = view.findViewById<CardView>(R.id.cardContainer)

        // Display drawable on ImageView
        gridPiece.setImageDrawable(list[position].drawable)
        cardContainer.setOnClickListener{
            if (!isSolved) {
                if (isFirstRun) {
                    //On first click we replace the last piece with a blank one, shuffle and repaint.
                    nPuzzleList.removeAt(nPuzzleList.lastIndex)
                    nPuzzleList.add(NPuzzlePortion())
                    list = nPuzzleList.shuffled() as MutableList<NPuzzlePortion>
                    notifyDataSetChanged()
                    isFirstRun = false
                } else {
                    val pieceHeight = nPuzzleList[0].eHeight + nPuzzleList[0].drawable.intrinsicHeight
                    val animDuration = 100L
                    var isMovement = true
                    var newPosition = getEmptySpace(position, list)
                    when(newPosition) {
                        position + 1 -> {
                            view.animate().translationX(pieceHeight).duration = animDuration
                            AudioFactory.playAudioEffect(AudioEffect.MOVE_LEFT)                        }
                        position - 1 -> {
                            view.animate().translationX(-pieceHeight).duration = animDuration
                            AudioFactory.playAudioEffect(AudioEffect.MOVE_RIGHT)
                        }
                        position + list[position].numCols -> {
                            view.animate().translationY(pieceHeight).duration = animDuration
                            AudioFactory.playAudioEffect(AudioEffect.MOVE_TOP)
                        }
                        position - list[position].numCols -> {
                            view.animate().translationY(-pieceHeight).duration = animDuration
                            AudioFactory.playAudioEffect(AudioEffect.MOVE_BOTTOM)
                        }
                        else -> isMovement = false
                    }
                     if(isMovement) Log.d(TAG, "Movement #${++movementsCounter}")

                    Handler().postDelayed({
                        notifyDataSetChanged()
                        //On click swap the content between two pieces if the piece with the "empty space" is in the right position.
                        Collections.swap(
                            list,
                            position,
                            newPosition
                        )
                        //Incremental check to verify if the NPuzzle was solved.
                        if (NPuzzleRules.isCorrectOrder(list)) {
                            Log.d(TAG, "-------------------------------> NPuzzle solved! Auuuu!! You win")
                            //Stop timmer
                            val nPuzzleActivity = parent.context as Activity
                            nPuzzleActivity.chronometer.stop()
                            //Disable gridview
                            isSolved = true
                            //Audio effect success!
                            AudioFactory.playAudioEffect(AudioEffect.GAME_END)
                            //Showing final popup
                            var winPopup = nPuzzleActivity.findViewById<RelativeLayout>(R.id.winPopup)
                            winPopup.visibility = View.VISIBLE
                            val animationPopup: Animation = AnimationUtils.loadAnimation(
                                parent.context,
                                R.anim.fade_in
                            )
                            winPopup.startAnimation(animationPopup)
                            //Animating chronometer
                            var chrono = nPuzzleActivity.findViewById<Chronometer>(R.id.chronometer)
                            val animationChrono: Animation = AnimationUtils.loadAnimation(
                                parent.context,
                                R.anim.sequential
                            )
                            chrono.startAnimation(animationChrono)
                            var textSuccess = nPuzzleActivity.findViewById<TextView>(R.id.textSucces)
                            typingAnimation(textSuccess, "Felicidades " + MainActivity.user.name + "\n tu tiempo ha sido de :", 1)

                            MainActivity.user.level = nPuzzle.level + 1
                            var excludedImagesMutable = MainActivity.user.excludedImages.toMutableList()
                            excludedImagesMutable.add(nPuzzle.imgName)
                            MainActivity.user.excludedImages = excludedImagesMutable

                            //Save score
                            val score = ScoreEntity(
                                nPuzzle.level,
                                (SystemClock.elapsedRealtime() - nPuzzleActivity.chronometer.base).toInt(),
                                MainActivity.user.name,
                                nPuzzle.imgName
                            )
                            launch {
                                val db = AppDatabase.getInstance(context)
                                db.userDao().updateUser(MainActivity.user)//
                                db.scoreDao().insertScore(score)
                            }
                        }
                    }, animDuration)
                }
            }
        }
        // Finally, return the view
        return view

    }
    /*
        **** reference source developer.android.com ***

        Object getItem (int position)
            Get the data item associated with the specified position in the data set.

        Parameters
            position int : Position of the item whose data we want within the adapter's data set.
        Returns
            Object : The data at the specified position.
    */
    override fun getItem(position: Int): Any? {
        return list[position]
    }
    /*
        **** reference source developer.android.com ***

        long getItemId (int position)
            Get the row id associated with the specified position in the list.

        Parameters
            position int : The position of the item within the adapter's data
                           set whose row id we want.
        Returns
            long : The id of the item at the specified position.
    */
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // Count the items
    override fun getCount(): Int {
        return list.size
    }

    private fun typingAnimation(view: TextView, text: String, length: Int) {
        var delay = 50L
        if(Character.isWhitespace(text.elementAt(length-1))){
            delay = 100L
        }
        view.text = text.substring(0,length)
        when (length) {
            text.length -> return
            else -> Handler().postDelayed({
                typingAnimation(view, text, length+1 )
            }, delay)
        }
    }
}