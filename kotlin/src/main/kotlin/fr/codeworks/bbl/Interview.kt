package fr.codeworks.bbl

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

data class Question( val label: String, val answer: String,val difficulty: Int)
data class CategorizedQuestions(val label: String, val questions: List<Question>)
data class CandidateResponse(val response : String, val question: Question)
data class Candidate(var firstname: String, var lastname: String, var email: String) {
    fun create(lastname: String, fistname: String, email: String) {
        this.lastname = lastname
        this.firstname = fistname
        this.email = email
    }
}

class Interview {
    internal var categories = mutableSetOf<String>()
    internal var candidate: Candidate? = null

    fun addCategorie(label: String) {
        println("Adding ${label} as categories")
        categories.add(label)
    }

    fun loadQuestions(): List<CategorizedQuestions> {
        val resource = javaClass.getResource("/categories.json")
        val file = File(resource.path)
        val allCategoriesAsRaw = file.bufferedReader().use { it.readText() }
        val categoryType = object : TypeToken<List<CategorizedQuestions>>(){}.type
        val allCategories: List<CategorizedQuestions> = Gson().fromJson(allCategoriesAsRaw, categoryType)
        println("Total categories: ${allCategories.size}")
        return allCategories
    }

    fun loadQuestionForCategory(category: String): List<Question>? {
        val category: CategorizedQuestions? = this.loadQuestions().find { question -> question.label == category }
        println("Total questions for category: ${category?.questions?.size}")
        return category?.questions
    }

    fun askQuestions(category: String): List<CandidateResponse> {
        val questions: List<Question>?  = this.loadQuestionForCategory(category)
        val responses = mutableListOf<CandidateResponse>()
        println("Welcome to the interview game. You'll have ${questions?.size} questions on ${category}")
        print("Are you ready? (y) to start? \n")
        val response = readLine()
        if(response == "y"){
            println("Let's go!")
            print("***************** Questions *****************\n")
            questions?.forEach { question ->
                print(question.label)
                val answer = readLine()
                if(answer != null){
                    responses.add(CandidateResponse(answer, question))
                }
            }
            println("Thank you for your participation!")
            print("*************** End of questions ******************\n")
        }
        return responses
    }

    fun evaluateCandidate(candidateName: String,responses: List<CandidateResponse>): Double{
        println("***************** Response from: $candidateName *****************\n")
        var score = 0.0
        responses.forEach { candidateResponse ->
            val currentQuestion = candidateResponse.question
            println("> Question: ${candidateResponse.question} ? \n")
            println(">>> Response: ${candidateResponse.response}. \n")
            print("----> What is your evaluation: t=true or f=false ?\n")
            val answer = readLine()
            if(answer != null){
                val response: Boolean = answer.equals("t") || answer.equals("T")
                if(response){
                    when(currentQuestion.difficulty){
                        1 -> score+=0.25
                        2 -> score+=0.5
                        3 -> score+=0.75
                        4-> score+=1
                    }
                }
            }
        }
        return score
    }

    fun addACandidate(lastname: String, fistname: String, email: String) {
        this.candidate?.create(lastname, fistname, email)
    }
}
