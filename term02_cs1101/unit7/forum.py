# Using zip with tuples for parallel iteration
list_a = [1, 2, 3, 4]
list_b = ['a', 'b', 'c', 'd']

# Zip lists into tuples for simultaneous iteration
zipped_tuples = zip(list_a, list_b)

# Loop over tuples and print elements
for a, b in zipped_tuples:
    print(f'Element from list_a: {a}, Element from list_b: {b}')