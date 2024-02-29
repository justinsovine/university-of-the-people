# Initial list of 10 wizard names
wizard_names = [
    "Zaroth", 
    "Morgana", 
    "Cthulhuon", 
    "Lorelei", 
    "Spectros", 
    "Azrakel", 
    "Eldritch", 
    "Nyxar", 
    "Sylvanor", 
    "Malphas"
]

# 1. Split the list into two sub-lists
subList1 = wizard_names[:5]
subList2 = wizard_names[5:]

# 2. Add a new employee "Kriti Brown" to subList2
subList2.append("Kriti Brown")

# 3. Remove the second employee's name from subList1
del subList1[1]

# 4. Merge both the lists
mergedList = subList1 + subList2

# 5. Create Salary List and apply a 4% raise for each employee
salaryList = [50000, 60000, 55000, 70000, 65000, 72000, 58000, 63000, 68000, 67000]
for i in range(len(salaryList)):
    salaryList[i] = round(salaryList[i] * 1.04)

# 6. Sort the SalaryList and show top 3 salaries
sortedSalaries = sorted(salaryList, reverse=True)
topThreeSalaries = sortedSalaries[:3]

# Output for HR Department
print("HR Department Operations:")
print("Initial Wizard Names List:", wizard_names)
print("SubList1:", subList1)
print("SubList2:", subList2)
print("After Adding 'Kriti Brown' to SubList2:", subList2)
print("After Removing Second Employee from SubList1:", subList1)
print("Merged List:", mergedList)
print("Initial Salary List:", salaryList)
print("Salary List After 4% Raise:", salaryList)
print("Top 3 Salaries:", top3Salaries)