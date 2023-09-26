package com.example.worldcup.util

import com.example.worldcup.data.domain.Match

class CsvParser {
    companion object {
        private const val NUM_COLUMNS = 13
    }

    fun parse(line: String): Match {
        val tokens = line.split(",")


        if (tokens.size != NUM_COLUMNS) {

            val filledTokens = tokens + List(NUM_COLUMNS - tokens.size) { "N/A" }
            return createMatch(filledTokens)
        }

        return createMatch(tokens)
    }

    private fun createMatch(tokens: List<String>): Match {
        return Match(
            tournamentName = tokens[Constant.ColumnIndex.TOURNAMENT_NAME],
            matchName = tokens[Constant.ColumnIndex.MATCH_NAME],
            matchDate = tokens[Constant.ColumnIndex.MATCH_DATE],
            matchTime = tokens[Constant.ColumnIndex.MATCH_TIME],
            stadiumName = tokens[Constant.ColumnIndex.STADIUM_NAME],
            countryName = tokens[Constant.ColumnIndex.COUNTRY_NAME],
            homeTeamName = tokens[Constant.ColumnIndex.HOME_TEAM_NAME],
            awayTeamName = tokens[Constant.ColumnIndex.AWAY_TEAM_NAME],
            homeTeamScore = tokens[Constant.ColumnIndex.HOME_TEAM_SCORE].toIntOrNull() ?: 0,
            awayTeamScore = tokens[Constant.ColumnIndex.AWAY_TEAM_SCORE].toIntOrNull() ?: 0,
            homeTeamScorePenalties = tokens[Constant.ColumnIndex.HOME_TEAM_SCORE_PENALTIES].toIntOrNull() ?: 0,
            awayTeamScorePenalties = tokens[Constant.ColumnIndex.AWAY_TEAM_SCORE_PENALTIES].toIntOrNull() ?: 0,
            result = tokens[Constant.ColumnIndex.RESULT]
        )
    }
}
