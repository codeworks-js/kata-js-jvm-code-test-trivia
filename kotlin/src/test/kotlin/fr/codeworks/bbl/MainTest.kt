package fr.codeworks.bbl

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.*


@DisplayName("The interview should")
class MainTest {
    lateinit var out: PrintStream
    val filePath = "src/test/resources"

    @BeforeEach
    fun setup(){
        out = System.out
       System.setOut(PrintStream(FileOutputStream("$filePath/lead.txt")))
    }

    @AfterEach
    fun destroy(){
        System.setOut(out)
        File("$filePath/lead.txt").delete()
    }

  @Test
  @DisplayName("matches gold with default values")
  fun testOfMain(){
      val lead = BufferedReader(FileReader("$filePath/lead.txt"))
      val gold = BufferedReader(FileReader("$filePath/gold.txt"))

      MainForTest.play()

      var line: String?
      while (gold.readLine().also { line = it } != null) {
          Assertions.assertThat(line).isEqualTo(lead.readLine())
      }
  }
}
