#Conway's Game of Life
Game of Life![img](https://github.com/DJHeadset/Game_of_Life/assets/115445237/2d640f90-2cc2-4e70-bb64-fcf8d06aa57e)

## Table of Contents
- [Description](#description)
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)

## Description
This is a Java-based application that simulates Conway's "Game of Life," a classic cellular automaton. The project provides a visual representation of the simulation using Java's JPanel and includes a feature to export the simulation data into a CSV (Comma-Separated Values) file.
Disclaimer: Saving to .csv file only works if started from IDE. You need to uncomment line 91 in Board.java file.

## Overview
Conway's Game of Life is a fascinating cellular automaton that models the evolution of cells on a grid. Cells can be in one of two states: alive or dead. The state of each cell is determined by a set of rules, and the simulation progresses through generations based on these rules.

## Features
Visual Simulation: The application visually displays the Game of Life simulation using Java's JPanel.

CSV Export: This feature allows you to export the simulation data into a CSV file, providing a structured record of the simulation's state over time. The file is found in "src/resources/population.csv"

Settings: The variables located in the 'GamePanel' file, they can be edited there.

    maxScreenCol/maxScreenCol:  Representing the width and height of the JPanel's size (in pixel).
    tileSize:                   Represents the size of each cell (in pixel).
    FPS:                        Represents the refresh rate.

## Technologies Used

* JAVA

## Getting Started
For Developers:
Clone the repository:

```
git clone git@github.com:DJHeadset/Game_of_Life.git
```

Start the Application file.

For Users:
I. Install Java 17 SE for your Operating System:

1. [Windows](https://download.oracle.com/java/17/archive/jdk-17.0.9_windows-x64_bin.exe)
2. [Linux (Debian package)](https://download.oracle.com/java/17/archive/jdk-17.0.9_linux-x64_bin.deb)
3. [linux (RPM Package)](https://download.oracle.com/java/17/archive/jdk-17.0.9_linux-x64_bin.rpm)
4. [Mac OS](https://download.oracle.com/java/17/archive/jdk-17.0.9_macos-x64_bin.dmg)

If you would like something different, the whole list is awailable [here](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

II. Download and install the .jar file from [here](https://github.com/DJHeadset/Game_of_Life/releases/download/Development/game-of-life-1.0.jar)

III. Enjoy!