package org.barnettkent.cardHands

val suits = arrayOf("H", "C", "D", "S")
val ranks = arrayOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "Q", "A")

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

	fun getCards(): ArrayList<Card> {
		var cardList = ArrayList<Card>()
		for (c in cards) {
			cardList.add(c)
		}
		return cardList
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

	fun isFull(): Boolean {
		var full = false
        if (size() >= maxHandSize) {
			full = true
		}
		return full
	}

    fun add(card: Card): Boolean {
        if(size() < maxHandSize) {
            cards.add(card)
            return true
        } else {
            return false
        }
    }

	fun copy(): Hand {
		var h = Hand()
		for (c in cards) {
			h.add(c)
		}
		return h
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
