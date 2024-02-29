def cast_spell(wizard_name, magical_ability, spell_power):
    # Preconditions
    if not magical_ability:
        print("Error: " + wizard_name + " must have a magical ability to cast spells")
        return magical_ability

    if not isinstance(spell_power, int) or spell_power <= 0:
        print("Error: Spell power must be a positive integer")
        return magical_ability

    # Casting the spell consumes magical energy
    remaining_energy = magical_ability - spell_power

    # Postcondition check
    if remaining_energy < 0:
        print("Error: Spell power exceeds " + wizard_name + "'s magical ability")
        return magical_ability

    print(wizard_name + " cast a spell. Remaining magical energy: " + remaining_energy)
    return remaining_energy

def main():
    # Wizard stats
    wizard_name = "Medra"
    magical_ability = 75

    # Invalid spell power
    spell_power = -10
    remaining_energy = cast_spell(wizard_name, magical_ability, spell_power)

    # Valid spell power
    spell_power = 20
    remaining_energy = cast_spell(wizard_name, magical_ability, spell_power)

main()