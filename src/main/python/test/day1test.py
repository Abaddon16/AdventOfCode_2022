import os
import unittest
from parameterized import parameterized
from day1 import get_calories

def read_in_lines(resource) -> list[int]:
    with open(os.getcwd()+"\\resources\\"+resource) as f:
        lines = [int(line.rstrip()) if line.rstrip().isnumeric() else None for line in f]
    return lines

class Day1Test(unittest.TestCase):
    @parameterized.expand([
        ['day1test.txt', 24000],
        ['day1.txt', 66616]
    ])
    def test_part1(self, resource, expected):
        calculated = get_calories(read_in_lines(resource), 1)
        self.assertEqual(expected, calculated)

    @parameterized.expand([
        ['day1test.txt', 45000],
        ['day1.txt', 199172]
    ])
    def test_part2(self, resource, expected):
        calculated=get_calories(read_in_lines(resource), 3)
        self.assertEqual(expected, calculated)
