fin = open('words.txt')
print(type(fin))
for line in fin:
    word = line.strip()
    print(word)