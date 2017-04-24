package org.barnettkent.cardHands

import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    var deck = Deck()
    for (s in suits) {
        for (r in ranks) {
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
}
