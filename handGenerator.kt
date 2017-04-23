package org.barnettkent.cardHands

public fun genAllHands(deck: Deck): ArrayList<Hand> {
	var h = Hand()
	var allHands = ArrayList<Hand>()
	genHandsRecursive(deck.getCards().toList(), h, allHands)
	return allHands
}

fun genHandsRecursive(deckSlice: List<Card>, hand: Hand, allHands: ArrayList<Hand>) {
	if (hand.isFull()) {
		allHands.add(hand)
	} else if (deckSlice.size != 0) {
		// Check all paths that DO include this card
		var newHand = hand.copy()
		newHand.add(deckSlice[0])
		genHandsRecursive(deckSlice.slice(1..deckSlice.size-1), newHand, allHands)

		// Check all paths that do NOT include this card
		genHandsRecursive(deckSlice.slice(1..deckSlice.size-1), hand, allHands)
	}
}
