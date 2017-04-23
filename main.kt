package org.barnettkent.cardHands

fun main(args: Array<String>) {
    var deck = Deck()
    for (s in suits) {
        for (r in ranks) {
            deck.add(Card(r, s))
        }
    }
    println("Deck: $deck")

	var allHands = genAllHands(deck)
	println("Hands generated: ${allHands.size}")
}
