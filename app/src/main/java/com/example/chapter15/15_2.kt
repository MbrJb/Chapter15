package com.example.chapter15

import java.util.*

/*
2. A record contains data as well as reference to the next record. We should be
able to insert or remove data within the data records. Create a class named as
WordLinkedList that uses the LinkedList class discussed in this chapter to contain
lists of words. Create a menu-driven program that allows a user to choose from the
following list of operations:
		 1. Insert word in the beginning
		 2. Insert word at a given position
		 3. Delete word from the beginning
		 4. Delete word from a given position
		 5. Display complete list
		 6. Search a specific word
		7. Exit
 */
fun main() {
    val read = Scanner(System.`in`)
    val wordLinkedList = LinkedList<String>()
    wordLinkedList.addAll(listOf("Mercury", "Venus", "Earth", "Pluto"))
    println("Current LinkedList: $wordLinkedList\nWhat word would you like to insert in the beginning?")
    var input = read.nextLine()
    wordLinkedList.addFirst(input)
    println("New list after you added the first word: $wordLinkedList\nWhat word would you like to insert next?")
    input = read.nextLine()
    println("At what position? Enter a number")
    var index = read.nextInt()
    wordLinkedList.add(index - 1, input)
    println("Great! The new list is: $wordLinkedList")
    wordLinkedList.removeFirst()
    println("Now we will delete the first word. The new list is: $wordLinkedList\n.At which position would you like to delete the next word?")
    index = read.nextInt()
    wordLinkedList.removeAt(index-1)
    println("The new list is: $wordLinkedList.")
    println("Which word would you like to search for?")
    var newinput = read.nextLine()
    println("Your word is $newinput")

    if (wordLinkedList.contains(newinput)){
        println("Our database contains such a word!")
    }else
   {println("No such word")}


}


