'''
Created on 27.10.2013

@author: infinity
'''
from random import randint

def radixSort(source, k, m):
    result = list(source)
    for i in range(k):
        rounder = m ** (i + 1)
        delimeter = rounder // m
        backets = dict()
        for x in result:
            a = (x % rounder) // delimeter
            if a in backets:
                backets[a].append(x)
            else:
                backets[a] = [x]
        result.clear()
        for b in backets.values():
            for x in b:
                result.append(x)
    return result

source = list()
for i in range(10):
    source.append(randint(100, 999))

print("Source List: ", source)
sort = radixSort(source, 3, 10)
print("Sorted List: ", sort)
