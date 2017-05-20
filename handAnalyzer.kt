package org.barnettkent.cardHands


enum class HandType(val s: Int) {
    NOPAIR(0),
    ONEPAIR(1),
    TWOPAIR(2),
    THREEOFAKIND(3),
    STRAIGHT(4),
    FLUSH(5),
    FULLHOUSE(6),
    FOUROFAKIND(7),
    STRAIGHTFLUSH(8),
    ROYALFLUSH(9);

    companion object {
        fun from(findValue: Int): HandType = HandType.values().first { it.ordinal == findValue }
    }
}

val HAND_TYPES_COUNT: Int = 10

data class HandData(var suit_count: IntArray,
                    var rank_count: IntArray )

fun count_hand_types(all_hands: ArrayList<Hand>): IntArray {
    var type_counts: IntArray = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

    for (hand in all_hands) {
        val handData = get_hand_data(hand)
        val hand_type = determine_hand_type(handData)
        type_counts[hand_type.ordinal] += 1
    }
    return type_counts
}

fun get_hand_data(hand: Hand): HandData {
    var suit_counts: IntArray = intArrayOf(0, 0, 0, 0)
    var rank_counts: IntArray = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    var handData = HandData(suit_counts, rank_counts)
    for (card in hand.cards) {
        handData.suit_count[card.suit.ordinal] += 1
        handData.rank_count[card.rank.ordinal] += 1
    }
    return handData
}

fun determine_hand_type(handData: HandData): HandType {
    var largest_rank_count = 0
    var second_largest_rank_count = 0

    for (count in handData.rank_count) {
        if (count > largest_rank_count) {
            second_largest_rank_count = largest_rank_count
            largest_rank_count = count
        } else if (count > second_largest_rank_count) {
            second_largest_rank_count = count
        }
    }

    var ranks_present: ArrayList<Rank> = get_ranks_present(handData.rank_count)

    if (HAND_SIZE in handData.suit_count) {
        if (handData.rank_count[Rank.TEN.ordinal] == 1 &&
            handData.rank_count[Rank.JACK.ordinal] == 1 &&
            handData.rank_count[Rank.QUEEN.ordinal] == 1 &&
            handData.rank_count[Rank.KING.ordinal] == 1 &&
            handData.rank_count[Rank.ACE.ordinal] == 1) {
            return HandType.ROYALFLUSH
        }

        if (ranks_are_sequential(ranks_present)) {
            return HandType.STRAIGHTFLUSH
        }

        return HandType.FLUSH
    }

    if (SUIT_COUNT in handData.rank_count) {
        return HandType.FOUROFAKIND
    }

    if (ranks_are_sequential(ranks_present)) {
        return HandType.STRAIGHT
    }

    if (largest_rank_count == 3) {
        if (second_largest_rank_count == 2) {
            return HandType.FULLHOUSE
        }
        return HandType.THREEOFAKIND
    }

    if (largest_rank_count == 2) {
        if (second_largest_rank_count == 2) {
            return HandType.TWOPAIR
        }
        return HandType.ONEPAIR
    }

    return HandType.NOPAIR
}

fun get_ranks_present(counts: IntArray): ArrayList<Rank> {
    var ranksPresent = ArrayList<Rank>(RANK_COUNT)
    for (i in 0..counts.size-1) {
        if (counts[i] > 0) {
            ranksPresent.add(Rank.from(i))
        }
    }
    return ranksPresent
}

fun ranks_are_sequential(ranks: ArrayList<Rank>): Boolean {
    if (ranks.size < HAND_SIZE) {
        return false
    }

    ranks.sort()

    if (ranks[0] == Rank.ACE &&
        ranks[1] == Rank.TEN &&
        ranks[2] == Rank.JACK &&
        ranks[3] == Rank.QUEEN &&
        ranks[4] == Rank.KING) {
        return true
    }


    for (i in 1..ranks.size-1) {
        val prev_rank = ranks[i-1].ordinal
        val this_rank = ranks[i].ordinal
        if (prev_rank != this_rank-1) {
            return false
        }
    }
    
    return true
}
