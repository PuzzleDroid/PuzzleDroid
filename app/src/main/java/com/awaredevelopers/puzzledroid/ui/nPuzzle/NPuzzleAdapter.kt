package com.awaredevelopers.puzzledroid.ui.nPuzzle

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
import com.awaredevelopers.puzzledroid.utils.*
import kotlin.collections.ArrayList

class NPuzzleAdapter() : BaseAdapter(){
    private lateinit var nPuzzleList:MutableList<NPuzzlePortion>
    private lateinit var list: List<Pair<Drawable,String>>
    private var isFirstRun = true

    constructor (nPuzzleList: List<NPuzzlePortion>): this(){
        this.nPuzzleList = nPuzzleList as MutableList<NPuzzlePortion>
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
    override fun getView(position:Int, convertView: View?, parent: ViewGroup?):View{
        // Inflate the custom view
        val inflater = parent?.context?.
        getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_view,null)

        // Get the custom view widgets reference
        val gridPiece = view.findViewById<ImageView>(R.id.gridPiece)
        val cardContainer = view.findViewById<CardView>(R.id.cardContainer)

        // Display drawable on ImageView
        gridPiece.setImageDrawable(list[position].first)

        // Set background color for card view
//        popup.setCardBackgroundColor(list[position].second)

        // Set a click listener for card view
        cardContainer.setOnClickListener{

            if (isFirstRun) {
                nPuzzleList.removeAt(nPuzzleList.lastIndex)
                nPuzzleList = nPuzzleList.shuffled() as MutableList<NPuzzlePortion>
                list = nPuzzlePieces()
                notifyDataSetChanged()
                isFirstRun = false

            } else {
                Toast.makeText(
                    parent.context, "Coord: ${list[position].second}", Toast.LENGTH_SHORT
                ).show()

                // Get the activity reference from parent
                val activity = parent.context as Activity

                // Get the activity root view
                val viewGroup = activity.findViewById<ViewGroup>(android.R.id.content)
                    .getChildAt(0)

                // Change the root layout background color
//               viewGroup.setBackgroundColor(Color.parseColor("#b5d6e1"))
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
            gridList.add(Pair(element.drawable, element.coord.toString()))
        }
        return gridList
    }
}