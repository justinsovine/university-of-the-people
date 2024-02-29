def calculate_area(shape, *args):
    """
    Calculate the area of a geometric shape.

    Parameters:
    - shape (str): The geometric shape (rectangle, circle, triangle).
    - *args (float): The arguments needed for the specific shape.

    Returns:
    float: The area of the geometric shape.
    """
    # Stage 5: Validation and Documentation
    if shape.lower() not in ['rectangle', 'circle', 'triangle']:
        return "Invalid shape. Please choose rectangle, circle, or triangle."

    if shape.lower() == 'rectangle':
        if len(args) != 2:
            return "Invalid number of arguments for rectangle. Please provide length and width."
        return args[0] * args[1]

    elif shape.lower() == 'circle':
        if len(args) != 1:
            return "Invalid number of arguments for circle. Please provide the radius."
        return 3.14 * args[0] ** 2

    elif shape.lower() == 'triangle':
        if len(args) != 2:
            return "Invalid number of arguments for triangle. Please provide base and height."
        return 0.5 * args[0] * args[1]

def main():
    # Test Case 1
    result_1 = calculate_area('rectangle', 5, 8)
    print("Area of a rectangle: ", result_1)

    # Test Case 2
    result_2 = calculate_area('circle', 4)
    print("Area of a circle: ", result_2)

    # Test Case 3
    result_3 = calculate_area('triangle', 6, 10)
    print("Area of a triangle: ", result_3)

main()