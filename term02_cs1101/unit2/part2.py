# #
# Returns a price after applying a 10% discount
def apply_10_percent_discount(price):
    discount_percentage = 10.0
    discount_amount     = price * (discount_percentage / 100)
    discounted_price    = price - discount_amount

    return discounted_price

# #
# Returns a price after applying a 25% discount
def apply_25_percent_discount(price):
    discount_percentage = 25.0
    discount_amount     = price * (discount_percentage / 100)
    discounted_price    = price - discount_amount

    return discounted_price

# #
# Calculate the number of spaces needed to bring a string up to 45 characters.
def calculate_spaces_needed(item_name, price):
    target_length = 45
    spaces_needed = target_length - len(item_name) - len(str(price))

    return spaces_needed

# #
# Displays the store catalog
def display_catalog(item_1_name, item_1_price, item_2_name, item_2_price, item_3_name, item_3_price):
    # General information
    print( '\nOnline Store' )
    print( '-' * 45 )
    print( 'Product(s)' + (30 * ' ') + 'Price' )

    # Product information
    print( item_1_name + ( calculate_spaces_needed(item_1_name, item_1_price) * ' ' ) + str(item_1_price) )
    print( item_2_name + ( calculate_spaces_needed(item_2_name, item_2_price) * ' ' ) + str(item_2_price) )
    print( item_3_name + ( calculate_spaces_needed(item_3_name, item_3_price) * ' ' ) + str(item_3_price) )

    # Combo 1 information
    combo_1_name = 'Combo 1 (' + item_1_name + ' + ' + item_2_name + ')'
    combo_1_price = apply_10_percent_discount(item_1_price + item_2_price)
    print( combo_1_name + (calculate_spaces_needed(combo_1_name, combo_1_price) * ' ') + str(combo_1_price) )

    # Combo 2 information
    combo_2_name = 'Combo 2 (' + item_2_name + ' + ' + item_3_name + ')'
    combo_2_price = apply_10_percent_discount(item_2_price + item_3_price)
    print( combo_2_name + (calculate_spaces_needed(combo_2_name, combo_2_price) * ' ') + str(combo_2_price) )

    # Combo 3 information
    combo_3_name = 'Combo 3 (' + item_1_name + ' + ' + item_3_name + ')'
    combo_3_price = apply_10_percent_discount(item_1_price + item_3_price)
    print( combo_3_name + (calculate_spaces_needed(combo_3_name, combo_3_price) * ' ') + str(combo_3_price) )

    # Combo 4 information
    combo_4_name = 'Combo 4 (' + item_1_name + ' + ' + item_2_name + ' + ' + item_3_name + ')'
    combo_4_price = apply_25_percent_discount(item_1_price + item_2_price + item_3_price)
    print( combo_4_name + (calculate_spaces_needed(combo_4_name, combo_4_price) * ' ') + str(combo_4_price) )

    # Outro
    print( '-' * 45 )
    print( 'For delivery contact: 98764678899\n' )

# Define catalog data
item_1_name = 'Item 1'
item_1_price = 200.0
item_2_name = 'Item 2'
item_2_price = 400.0
item_3_name = 'Item 3'
item_3_price = 600.0

# Call display catalog
display_catalog(item_1_name, item_1_price, item_2_name, item_2_price, item_3_name, item_3_price)