const promptSync =require( 'prompt-sync')
const prompt = promptSync({})

const Q = require( './questions.json')

const CANDIDATE = {
  create: (firstName, lastName, email) => {
    this.firstName = firstName
    this.lastName = lastName
    this.email = email
  }
}

const CATEGORIES = []

const TECHNICAL_WORKSHOP = {
  candidate: CANDIDATE,
  categories: CATEGORIES,
  addCategory: (label) => {
    console.log(`Adding ${label} in categories\n`)
    this?.categories?.push(label)
  },
  addCandidate: (firstName, lastName, email) => {
    this?.candidate?.create(firstName, lastName, email)
  },
  loadQuestions: () => {
    const TOTAL_NUMBER_CATEGORIES = [...Q].map(category => category.label).length
    console.log(`Total categories: ${TOTAL_NUMBER_CATEGORIES}`)
    return [...Q]
  },
  loadQuestionsByCategory(category) {
    const CATEGORY = this?.loadQuestions().find(question => question.label === category)
    console.log(`Total questions for ${category} category: ${CATEGORY?.questions?.length}`)
    return CATEGORY?.questions
  },
  run(category) {
    const QUESTIONS = this?.loadQuestionsByCategory(category)
    const RESPONSES = []

    console.log(`Welcome to the interview game. You'll have ${QUESTIONS?.length} questions on ${category}`)

    const readyAnswer = prompt('Are you ready? Press y and Enter to start. ', '',{echo: ''});
    if(readyAnswer === 'y'){
      console.log(`\nLet's go!\n`)
      console.log('***************** Questions *****************\n')
      QUESTIONS?.forEach(question => {
        const currentQuestionAnswer = prompt(question.label+' ', '', {})
        RESPONSES.push({question, answer: currentQuestionAnswer})
      })
      console.log('\nThank you for your participation!\n')
      console.log('*************** End of questions ******************\n')
    }
    return RESPONSES
  },
  evaluateCandidate(candidateName, responses) {
    console.log(`\n***************** Response from: ${candidateName} *****************\n`)
    let score = 0.0
    responses?.forEach(candidateResponse => {
      const CURRENT_QUESTION = candidateResponse?.question
      console.log(`> Question: ${candidateResponse.question.label} \n>>> Response: ${candidateResponse.answer}. \n`)
      const ANSWER = prompt('----> What is your evaluation: t=true or f=false ' + score +' ? ', '', {})
      if(ANSWER === 't' || ANSWER === 'T'){
        switch(CURRENT_QUESTION?.difficulty){
          case 1:
            score += 0.25
            break
          case 2:
            score += 0.5
            break
          case 3:
            score += 0.75
            break
          case 4:
            score += 1
            break
        }
      }
    })
    return score;
  }
}

module.exports = TECHNICAL_WORKSHOP