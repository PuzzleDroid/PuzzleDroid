package com.awaredevelopers.puzzledroid.ui.nPuzzle

// import com.awaredevelopers.puzzledroid.utils.GamesRulesUtil
// import com.awaredevelopers.puzzledroid.utils.ImageNPuzzle
import com.awaredevelopers.puzzledroid.utils.GamesRulesUtil
import com.awaredevelopers.puzzledroid.utils.ImagesUtil

class NPuzzle {
    private var description = ""
    open lateinit var gamesRulesUtil: GamesRulesUtil
    private var idNPuzzle = 0
    // open lateinit var imageNPuzzle:ImageNPuzzle
    private var imagePath = ""
    open lateinit var imagesUtil:ImagesUtil
    private var level = 0


    open fun launchPiecesAnimations() {

    }

    open fun onCompletionAnimation() {

    }

    open fun onCompletionSetScore() {

    }
}