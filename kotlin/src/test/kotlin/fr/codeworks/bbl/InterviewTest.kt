package fr.codeworks.bbl

import fr.codeworks.bbl.interview.InterviewSeam
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.*

import java.io.*

@DisplayName("The interview should")
internal class InterviewTest{
    lateinit var out: PrintStream
    val filePath = "src/test/resources/interviews"

    @BeforeEach
    fun setup(){
        out = System.out
    }

    @AfterEach
    fun destroy(){
        System.setOut(out)
    }

    @Test
    @DisplayName("display response null for nb questions and for candidate")
    fun mockReadline(){
        System.setOut(PrintStream(FileOutputStream("$filePath/lead.txt")))
        val lead = BufferedReader(FileReader("$filePath/lead.txt"))
        val gold = BufferedReader(FileReader("$filePath/gold.txt"))

        val interviewSeam = InterviewSeam()
        interviewSeam.play("xxxx", interviewSeam.candidate?.firstname)

        var line: String?
        while (gold.readLine().also { line = it } != null) {
            Assertions.assertThat(line).isEqualTo(lead.readLine())
        }
    }

    @Test
    @DisplayName("display response 8 questions for Java category")
    fun testingJavaCategory(){
        System.setOut(PrintStream(FileOutputStream("$filePath/java_categ/lead.txt")))

        val lead = BufferedReader(FileReader("$filePath/java_categ/lead.txt"))
        val gold = BufferedReader(FileReader("$filePath/java_categ/gold.txt"))

        val interviewSeam = InterviewSeam()
        interviewSeam.play("Java", interviewSeam.candidate?.firstname)

       var line: String?
        while (gold.readLine().also { line = it } != null) {
            Assertions.assertThat(line).isEqualTo(lead.readLine())
        }
    }

    @Test
    @DisplayName("display response the candidate firstname along with the category")
    fun testingJavaCategoryWithCandidate(){
        System.setOut(PrintStream(FileOutputStream("$filePath/java_categ/lead_for_candidate.txt")))

        val lead = BufferedReader(FileReader("$filePath/java_categ/lead_for_candidate.txt"))
        val gold = BufferedReader(FileReader("$filePath/java_categ/gold_with_candidate.txt"))

        val interviewSeam = InterviewSeam()
        interviewSeam.play("Java", "Michelle")

       var line: String?
        while (gold.readLine().also { line = it } != null) {
            Assertions.assertThat(line).isEqualTo(lead.readLine())
        }
    }

    @Test
    @DisplayName("display the score")
    @Disabled
    fun testingTheScore(){
        val interviewSeam = InterviewSeam()
        //interviewSeam.getScore()

    }

}
