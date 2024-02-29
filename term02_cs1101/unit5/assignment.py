def display_left_chars(name, n):
    """Display n characters from the left of the input name."""

    # Validate input
    if n <= 0:
        print("Invalid input for the number of characters. Please enter a positive integer.")
        return
    
    print(f"Displaying {n} characters from the left: {name[:n]}")

def count_vowels(name):
    """Count the number of vowels in the input name."""

    # Validate that name is alphabetical
    if not name.isalpha():
        print("Invalid input for the name. Please enter a valid alphabetical name.")
        return

    # String containing all vowels
    vowels = "aeiouAEIOU"

    # Initialize a variable to store the total vowel count
    vowel_count = 0

    # Iterate through each vowel and count its occurrences in the name
    for vowel in vowels:
        vowel_count += name.count(vowel)

    # Display the total vowel count
    print(f"Number of vowels in the name: {vowel_count}")

def reverse_name(name):
    """Reverse the input name."""

    # Validate that name is alphabetical
    if not name.isalpha():
        print("Invalid input for the name. Please enter a valid alphabetical name.")
        return

    reversed_name = name[::-1]
    print(f"Reversed name: {reversed_name}")

def main():
    """Executive function"""

    # Input user's name
    name = input("Enter your name: ")

    # Step 1: Display n characters from the left
    n_chars = int(input("Enter the number of characters to display from the left: "))
    display_left_chars(name, n_chars)

    # Step 2: Count the number of vowels
    count_vowels(name)

    # Step 3: Reverse the name
    reverse_name(name)

# Execute the main function to run the program
main()
