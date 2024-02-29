# Using enumerate with tuples for list iteration
familiar_list = ['Owl', 'Cat', 'Frog', 'Spider']

# Enumerate over the list and print index and element
for index, familiar in enumerate(familiar_list):
    print(f'Index: {index}, Familiar: {familiar}')