package fr.codeworks.bbl

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

data class Question( val label: String, val answer: String,val difficulty: Int)
data class CategorizedQuestions(val label: String, val questions: List<Question>)
data class CandidateResponse(val response : String, val question: Question)

class Interview {
    internal var categories = mutableSetOf<String>()
    internal var questionsAndCategories = mutableListOf<CategorizedQuestions>()
    internal var answersToQuestions = mutableListOf<CandidateResponse>()

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
        print("Are you ready? (y) to start")
        val response = readLine()
        if(response == "y"){
            println("Let's go! ")
            print("*****************************")
            questions?.forEach { question ->
                print(question.label)
                val answer = readLine()
                if(answer != null){
                    responses.add(CandidateResponse(answer, question))
                }
            }
            println("Thank you for your participation!")
        }
        return responses
    }

    fun evaluateCandidate(response: List<CandidateResponse>){
    }




}
