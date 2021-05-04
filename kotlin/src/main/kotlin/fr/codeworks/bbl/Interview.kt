package fr.codeworks.bbl

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

data class Question( val label: String, val answer: String,val difficulty: Int)
data class CategorizedQuestions(val label: String, val questions: List<Question>)
data class CandidateResponse(val response : String, val question: Question)
data class Candidate(var firstname: String, var lastname: String, var email: String) {}

 open class Interview {
    internal var categories = mutableSetOf<String>()
    internal var candidate: Candidate? = null

    fun addCat(l: String) {
        println("Adding $l as categories")
        categories.add(l)
    }
    fun addCan(lastname: String, fistname: String, email: String) {
        println("Adding $fistname as candidate")
        this.candidate = Candidate(lastname, fistname, email)
    }

    fun run(cat: String): Double {
        val list = getCat()
        val c = list.find { q -> q.label == cat }
        val q: List<Question>? = c?.questions
        val r = mutableListOf<CandidateResponse>()
        var s = 0.0 // s is for score
        println("Welcome to the interview game. You'll have ${q?.size} questions on ${cat}")
        print("Are you ready? (y) to start? \n")
        val r2 = readLine()
        if (r2 == "y") {
            println("Let's go!")
            print("***************** Questions *****************\n")
            q?.forEach { q ->
                print(q.label)
                val a = readLine()
                if (a != null) {
                    r.add(CandidateResponse(a, q))
                }
            }
            println("Thank you for your participation!")
        }
        println("***************** Response from: ${this.candidate?.firstname} *****************\n")
        r.forEach { candidateResponse ->
            val currentQuestion = candidateResponse.question
            println("> Question: ${candidateResponse.question} ? \n")
            println(">>> Response: ${candidateResponse.response}. \n")
            print("----> What is your evaluation: t=true or f=false ?\n")
            val answer = readLine()
            if (answer != null) {
                if (answer.equals("t") || answer.equals("T")) {
                    when (currentQuestion.difficulty) {
                        1 -> s += 0.25
                        2 -> s += 0.5
                        3 -> s += 0.75
                        4 -> s += 1
                    }
                }
            }
        }
        return s
    }

    private fun getCat(): List<CategorizedQuestions> {
        val resource = this.javaClass.getResource("/categories.json")
        val file = File(resource.path)
        val allCategoriesAsRaw = file.bufferedReader().use { it.readText() }
        val categoryType = object : TypeToken<List<CategorizedQuestions>>() {}.type
        return Gson().fromJson(allCategoriesAsRaw, categoryType)
    }


}
