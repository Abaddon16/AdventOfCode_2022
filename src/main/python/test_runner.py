import unittest

if __name__ == '__main__':
    testsuite = unittest.TestLoader().discover('test', 'day*test.py')
    unittest.TextTestRunner(verbosity=1).run(testsuite)
