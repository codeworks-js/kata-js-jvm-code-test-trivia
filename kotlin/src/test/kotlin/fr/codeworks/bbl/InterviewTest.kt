package fr.codeworks.bbl

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.File

@DisplayName("The interview should")
class InterviewTest {
    private val interview = Interview()

    @Test
    @DisplayName("load questions")
    fun loadQuestions() {
        val resource = interview.javaClass.getResource("/categories.json")
        val file = File(resource.path)
        val allCategoriesAsRaw = file.bufferedReader().use { it.readText() }
        val categoryType = object : TypeToken<List<CategorizedQuestions>>() {}.type
        val allCategories: List<CategorizedQuestions> = Gson().fromJson(allCategoriesAsRaw, categoryType)
        println("Total categories: ${allCategories.size}")
        val questions = allCategories
        assertThat(questions).isNotEmpty
    }

    @Test
    fun loadQuestionsByCategories() {
        val resource = interview.javaClass.getResource("/categories.json")
        val file = File(resource.path)
        val allCategoriesAsRaw = file.bufferedReader().use { it.readText() }
        val categoryType = object : TypeToken<List<CategorizedQuestions>>() {}.type
        val allCategories: List<CategorizedQuestions> = Gson().fromJson(allCategoriesAsRaw, categoryType)
        println("Total categories: ${allCategories.size}")
        val category: CategorizedQuestions? = allCategories.find { question -> question.label == "Java" }
        println("Total questions for category: ${category?.questions?.size}")
        val questionForCategory = category?.questions

        assertThat(questionForCategory).isNotEmpty
        assertThat(questionForCategory?.size).isEqualTo(9)
    }

    @Test
    fun askingQuestions(){
        interview.run("Java")
    }

}
