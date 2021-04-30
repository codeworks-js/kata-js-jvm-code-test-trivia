package fr.codeworks.bbl

<<<<<<< kata-logic
fun main() {
    val aTechnicalInterview = Interview()
    aTechnicalInterview.addCategorie("SQL")

    aTechnicalInterview.addACandidate("firstname", "lastname", "email")

    aTechnicalInterview.loadQuestions()
    val responses = aTechnicalInterview.askQuestions("Java")
    val score = aTechnicalInterview.evaluateCandidate("Michelle", responses)
    println("The candidate as a total of $score points.")


=======
fun main(){
    val aTechnicalInterview = Interview()
<<<<<<< kata-logic
>>>>>>> reorg repo
=======
    aTechnicalInterview.addCategorie("SQL")
    aTechnicalInterview.addCategorie("JS")
    aTechnicalInterview.addCategorie("CSS")
    aTechnicalInterview.loadQuestions()
    val responses = aTechnicalInterview.askQuestions()
    val score = aTechnicalInterview.getScore(responses)
    println("score du candidat: ${score}")
>>>>>>> add main steps in kotlin
}
