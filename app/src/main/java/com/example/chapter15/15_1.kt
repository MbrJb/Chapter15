package com.example.chapter15
import java.util.LinkedList


/* In an ancient land, the beautiful princess Eve had many suitors. She decided on the following
procedure to determine which suitor she would marry. First, all of the suitors would be lined up one
after the other and assigned numbers. The first suitor would be number 1, the second number 2, and
so on up to the last suitor, number n. Starting at the suitor in the first position, she would then
count three suitors down the line (because of the three letters in her name), and the third suitor
would be eliminated from winning her hand and removed from the line. Eve would then continue,
counting three more suitors, and eliminate every third suitor. When she reached the end of the line,
she would continue counting from the beginning. For example, if there were six suitors, the
elimination process would proceed as follows:
                         123456     Initial list of suitors; start counting from 1.
                         12456      Suitor 3 eliminated; continue counting from 4.
                         1245       Suitor 6 eliminated; continue counting from 1.
                         125        Suitor 4 eliminated; continue counting from 5.
                         15         Suitor 2 eliminated; continue counting from 5.
                         1          Suitor 5 eliminated; 1 is the lucky winner.
Write a program that creates a circular linked list of nodes to determine which position you should
stand in to marry the princess if there are n suitors. Your program should simulate the elimination
process by deleting the node that corresponds to the suitor that is eliminated for each step in the
process. */
class Node<T>(var suitorNumber: T, var nextNode: Node<T>? = null){
    override fun toString(): String {
        return if (nextNode != null){
            "$suitorNumber -> ${nextNode.toString()}"
        }else "$suitorNumber"
    }
}

class SuitorsLinkedList<T: Any> {

    var head: Node<T>? = null
    var tail: Node<T>? = null
    var size = 0

    private fun linkedListEmpty(): Boolean = size == 0

    override fun toString(): String {
        return if (linkedListEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

    fun push(value: T) {
        head = Node(value, head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    fun addSuitor(value: T) {
        if (linkedListEmpty()) {
            push(value)
            return
        }
        tail?.nextNode = Node(value)
        tail = tail?.nextNode
        size++
    }

    fun removeSuitor(index: Int) {
        if (index == 0) {
            head = head?.nextNode
            return
        }
        var before: Node<T>? = head
        repeat(index - 1) {
            before = before?.nextNode
        }
        var after: Node<T>? = head
        repeat(index + 1) {
            after = after?.nextNode
        }
        before?.nextNode = after?.nextNode
    }


}

fun main() {
    val suitors = LinkedList<Int>()
    var currentIndex = 0

    for (i in 1..6) suitors.add(i)
    println("Initial list: $suitors")


    while (suitors.size != 1) {
        for (i in 1..2) {
            currentIndex++
            if (currentIndex == suitors.size) currentIndex = 0
        }
        suitors.remove(currentIndex)
        if (currentIndex == suitors.size) currentIndex = 0

         for (i in 0 until suitors.size) println(suitors[i].toString() )

    }
}
