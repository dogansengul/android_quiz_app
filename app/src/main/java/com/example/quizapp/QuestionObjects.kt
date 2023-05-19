package com.example.quizapp

object QuestionObjects {

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val q1 = Question(
            1, "What country does this flag belongs to?",
            R.drawable.ic_flag_of_argentina, "Argentina",
            "Australia", "Austria", "Belgium", "Argentina")
        questionList.add(q1)
        val q2 = Question(
            1, "What country does this flag belongs to?",
            R.drawable.ic_flag_of_australia, "Argentina",
            "Australia", "Austria", "Belgium", "Australia")
        questionList.add(q2)
        val q3 = Question(
            1, "What country does this flag belongs to?",
            R.drawable.ic_flag_of_belgium, "Argentina",
            "Australia", "Austria", "Belgium", "Belgium")
        questionList.add(q3)
        val q4 = Question(
            1, "What country does this flag belongs to?",
            R.drawable.ic_flag_of_brazil, "Argentina",
            "Australia", "Brazil", "Belgium", "Brazil")
        questionList.add(q4)
        val q5 = Question(
            1, "What country does this flag belongs to?",
            R.drawable.ic_flag_of_denmark, "Denmark",
            "Australia", "Austria", "Belgium", "Denmark")
        questionList.add(q5)

        return questionList
    }
}