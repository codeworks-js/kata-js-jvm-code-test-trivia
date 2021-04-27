const CODE_WORKERS = [
    {
        firstName: 'Michelle',
        mail: 'm[@]codeworks'
    },
    {
        firstName: 'Romy',
        mail: 'r[@]codeworks'
    },
    {
        firstName: 'Nourdine',
        mail: 'n[@]codeworks'
    },
    {
        firstName: 'Océane',
        mail: 'o[@]codeworks'
    },
]

const CODE_TEST = {
    categories: new Set([
        {
            label: 'HTML',
            questions: [
                {
                    label: '?',
                    answer: '',
                    difficulty: 1
                }
            ]
        },
        {
            label: 'CSS',
            questions: [
                {
                    label: '?',
                    answer: '',
                    difficulty: 1
                }
            ]
        },
        {
            label: 'Javascript',
            questions: [
                {
                    label: '?',
                    answer: '',
                    difficulty: 1
                }
            ]
        },
        {
            label: 'React',
            questions: [
                {
                    label: '?',
                    answer: '',
                    difficulty: 1
                }
            ]
        },
        {
            label: 'Java',
            questions: [
                {
                    label: '?',
                    answer: '',
                    difficulty: 1
                }
            ]
        },
        {
            label: 'SQL',
            questions: [
                {
                    label: '?',
                    answer: '',
                    difficulty: 1
                }
            ]
        },
    ]),
}

function runCodeTest(){
    const EVALUATION = {
        start: null,
        askQuestion: (questions) => {},
        checkCandidateAnswer: (question) => {},
        updateResult: (score) => {},
        candidate: {
            firstName: "",
            lastName: ""
        },
        sendResultMail: ({ candidateMail, codeWorkers}) => {}
    }
    const CANDIDATE = null
    const CATEGORIES = new Array(3)

    console.log('----  CodeTest has just started  ----')

    // Le candidat choisit ses categories
    // L'evaluation est mise a jour : categories, start
    // Le resultat est affiche
    // L'evaluation est mise a jour : identite du candidat, destinataire(s)
    // Le resultat est envoye par mail

    console.log('---  ----  ----  ---  ----  ----  ---')
}

export default runCodeTest
