package com.example.worldcup.data.domain

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

//pojo class
data class Match (
    val tournamentName: String,
    val matchName: String,
    val matchDate: String = SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH).format(Date()),
    val matchTime: String,
    val stadiumName: String,
    val countryName: String,
    val homeTeamName: String,
    val awayTeamName: String,
    val homeTeamScore: Int,
    val awayTeamScore: Int,
    val homeTeamScorePenalties: Int,
    val awayTeamScorePenalties: Int,
    val result: String,

)
