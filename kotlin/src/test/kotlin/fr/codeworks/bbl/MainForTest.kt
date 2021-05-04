package fr.codeworks.bbl

class MainForTest {
     companion object {
        fun play (){
            val codeTest = Interview()
            codeTest.addCat("SQL")
            codeTest.addCan("firstname", "lastname", "email")
            val score = codeTest.run("Java")
            println("The candidate as a total of $score points.")
        }

   }
}
