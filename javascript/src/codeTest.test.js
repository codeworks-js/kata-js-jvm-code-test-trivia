const fs = require('fs')

const technicalWorkshop = require("./technicalWorkshop");

/*console.log = jest.fn(value => fs.appendFile('./test_ressources/goldenMaster.txt', value, (err, file) => {
  if(err) throw err
  console.log('Fichier créé')
}))*/

const runCodeTestSeam = () => {
  console.log('\n----  CodeTest has just started  ----\n')
  technicalWorkshop.addCategory('SQL')
  technicalWorkshop.addCandidate('firstName', 'lastName', 'email')

  technicalWorkshop.loadQuestions()

  technicalWorkshop.run = jest.fn(category => {
    const QUESTIONS = [{
      label: "Can one interface extend another interface ?",
      answer: "Yes",
      difficulty: 1
    },{
      label: "What is a HashMap ?",
      answer: "Set of unordered (key, value), complexity in O(1) for search and insertion.",
      difficulty: 2
    }]
    const RESPONSES = []

    console.log(`Welcome to the interview game. You'll have ${QUESTIONS?.length} questions on ${category}`)
    console.log('Are you ready? Press y and Enter to start. ')

    const readyAnswer = 'y'
    if(readyAnswer === 'y'){
      console.log(`\nLet's go!\n`)
      console.log('***************** Questions *****************\n')
      QUESTIONS?.forEach(question => {
        const currentQuestionAnswer = question.label+' '
        console.log(currentQuestionAnswer)
        RESPONSES.push({question, answer: currentQuestionAnswer})
      })
      console.log('\nThank you for your participation!\n')
      console.log('*************** End of questions ******************\n')
    }
    return RESPONSES
  })
  technicalWorkshop.evaluateCandidate = jest.fn((name, responses) => 0)
  const RESPONSES = technicalWorkshop.run('Java')
  const SCORE = technicalWorkshop.evaluateCandidate('Romy', RESPONSES)
  console.log('\n*******************************************************')
  console.log(`\nThe candidate as a total of ${SCORE} points.`)
  console.log('\n----  CodeTest has stopped  ----\n')
}

function formatToString(linesFromFileData) {
  return `\n${linesFromFileData?.map(line => line.replace('\n', '')).map(line => line.replace('\n', '')).join('\n')}\n`;
}

describe('CodeTest', function(){
  describe('golden master', function(){
    it('returns not ready output', function(){
      const fileData = [];
      console.log = jest.fn(value => fileData.push(value))
      const goldenMasterData = fs.readFileSync('/Users/romyalula/IdeaProjects/CodeWorks_BBLs/kata-js-jvm-code-test-trivia/javascript/test_ressources/goldenMaster.txt', {encoding: "utf-8"})
      console.error(goldenMasterData.toString())

      runCodeTestSeam()
      const fileDataToString = formatToString(fileData)
      console.error(fileDataToString)

      expect(fileDataToString).toStrictEqual(goldenMasterData)
    })
  })
})