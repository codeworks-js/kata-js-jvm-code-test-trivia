package fr.codeworks.bbl

fun main() {
    val aTechnicalInterview = Interview()
    aTechnicalInterview.addCategorie("SQL")

    aTechnicalInterview.addACandidate("firstname", "lastname", "email")

    aTechnicalInterview.loadQuestions()
    val responses = aTechnicalInterview.askQuestions("Java")
    val score = aTechnicalInterview.evaluateCandidate("Michelle", responses)
    println("The candidate as a total of $score points.")


}
