package com.example.chapter15
import java.io.File
import java.lang.Exception
/* Spell-Checker. The program should read in a text file, parse each word, see if it is in the hashmap,
and, if not, output the line number and word of the potentially misspelled word. Discard any
punctuation in the original text file.*/

var lines: List<String>? = null

fun main(){
    readText()
    var ourDataBaseMap = HashMap<Int, String>()
    ourDataBaseMap[1] = "January"
    ourDataBaseMap[2] = "February"
    ourDataBaseMap[3] = "March"
    ourDataBaseMap[4] = "April"
    ourDataBaseMap[5] = "May"
    ourDataBaseMap[6] = "June"



    println("These months were spelt correctly: ")
    for (i in 0..lines!!.size){
            if (ourDataBaseMap.containsValue(lines!![i])){
                println(lines!![i])
            }else{
                println("Misspelled word(s): ${lines!![i]}")

            }
        }
    }


fun readText() {
    try {
        val words = "words.txt"
        lines = File(words).readLines()
      //  println(lines)
    }catch (e: Exception){
        e.printStackTrace()
    }
}