package fr.codeworks.bbl

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

data class Question( val label: String, val answer: String,val difficulty: Int)
data class CategorizedQuestions(val label: String, val questions: List<Question>)
data class CandidateResponse(val response : String)

class Interview {
    internal var categories = mutableSetOf<String>()
    internal var questionsAndCategories = mutableListOf<CategorizedQuestions>()

    fun addCategorie(label: String) {
        categories.add(label)
        println("there are ${categories.size} players")
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

    fun loadQuestionForCategory(category: String): List<CategorizedQuestions> {
        val allQuestions = this.loadQuestions().filter { question -> question.label == category }
        println("Total questions for category: ${allQuestions.size}")
        return allQuestions
    }

    fun askQuestions(category: String): List<CandidateResponse> {
        this.loadQuestions()
        val questions =  this.questionsAndCategories.filter { q -> q.label == category }
        println(":::Question by category size = ${questions.size}:::")
        val responses: List<CandidateResponse> = ArrayList()
        return ArrayList()
    }

    fun getScore(respons: List<CandidateResponse>): Int{
        TODO("Not yet implemented")
    }




}
