# Python Programming Homework

# Original dictionary containing students and their courses
original_dict = {
    'Stud1': ['CS1101', 'CS2402', 'CS2001'],
    'Stud2': ['CS2402', 'CS2001', 'CS1102']
}

def invert_dictionary(input_dict):
    inverted_dict = {}
    for student, courses in input_dict.items():
        for course in courses:
            if course not in inverted_dict:
                inverted_dict[course] = [student]
            else:
                inverted_dict[course].append(student)
    return inverted_dict

# Inverting the original dictionary
inverted_output = invert_dictionary(original_dict)

# Printing the original and inverted dictionaries
print("Original Dictionary:")
print(original_dict)
print("\nInverted Output:")
print(inverted_output)

# Explanation:
# The program defines a function 'invert_dictionary' that takes a dictionary as input and returns its inverted form.
# It iterates through the original dictionary, and for each student and their courses, it adds each course as a key
# in the inverted dictionary and appends the student to the list of values associated with that course key.
# The final result is an inverted dictionary with courses as keys and lists of students as values.

# Sample Output Explanation:
# Original Dictionary:
# {'Stud1': ['CS1101', 'CS2402', 'CS2001'], 'Stud2': ['CS2402', 'CS2001', 'CS1102']}
#
# Inverted Output:
# {'CS1101': ['Stud1'], 'CS2402': ['Stud1', 'Stud2'], 'CS2001': ['Stud1', 'Stud2'], 'CS1102': ['Stud2']}
