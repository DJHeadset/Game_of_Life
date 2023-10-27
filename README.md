Conway's Game of Life
Game of Life

This is a Java-based application that simulates Conway's "Game of Life," a classic cellular automaton. The project provides a visual representation of the simulation using Java's JPanel and includes a feature to export the simulation data into a CSV (Comma-Separated Values) file.

Overview
Conway's Game of Life is a fascinating cellular automaton that models the evolution of cells on a grid. Cells can be in one of two states: alive or dead. The state of each cell is determined by a set of rules, and the simulation progresses through generations based on these rules.

Features
Visual Simulation: The application visually displays the Game of Life simulation using Java's JPanel.

CSV Export: This feature allows you to export the simulation data into a CSV file, providing a structured record of the simulation's state over time. The file is found in "src/resources/population.csv"

Settings: The variables located in the 'GamePanel' file, they can be edited there.
    maxScreenCol/maxScreenCol:  Representing the width and height of the JPanel's size (in pixel).
    tileSize:                   Represents the size of each cell (in pixel).
    FPS:                        Represents the refresh rate.

Installation and Running
1. Clone this repository to your local machine.
2. Build the project and ensure any dependencies are installed.
3. Run the application.