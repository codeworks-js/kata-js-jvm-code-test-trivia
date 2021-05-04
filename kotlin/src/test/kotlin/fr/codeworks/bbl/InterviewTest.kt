package fr.codeworks.bbl

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("The interview should")
class InterviewTest {

    @Test
    @DisplayName("should return 0.0 when the run with *hdhdhd*")
    fun goldenMaster(){
        val interview = Interview()
        val result = interview.run("hdhdhd")

        Assertions.assertThat(result).isEqualTo(0.0)
    }

    @Test
    @DisplayName("should return java when the run with *Java*")
    fun goldenMasterWithJava(){
        val interview = Interview()
        val result = interview.run("Java")

        Assertions.assertThat(result).isEqualTo(0.0)
    }

}
