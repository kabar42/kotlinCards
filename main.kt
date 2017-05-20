package org.barnettkent.cardHands

import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    var deck = Deck()
    for (s in Suit.values()) {
        for (r in Rank.values()) {
            deck.add(Card(r, s))
        }
    }
    println("Deck: $deck")

    var allHands = ArrayList<Hand>()
    val genTime = measureTimeMillis {
        allHands = genAllHands(deck)
    }

    println("Hands generated: ${allHands.size}")
    println("Ran in $genTime ms")

    var handTypeCounts: IntArray = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    val countTime = measureTimeMillis {
        handTypeCounts = count_hand_types(allHands)
    }

    for (count in handTypeCounts) {
        println("$count")
    }
    println("Ran in $countTime ms")
}
