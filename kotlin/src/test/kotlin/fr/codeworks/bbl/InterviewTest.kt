package fr.codeworks.bbl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("The interview should")
class InterviewTest {
    private val interview = Interview()

    @Test
    @DisplayName("load questions")
    fun loadQuestions() {
        val questions = interview.loadQuestions()
        assertThat(questions).isNotEmpty
    }

    @Test
    fun loadQuestionsByCategories(){
        val questionForCategory = interview.loadQuestionForCategory("Java")

        assertThat(questionForCategory).isNotEmpty
        assertThat(questionForCategory).hasSizeLessThan(30)
    }

    @Test
    fun askingQuestions(){

    }


}
