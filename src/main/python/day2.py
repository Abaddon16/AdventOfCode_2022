
HANDS = [1, 2, 3] # ROCK, PAPER, SCISSORS
RESULTS = [3, 6, 0] # TIE, WIN, LOSE

def get_score_1(play_strings: list[str]):
    """
    Uses (player - opponent) % 3 = result; this works specifically with the above (TIE, WIN, LOSE) condition
    """
    plays = [[ord(x)-65, ord(y)-23-65] for play in play_strings for x, y in [play.split(' ')]]
    return sum([RESULTS[(player-opponent) % 3] + HANDS[player] for opponent, player in plays])

def get_score_2(play_strings: list[str]):
    """
    Uses (opponent + result) % 3 = player; this works specifically with the above (TIE, WIN, LOSE) condition
    Additionally, the parsed results are decremented by 1 and modded by three to account for altered
    conditions in problem:
        I stored them as (TIE, WIN, LOSE)
        The problem has them as (LOSE, TIE, WIN) - shifted by one
    """
    plays = [[ord(x)-65, (ord(y)-23-65-1)%3] for play in play_strings for x, y in [play.split(' ')]]
    return sum([RESULTS[result] + HANDS[(opponent + result) % 3] for opponent, result in plays])
