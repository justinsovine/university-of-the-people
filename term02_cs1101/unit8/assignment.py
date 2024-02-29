# Function to read the dictionary from file
def read_dictionary_from_file(file_path):
    try:
        with open(file_path, 'r') as file:
            # Read the content of the file and evaluate it as a dictionary
            original_dict = eval(file.read())
        return original_dict

    except FileNotFoundError:
        print(f"Error: The file '{file_path}' does not exist.")
        return None

    except Exception as e:
        print(f"Error reading from file: {e}")
        return None

# Function to invert the dictionary and then write it to file
def invert_and_write_to_file(original_dict, output_file_path):
    inverted_dict = {}
    try:
        # Invert the original dictionary
        for key, value in original_dict.items():
            if isinstance(value, list):
                for v in value:
                    inverted_dict[v] = inverted_dict.get(v, []) + [key]
            else:
                inverted_dict[value] = inverted_dict.get(value, []) + [key]
        
        # Write the inverted dictionary to the output file
        with open(output_file_path, 'w') as output_file:
            output_file.write(str(inverted_dict))
        print(f"Successfully inverted and wrote to '{output_file_path}'.")

    except Exception as e:
        print(f"Error inverting and writing to file: {e}")

# Sample Input File
input_file_path = "sample_input.txt"

# Sample Output File
output_file_path = "sample_output.txt"

# Read original dictionary from file
original_dict = read_dictionary_from_file(input_file_path)

# If the original dictionary is successfully read, proceed to invert and write to the output file
if original_dict:
    invert_and_write_to_file(original_dict, output_file_path)