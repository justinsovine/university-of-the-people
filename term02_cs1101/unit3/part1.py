# Counts down from n
def countdown(n):
    if n <= 0:
        print('Blastoff!')
    else:
        print(n)
        countdown(n - 1)

# Counts up from n
def countup(n):
    if n >= 0:
        print('Blastoff!')
    else:
        print(n)
        countup(n + 1)

# Begin executive code
user_input = int(input("Enter a number: "))

if user_input > 0:
    countdown(user_input)

elif user_input < 0 or user_input == 0:
    countup(user_input)