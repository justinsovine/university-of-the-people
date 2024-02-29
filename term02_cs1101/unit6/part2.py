# Sentence to Wordlist
def sentence_to_wordlist(sentence):
    return sentence.split()

# Reverse WordList
def reverse_wordlist(wordlist):
    return wordlist[::-1]

# Input sentence
input_sentence = "The mystical portal led to a realm of ancient spells."

# Convert sentence to wordlist and reverse
word_list = sentence_to_wordlist(input_sentence)
reversed_word_list = reverse_wordlist(word_list)

# Output for Wordlist Reversal
print("\nWordlist Reversal:")
print("Input Sentence:", input_sentence)
print("Wordlist:", word_list)
print("Reversed Wordlist:", reversed_word_list)