import os
import unittest
from parameterized import parameterized
from day2 import get_score_1, get_score_2

def read_in_lines(resource) -> list[str]:
    with open(os.getcwd()+"\\resources\\"+resource) as f:
        lines = [line.rstrip() for line in f]
    return lines

class MyTestCase(unittest.TestCase):

    @parameterized.expand([
        ['day2test.txt', 15],
        ['day2.txt', 15691]
    ])
    def test_part1(self, resource, expected):
        calculated = get_score_1(read_in_lines(resource))
        self.assertEqual(expected, calculated)

    @parameterized.expand([
        ['day2test.txt', 12],
        ['day2.txt', 12989]
    ])
    def test_part2(self, resource, expected):
        calculated = get_score_2(read_in_lines(resource))
        self.assertEqual(expected, calculated)
