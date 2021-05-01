package fr.codeworks.bbl

fun main(){
    val aTechnicalInterview = Interview()
    aTechnicalInterview.addCategorie("SQL")
    aTechnicalInterview.addCategorie("JS")
    aTechnicalInterview.addCategorie("CSS")
    aTechnicalInterview.loadQuestions()
    val responses = aTechnicalInterview.askQuestions("Java")
     aTechnicalInterview.evaluateCandidate(responses)
   // println("score du candidat: ${score}")
}
