# Divides two numbers and provides error if second number is 0
def divide_numbers(num1, num2):
    
    # Check if the second number is zero before performing division
    if num2 != 0:
        result = num1 / num2
        print("Result of division:", result)
    else:
        print("Error: Division by zero is not allowed.")


# Begin executive code
num1 = float(input("Enter the first number: "))
num2 = float(input("Enter the second number: "))
divide_numbers(num1, num2)