# Bird-Conservatory

# 🐦 PDP Lab 1: Bird Classification and Conservatory System

## 📚 Overview

This is the first lab assignment for the *Program Design Paradigms (CS 5010)* course at Northeastern University. The goal is to design and implement a system in Java that models various bird classifications and manages a bird conservatory with specific housing rules.

## 🌿 Problem Statement

Modern biologists classify birds by traits and behaviors. In this lab, you’ll simulate that classification using object-oriented principles. Your program should:

- Represent various types of birds with relevant attributes.
- Manage a conservatory that houses rescued birds in aviaries.
- Enforce constraints around bird housing, extinction status, and species compatibility.

## 🧱 Features

### ✅ Bird Classification Support

Supports the following bird categories:
- **Birds of Prey** (e.g., hawks, eagles)
- **Flightless Birds** (e.g., emus, kiwis)
- **Owls**
- **Parrots** (e.g., grey parrot, rose-ring parakeet)
- **Pigeons (Doves)**
- **Shorebirds** (e.g., puffins, jacanas)
- **Waterfowl** (e.g., ducks, swans)

### ✅ Attributes Tracked

- Bird type and classification
- Defining characteristics
- Extinction status
- Number of wings
- Dietary preferences (2–4 items from a fixed list)
- Water source (if applicable)
- Parrot-specific: vocabulary size and favorite saying

### ✅ Conservatory Management

- Up to 20 aviaries in the conservatory
- Each aviary holds a max of 5 birds
- No extinct birds allowed
- Some bird types cannot be mixed
- Calculates total food requirements

## 🧪 Testing

Includes a complete JUnit test suite that:
- Verifies bird creation and attribute handling
- Validates housing constraints
- Confirms food requirement calculations

### 🔍 Example Test Scenarios

- ✅ Add a waterfowl bird to an empty aviary
- ❌ Prevent extinct bird from being added
- ❌ Block mixed aviary with owl and flightless bird
- ✅ Ensure accurate food inventory calculation




src/
├── bird/
│   ├── Bird.java
│   ├── BirdOfPrey.java
│   ├── Parrot.java
│   └── ...
├── conservatory/
│   ├── Aviary.java
│   ├── Conservatory.java
│   └── ...
├── Main.java
test/
├── BirdTest.java
├── ConservatoryTest.java

