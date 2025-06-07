# Pizza Calculator 🍕

A simple Java program to calculate the number of pizzas needed based on a group's hunger level.

## Features
- Calculates pizza requirements based on:
  - Number of people
  - Hunger level (Light, Medium, or Ravenous)
- Displays a menu of 8+ different pizzas with varying slice counts and prices
- Computes:
  - Total pizzas needed (rounded up to whole pizzas)
  - Total cost (in RM with 2 decimal places)
- Input validation for user entries
- Loop to perform multiple calculations

## Hunger Level Guide
| Level      | Slices per Person |
|------------|-------------------|
| Light      | 1 slice           |
| Medium     | 2 slices          |
| Ravenous   | 4 slices          |

## Calculation Logic
1. Determines total slices needed: `people × slices_per_person`
2. Calculates pizzas required: `ceil(total_slices / pizza_slices)`
   - Note: Each pizza's slice count varies (typically 8, but some have 10, etc.)
3. Sums cost based on selected pizzas

## Technical Implementation
- Pure Java implementation
- Modularized using divide-and-conquer approach
- No arrays/ArrayLists used
- Console-based interface

## How to Use
1. Run the program
2. Enter:
   - Number of people
   - Hunger level
3. View pizza menu and make selections
4. See calculated results:
   - Pizzas needed
   - Total cost (RM)
5. Option to perform another calculation
