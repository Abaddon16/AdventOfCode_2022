def split(sequence, sep):
    chunk = []
    for val in sequence:
        if val == sep:
            yield chunk
            chunk = []
        else:
            chunk.append(val)
    yield chunk

def get_calories(calories: list[int], num_elves: int):
    return sum(sorted([sum(x) for x in split(calories, None)])[-num_elves:])
