package com.pratham.quizzo

object Constants{
    const val USER_NAME:String="username"
    const val TOTAL_QUESTIONS:String="total"
    const val CORRECT_ANS:String="correctans"
    fun getQuestions():ArrayList<Question>{
        val queslist=ArrayList<Question>()
        val que1=Question(1,"what country does this flag belong to?",R.drawable.argentina
        ,"Argentina","Iran","Belgium","Denmark"
        ,1)
        queslist.add(que1)
        val que2=Question(2,"what country does this flag belong to?",R.drawable.canada
            ,"Kuwait","Uzbekistan","Belgium","Canada"
            ,4)
        queslist.add(que2)
        val que3=Question(3,"what country does this flag belong to?",R.drawable.china
            ,"New Zealand","China","Austria","Denmark"
            ,2)
        queslist.add(que3)
        val que4=Question(4,"what country does this flag belong to?",R.drawable.england
            ,"England","Germany","Indonesia","Denmark"
            ,1)
        queslist.add(que4)
        val que5=Question(5,"what country does this flag belong to?",R.drawable.france
            ,"Germany","UAE","Iraq","France"
            ,4)
        queslist.add(que5)
        val que6=Question(6,"what country does this flag belong to?",R.drawable.australia
            ,"Germany","West Indies","Ireland","Australia"
            ,4)
        queslist.add(que6)
        val que7=Question(7,"what country does this flag belong to?",R.drawable.nepal
            ,"Bhutan","Bangkok","Nepal","Afghanistan"
            ,3)
        queslist.add(que7)
        val que8=Question(8,"what country does this flag belong to?",R.drawable.germany
            ,"Germany","Singapore","Denmark","South Africa"
            ,1)
        queslist.add(que8)
        val que9=Question(9,"what country does this flag belong to?",R.drawable.japan
            ,"Bhutan","Japan","Iran","Italy"
            ,2)
        queslist.add(que9)
        val que10=Question(10,"what country does this flag belong to?",R.drawable.usa
            ,"New Zealand","Australia","Indonesia","USA"
            ,4)
        queslist.add(que10)
        return queslist

    }
}
