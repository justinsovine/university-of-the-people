# Using the items method with tuples for dictionary iteration
spells_dict = {'Fireball': 5, 'Ice Blast': 3, 'Supernova': 8}

# Iterate over dictionary items as tuples
for spell, mp in spells_dict.items():
    print(f'Spell: {spell}, Mana Cost: {mp}')
