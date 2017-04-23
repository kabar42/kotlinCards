package org.barnettkent.cardHands

fun main(args: Array<String>) {
    var deck = Deck()
    for (s in suits) {
        for (r in ranks) {
            deck.add(Card(r, s))
        }
    }

    println("Deck: $deck")

    var hand = Hand()
    hand.add(Card("A", "S"))
    hand.add(Card("K", "S"))
    hand.add(Card("Q", "S"))
    hand.add(Card("J", "S"))
    hand.add(Card("10", "S"))

    println("Hand: $hand")
}
