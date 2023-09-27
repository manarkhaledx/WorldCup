package com.example.worldcup.ui

import android.view.LayoutInflater
import com.example.worldcup.data.DataManager
import com.example.worldcup.data.domain.Match
import com.example.worldcup.databinding.ActivityMainBinding
import com.example.worldcup.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val logTag: String = "MainActivity"
    override val bindingInflater: (layoutInflater: LayoutInflater) -> ActivityMainBinding= ActivityMainBinding::inflate

    override fun setup() {
        parseFile()
    }

    override fun addCallBacks() {
        binding.apply {

            nextIv.setOnClickListener {
               val match= DataManager.getNextMatch()
                bindMatch(match!!)
            }
            previousIv.setOnClickListener {
               val match= DataManager.getPreviousMatch()
                bindMatch(match!!)
        }
        }
    }
    private fun parseFile() {

        try {
            val inputStream = assets.open("WorldCup 1930-2022.csv")
            val buffer = BufferedReader(InputStreamReader(inputStream))
            val parser =CsvParser()
            buffer.forEachLine {
                logV(it)
                val currentMatch = parser.parse(it)
                DataManager.addMatch(currentMatch)
            }
            inputStream.close()
        } catch (e: Exception) {
            logE("Error opening file: $e")
        }
        bindMatch(DataManager.getCurrentMatch()!!)
    }
    private fun bindMatch(match: Match) {
        binding.apply {
            tournamentNameTv.text = match.tournamentName
            matchNameTv.text = match.matchName
            matchDateTv.text = match.matchDate
            matchTimeTv.text = match.matchTime
            stadiumNameTv.text = match.stadiumName
            countryNameTv.text = match.countryName
            homeTeamNameTv.text = match.homeTeamName
            awayTeamNameTv.text = match.awayTeamName
            homeTeamScoreTv.text = match.homeTeamScore.toString()
            awayTeamScoreTv.text = match.awayTeamScore.toString()
            homeTeamScorePenaltiesTv.text = match.homeTeamScorePenalties.toString()
            awayTeamScorePenaltiesTv.text = match.awayTeamScorePenalties.toString()
            resultTv.text = match.result
        }
    }
}




