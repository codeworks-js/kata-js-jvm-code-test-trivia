package fr.codeworks.bbl

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.*

@DisplayName("The interview should")
internal class InterviewTest{
    lateinit var out: PrintStream
    val filePath = "src/test/resources/interviews"

    @BeforeEach
    fun setup(){
        out = System.out
        System.setOut(PrintStream(FileOutputStream("$filePath/lead.txt")))
    }

    @AfterEach
    fun destroy(){
        System.setOut(out)
    }

    @Test
    @DisplayName("display response null for nb questions and for candidate")
    fun mockReadline(){
        val lead = BufferedReader(FileReader("$filePath/lead.txt"))
        val gold = BufferedReader(FileReader("$filePath/gold.txt"))

        Interview().run("xxxx")

        var line: String?
        while (gold.readLine().also { line = it } != null) {
            Assertions.assertThat(line).isEqualTo(lead.readLine())
        }
    }

}
