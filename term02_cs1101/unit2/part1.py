import math

# #
# Takes an argument for the circle’s radius 
# and prints the circle's circumference
def print_circum(radius):
    circumference = 2 * math.pi * radius
    print("The circumference of a circle with radius " + str(radius) + " is: " + str(circumference))

# Call the function three times with different values for radius
print_circum(1)
print_circum(2)
print_circum(3)