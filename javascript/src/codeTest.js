const technicalWorkshop = require('./technicalWorkshop.js')

function runCodeTest(){
    console.log('\n----  CodeTest has just started  ----\n')
    technicalWorkshop.addCategory('SQL')
    technicalWorkshop.addCandidate('firstName', 'lastName', 'email')

    technicalWorkshop.loadQuestions()

    const RESPONSES = technicalWorkshop.run('Java')
    const SCORE = technicalWorkshop.evaluateCandidate('Romy', RESPONSES)
    console.log('\n*******************************************************')
    console.log(`\nThe candidate as a total of ${SCORE} points.`)
    console.log('\n----  CodeTest has stopped  ----\n')
}

module.exports = runCodeTest
