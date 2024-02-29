# Example 1: Define a function that takes an argument. 
# Call the function. Identify what code is the argument and what code is the parameter.
def brew_magical_potion(potion_type):
    print("Brewing a powerful " + potion_type + " potion!")

brew_magical_potion("Invisibility")

# Example 2: Call your function from Example 1 three times with different kinds of arguments: 
# a value, a variable, and an expression. Identify which kind of argument is which.

# 1 - A value
brew_magical_potion("Strength") # Value

# 2 - A variable
potion_needed = "Love"
brew_magical_potion(potion_needed)

# 3 - An expression
brew_magical_potion("Super " * 2 + "Speed")

# Example 3: Construct a function with a local variable. 
# Show what happens when you try to use that variable outside the function. 
# Explain the results.
def summon_familiar(familiar_name):
    wizard_spell = "Summoning " + familiar_name + ", the magical familiar!"
    print(wizard_spell)

print(wizard_spell)

# Example 4: Construct a function that takes an argument. Give the function parameter a 
# unique name. Show what happens when you try to use that parameter name outside the function. 
# Explain the results.
def cast_spell(incantation):
    magic_words = "The mystical incantation is: " + incantation
    print(magic_words)

print(incantation)

# Example 5: Show what happens when a variable defined outside a function 
# has the same name as a local variable inside a function. 
# Explain what happens to the value of each variable as the program runs.

def enter_wizard_tower():
    wizard_tower = "Ebony Citadel"
    print("Entering the wizard's tower: " + wizard_tower)

wizard_tower = "Ivory Spire"

print("Outside the function: " + wizard_tower)

enter_wizard_tower()

print("Outside the function again: " + wizard_tower)


