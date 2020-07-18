package com.awaredevelopers.puzzledroid.ui.nPuzzle

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.db.AppDatabase
import com.awaredevelopers.puzzledroid.db.entity.ScoreEntity
import com.awaredevelopers.puzzledroid.model.NPuzzle
import com.awaredevelopers.puzzledroid.utility.NPuzzlePortion
import com.awaredevelopers.puzzledroid.utility.NPuzzleRules
import kotlinx.android.synthetic.main.activity_npuzzle.*
import kotlinx.coroutines.*
import java.util.*
import kotlin.coroutines.CoroutineContext


/**
 * Custom Adapter. It allows to control what is painted in the GridView as well as its behavior.
 * The main object is the nPuzzleList collection with sliced pieces of the NPuzzle.
 */
class NPuzzleAdapter() : BaseAdapter(), CoroutineScope {
    private lateinit var nPuzzleList:MutableList<NPuzzlePortion>
    private lateinit var list: List<NPuzzlePortion>
    private lateinit var nPuzzle: NPuzzle
    private var isFirstRun = true
    private var isSolved = false
    private var movementsCounter = 0

    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    constructor (nPuzzle: NPuzzle): this(){
        this.nPuzzleList = nPuzzle.nPuzzlePortions as MutableList<NPuzzlePortion>
        this.list = nPuzzle.nPuzzlePortions
        this.nPuzzle = nPuzzle
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
    @SuppressLint("ViewHolder", "InflateParams")
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

        // Set a click listener for card view
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
                    //Toast to popup a debug msg with detailed information.
//                Toast.makeText(
//                    parent.context, "Position= ${getItemId(position)}\n ${list[position].toString()}", Toast.LENGTH_SHORT
//                ).show()

                    Log.d(TAG, "Movement #${++movementsCounter}")

                    //On click swap the content between two pieces if the piece with the "empty space" is in the right position.
                    Collections.swap(
                        list,
                        position,
                        NPuzzleRules.getEmptySpace(position, list, list[position].numCols)
                    )

                    //TODO animaciones no funcionan si hacemos un notifyDataSetChanged()
//                    val anim = AnimationUtils.loadAnimation(
//                        view.context,
//                        R.anim.fade_in
//                    )
//                    anim.startOffset = (position * 500).toLong()
//                    view.animation = anim
//                    anim.start()

                    notifyDataSetChanged()

                    //Incremental check to verify if the NPuzzle was solved.
                    if (NPuzzleRules.isCorrectOrder(list)) {
                        //Fragment dialog --> Tiempo empleado, felicidades amijo, etc... con botones aceptar y a correr al Home...
                        Log.d(TAG, "-------------------------------> Auuuu! You win")
                        val nPuzzleActivity = parent.context as Activity
                        //Stop timmer
                        nPuzzleActivity.chronometer.stop()
                        //Disable gridview
                        isSolved = true

                        //Showing final popup
                        var winPopup = nPuzzleActivity.findViewById<RelativeLayout>(R.id.winPopup)
                        winPopup.visibility = View.VISIBLE
                        val animation: Animation = AnimationUtils.loadAnimation(
                            parent.context,
                            R.anim.fade_in
                        )
                        winPopup.startAnimation(animation);

                        val score = ScoreEntity(
                            nPuzzle.level,
                            nPuzzleActivity.chronometer.getBase().toInt(),
                            ""
                        )

                        // Insert a score
                        suspend fun insertScore(score: ScoreEntity) {
                            val applicationContext = parent.context.getApplicationContext()

                            val db = AppDatabase.getInstance(applicationContext)

                            db.scoreDao().insertScore(score)
                        }

                        launch {
                            insertScore(score)
                        }
                    }
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
}