def hypotenuse(leg1, leg2):
    """
    Calculate the length of the hypotenuse of a right triangle.

    Parameters:
    - leg1 (float): Length of the first leg.
    - leg2 (float): Length of the second leg.

    Returns:
    float: Length of the hypotenuse.
    """
    # Stage 4: Documentation
    if leg1 <= 0 or leg2 <= 0:
        return "Leg lengths must be positive numbers."

    hypotenuse_length = (leg1**2 + leg2**2)**0.5
    return hypotenuse_length

def main():
    # Test Case 1
    leg1_1, leg2_1 = -3, 4
    result_1 = hypotenuse(leg1_1, leg2_1)
    output_1 = "For legs " + str(leg1_1) + ", " + str(leg2_1) + " => Hypotenuse: " + str(result_1)
    print(output_1)

    # Test Case 2
    leg1_2, leg2_2 = 5, 12
    result_2 = hypotenuse(leg1_2, leg2_2)
    output_2 = "For legs " + str(leg1_2) + ", " + str(leg2_2) + " => Hypotenuse: " + str(result_2)
    print(output_2)

    # Test Case 3
    leg1_3, leg2_3 = 8, 15
    result_3 = hypotenuse(leg1_3, leg2_3)
    output_3 = "For legs " + str(leg1_3) + ", " + str(leg2_3) + " => Hypotenuse: " + str(result_3)
    print(output_3)

# Execute the main function
main()