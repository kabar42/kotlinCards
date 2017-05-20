package org.barnettkent.cardHands

val SUIT_COUNT: Int = 4

enum class Suit(val s: Int) {
    HEARTS(0),
    CLUBS(1),
    DIAMONDS(2),
    SPADES(3);

    companion object {
        fun from(findValue: Int): Suit = Suit.values().first { it.ordinal == findValue }
    }
}

val RANK_COUNT: Int = 13

enum class Rank(val r: Int) {
    ACE(0),
    TWO(1),
    THREE(2),
    FOUR(3),
    FIVE(4),
    SIX(5),
    SEVEN(6),
    EIGHT(7),
    NINE(8),
    TEN(9),
    JACK(10),
    QUEEN(11),
    KING(12);

    companion object {
        fun from(findValue: Int): Rank = Rank.values().first { it.ordinal == findValue }
    }
}

class Card(r: Rank, s: Suit) {
    val rank = r
    val suit = s

    override fun toString(): String {
        val s = suit.name[0]
        val rankName = rank.name[0]
        var r: String = "$rankName"

        if (rank >= Rank.TWO && rank <= Rank.TEN) {
            r = (rank.ordinal+1).toString()
        }
        return "$r$s"
    }
}

class Deck() {
    private var cards = ArrayList<Card>()

    fun size(): Int {
        return cards.size
    }

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

    fun getCard(i: Int): Card {
        return cards[i]
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

val HAND_SIZE: Int = 5

class Hand() {
    var cards = ArrayList<Card>()
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
