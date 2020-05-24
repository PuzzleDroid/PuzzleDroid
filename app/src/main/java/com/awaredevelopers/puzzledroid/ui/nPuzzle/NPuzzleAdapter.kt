package com.awaredevelopers.puzzledroid.ui.nPuzzle

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.utils.NPuzzlePortion
import kotlin.collections.ArrayList
import kotlin.random.Random

class NPuzzleAdapter() : BaseAdapter(){
    private lateinit var nPuzzleList:List<NPuzzlePortion>
    private lateinit var list: MutableList<Pair<Drawable,String>>
    private var isFirstRun = true

    constructor (nPuzzleList: List<NPuzzlePortion>): this(){
        this.nPuzzleList = nPuzzleList
        this.list = nPuzzlePieces()

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
    @SuppressLint("InflateParams")
    override fun getView(position:Int, convertView: View?, parent: ViewGroup?):View{
        // Inflate the custom view
        val inflater = parent?.context?.
        getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_view,null)

        // Get the custom view widgets reference
        val grid = view.findViewById<ImageView>(R.id.gridContent)
        val gridElement = view.findViewById<CardView>(R.id.gridElementContent)

        // Display drawable on ImageView
        grid.setImageDrawable(list[position].first)


        // Set background color for card view
//        popup.setCardBackgroundColor(list[position].second)

        // Set a click listener for card view
        gridElement.setOnClickListener{

            if (isFirstRun) {
                isFirstRun = false
//                list.shuffle()


//                val inflater = parent?.context?.
//                getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//                val view = inflater.inflate(R.layout.custom_view,null)







                val nextValues = List(list.size) { Random.nextInt(0, list.size)}
                for(s in nextValues) println("------------------------> $s ")

                val start = 0
                val end = list.size
                grid.setImageDrawable(list[rand(start, end)].first)


                var listOrdenando  = mutableListOf(1,2,3)
                for(s in listOrdenando) println("$s ")

                var listDesordenado = listOrdenando.shuffled()
                for(i in listDesordenado) println("$i ")



            } else {

                // Show selected color in a toast message
                Toast.makeText(
                    parent.context,
                    "Clicked : ${list[position].second}", Toast.LENGTH_SHORT
                ).show()

                // Get the activity reference from parent
                val activity = parent.context as Activity

                // Get the activity root view
                val viewGroup = activity.findViewById<ViewGroup>(android.R.id.content)
                    .getChildAt(0)

                // Change the root layout background color
//            viewGroup.setBackgroundColor(list[position].second)
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

    private fun nPuzzlePieces():MutableList<Pair<Drawable,String>> {

        val gridList: MutableList<Pair<Drawable,String>> = ArrayList<Pair<Drawable,String>>()
        for (element in nPuzzleList){
            println(element.coord.toString())

            gridList.add(Pair(element.drawable, element.coord.toString()))
        }

        return gridList
    }

    fun rand(start: Int, end: Int): Int {
        require(start <= end) { "Illegal Argument" }
        return (start..end).random()
    }
}