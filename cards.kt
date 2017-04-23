package org.barnettkent.cardHands

val suits = arrayListOf<String>("H", "C", "D", "S")
val ranks = arrayListOf<String>("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q", "A")

class Card(r: String, s: String) {
    val rank = r
    val suit = s

    override fun toString(): String {
        return "$rank$suit"
    }
}

class Deck() {
    private var cards = ArrayList<Card>()

    fun add(card: Card) {
        cards.add(card)
    }

    override fun toString(): String {
        var stringRep = "["
        for (index in 0..(cards.size-1)) {
            stringRep += "${cards[index].toString()}"
            if (index < cards.size-1) {
                stringRep += ", "
            }
        }
        stringRep += "]"
        return stringRep 
    }
}

class Hand() {
    private var cards = ArrayList<Card>()
    private val maxHandSize = 5

    fun size(): Int {
        return cards.size
    }

    fun add(card: Card): Boolean {
        if(size() < maxHandSize) {
            cards.add(card)
            return true
        } else {
            return false
        }
    }

    override fun toString(): String {
        var stringRep = "["
        for (index in 0..cards.size-1) {
            stringRep += "${cards[index].toString()}"
            if (index < cards.size-1) {
                stringRep += ", "
            }
        }
        stringRep += "]"
        return stringRep 
    }
}
