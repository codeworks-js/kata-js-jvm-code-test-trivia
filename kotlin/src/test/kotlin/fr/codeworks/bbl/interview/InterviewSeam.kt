package fr.codeworks.bbl.interview

import fr.codeworks.bbl.CandidateResponse
import fr.codeworks.bbl.Interview
import fr.codeworks.bbl.Question

class InterviewSeam: Interview() {

    fun play(category: String, firstname: String?): Double {
        val questions = getCategorizedQuestions(category)
        val q: List<Question>? = questions?.questions
        val responses = mutableListOf<CandidateResponse>()
        var score = 0.0 // s is for score
        println("Welcome to the interview game. You'll have ${q?.size} questions on ${category}")
        print("Are you ready? (y) to start? \n")
        val r2 = readLine()
        if (r2 == "y") {
            println("Let's go!")
            print("***************** Questions *****************\n")
            q?.forEach { q ->
                print(q.label)
                val a = readLine()
                if (a != null) {
                    responses.add(CandidateResponse(a, q))
                }
            }
            println("Thank you for your participation!")
        }
        println("***************** Response from: $firstname *****************\n")
        responses.forEach { candidateResponse ->
            val currentQuestion = candidateResponse.question
            println("> Question: ${candidateResponse.question} ? \n")
            println(">>> Response: ${candidateResponse.response}. \n")
            print("----> What is your evaluation: t=true or f=false ?\n")
            val answer = readLine()
            if (answer != null) {
                if (answer.equals("t") || answer.equals("T")) {
                    when (currentQuestion.difficulty) {
                        1 -> score += 0.25
                        2 -> score += 0.5
                        3 -> score += 0.75
                        4 -> score += 1
                    }
                }
            }
        }
        return score
    }


}
