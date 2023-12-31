package com.example.worldcup.data

import com.example.worldcup.data.domain.Match

// Singleton class, so it can be accessed from anywhere (like a global variable)
object DataManager {
    private val matchesList = mutableListOf<Match>()
    private var matchIndex = 0

    fun addMatch(match: Match) {
        matchesList.add(match)
    }

    fun getCurrentMatch(): Match? {
        if (matchIndex in 0 until matchesList.size) {
            return matchesList[matchIndex]
        }
        return null
    }

    fun getNextMatch(): Match? {
        matchIndex++
        if(matchIndex == matchesList.size) matchIndex= 0
        return getCurrentMatch()
    }

    fun getPreviousMatch(): Match? {
        matchIndex--
        if(matchIndex == -1) matchIndex= matchesList.size-1
        return getCurrentMatch()
    }
}
