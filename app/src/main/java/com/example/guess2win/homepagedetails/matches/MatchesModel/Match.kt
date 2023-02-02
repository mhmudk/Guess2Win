package com.example.guess2win.homepagedetails.matches.MatchesModel

data class Match(
    val date: String,
    val firstTeam: FirstTeam,
    val id: Int,
    val isEnded: Boolean,
    val isStarted: Boolean,
    val league: League,
    val noOfFirstTeamGoals: Any,
    val noOfSecondTeamGoals: Any,
    val secondTeam: SecondTeam,
    val time: String
)