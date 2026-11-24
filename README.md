<div align="center">
	<picture>
		<source media="(prefers-color-scheme: dark)" srcset="assets/logos/logo-white.svg">
		<img height="50" width="50" alt="DailleShell Logo" src="assets/logos/logo.svg">
	</picture>
</div>

# <div align="center">DailleShell</div>

<div align="center">
<picture><source media="(prefers-color-scheme: dark)" srcset="https://www.shieldcn.dev/github/stars/bannev1/DailleShell.svg?variant=secondary&amp;size=sm&amp;mode=dark&amp;theme=neutral"><img alt="GitHub Stars" src="https://www.shieldcn.dev/github/stars/bannev1/DailleShell.svg?variant=secondary&amp;size=sm&amp;mode=light&amp;theme=neutral"></picture>
<picture><source media="(prefers-color-scheme: dark)" srcset="https://www.shieldcn.dev/github/forks/bannev1/dailleshell.svg?variant=secondary&amp;size=sm&amp;mode=dark&amp;theme=neutral"><img alt="GitHub Forks" src="https://www.shieldcn.dev/github/forks/bannev1/DailleShell.svg?variant=secondary&amp;size=sm&amp;mode=light&amp;theme=neutral"></picture>
<picture><source media="(prefers-color-scheme: dark)" srcset="https://www.shieldcn.dev/github/license/bannev1/DailleShell.svg?variant=ghost&amp;size=sm&amp;mode=dark&amp;theme=neutral"><img alt="License" src="https://www.shieldcn.dev/github/license/bannev1/DailleShell.svg?variant=ghost&amp;size=sm&amp;mode=light&amp;theme=neutral"></picture>

[![GitHub Downloads (all assets, all releases)](https://shieldcn.dev/github/downloads/bannev1/DailleShell.svg?variant=outline&size=sm)](https://github.com/bannev1/DailleShell/releases/latest)
[![GitHub Release](https://shieldcn.dev/github/release/bannev1/DailleShell.svg?size=sm)](https://github.com/bannev1/DailleShell/releases/latest)
![Please star this repo](https://shieldcn.dev/badge/★%20please%20star-22c55e.svg?theme=amber&color=eab308&size=sm&variant=outline)
</div>

***

## Table of Contents

- [DailleShell](#dailleshell)
	- [Table of Contents](#table-of-contents)
	- [1. Introduction](#1-introduction)
		- [The Problem](#the-problem)
	- [2. Installation](#2-installation)
		- [Prerequisites](#prerequisites)
		- [Compile](#compile)
		- [Running a Compiled Version](#running-a-compiled-version)
		- [Run (without compiling)](#run-without-compiling)
	- [3. Usage](#3-usage)
		- [Commands](#commands)
		- [Operators](#operators)
	- [4. Roadmap](#4-roadmap)
		- [Planned Features](#planned-features)
	- [5. Contributing](#5-contributing)
	- [6. License](#6-license)
	- [7. Credits](#7-credits)
	- [8. Contact](#8-contact)

## 1. Introduction

The name *"Daille"* stems from the Old Norse word *"dæll"*, meaning easy. Like its namesake, Daille Shell is designed to be easy to use. It intends to serve as a simpler version of the more popular [shells](https://en.wikipedia.org/wiki/Shell_(computing)) like [Bash](https://en.wikipedia.org/wiki/Bash_(Unix_shell)) and [PowerShell](https://en.wikipedia.org/wiki/PowerShell).

To briefly explain how this shell works, it first gathers user input, then it [tokenizes](https://www.ibm.com/think/topics/tokenization) said input, [parses](https://en.wikipedia.org/wiki/Parsing) these tokens into an [Abstract Syntax Tree (AST)](https://en.wikipedia.org/wiki/Abstract_syntax_tree), before executing the commands.

This project was produced for a class project, and is written in Java. *Why Java?* Java was chosen due to my experience with the language and its cross-platform support. While some may argue that a language like C or C++ may be more suited, for the sake of not overcomplicating this project, Java was deemed more suitable.

### The Problem

This project aims to help young, learning developers easily grasp how to use its more complicated counterparts (Bash, PowerShell). And, as an added bonus, helps me develop my own understanding of how shells like this operate. 

It's designed to be different from your typical shell, *(it uses `go` to change directory instead of `cd`)* but still be intuitive such that the average person should vaguely be able to understand what is going on. `go` is more intuitively understood by the average person to go somewhere *(a different directory, perhaps?)*, whereas `cd` is an acronym which likely would require a quick Google search to comprehend.

As the average developer has exposure to at least one programming language, this shell also features the infamous semicolon `;`. The semicolon is **required** after each command, to mimic the average programming language. *Why?* It aims to enforce the common understanding that a shell is a programming language.

## 2. Installation

> [!NOTE] 
> You should make sure you have **installed the [prerequisites](#prerequisites)** before proceeding.

There are three ways to run this project. The **easiest and the recommended approach** to this is to run a pre-compiled build. You can download pre-compiled builds in the [Releases tab](https://github.com/bannev1/DailleShell/releases), and run these builds by following [these instructions](#running-a-compiled-version). 

You can also choose to [compile it yourself](#compile) or [run the program without compiling](#run-without-compiling).

### Prerequisites

For this project, all you will need is **Java 27 or newer**. You can officially download Java [here](https://www.oracle.com/java/technologies/downloads/).

### Compile

To compile this program, you can choose to compile it with [make](https://www.gnu.org/software/make/) *(may need installation)* or with just [Java](https://www.oracle.com/java/technologies/downloads/).

With make:
```
make build
```

With Java:
```
javac -d out $(find src -name '*.java')
```

This puts the compiled `.class` files in `out/`.

Once compiled, you can now [execute the compiled project](#running-a-compiled-version).

### Running a Compiled Version

If you've followed the [Compile](#compile) section or you have downloaded a compiled version of this project from the Releases tab, you can simply run:

```
java -jar daille-shell.jar
```

### Run (without compiling)

To run the program without compiling, first download this repository. Once you've downloaded it, you can run it with the following command:

```
java src/Main.java
```

## 3. Usage

Once you've [installed](#2-installation) the program, now's the time to actually ***use*** it. But how, you may ask. 

Once the program's up and running, you'll see something **similar** to this:

```
C:\Users\username\Downloads > 
```

The `C:\Users\username\Downloads` shows your current directory. This is where you are at this moment. The `>` indicates you can type a command.

Congratulations! You're now able to write commands! See [below](#commands) for a list of supported commands.

### Commands

> [!IMPORTANT]
> Remember, there **must** be a semicolon at the end of a command. If there is no semicolon, the shell will assume the following line is a continuation of your previous line.

See the following table for an overview of how each supported command works:

| Command | Usage | Description | Example |
| :---: | :---: | :--- | :---: |
| `go` | `go <PATH>` | Allows you to 'go' to a different directory/folder. Operates similarly to [cd](https://en.wikipedia.org/wiki/Cd_(command)) | `go ../home;`<br>`go Downloads;`<br>`go Downloads\My Folder\here;` |
| `path` | `path` | Outputs the current absolute/full path <br>If you change the path with `go`, this output also changes | *Sample output of `path;`:* <br> `C:\Users\username\Downloads` |
| `create` | `create <dir/file> <ITEM NAME>` | Allows you to create the desired directory/folder or file with the specified name `<ITEM NAME>` <br> Remember to  | `create dir Folder;`<br>`create file My File.txt;` |
| `read` | `read <FILE NAME>` | Reads the file specified by `<FILE NAME>` and outputs it | `read file.txt`<br>`read My File.txt` |
| `rename` | `rename <PATH TO FILE/FOLDER> <NEW NAME>` | Renames a file or folder located at `<PATH TO FILE/FOLDER>` to the specified `<NEW NAME>`<br>*Note spaces are **not** yet allowed in either the path or the name for this command.* | `rename myFolder folderA`<br>`rename Downloads/aFolder folderB`<br>`rename textFile.txt file.txt`<br>`rename Folder/myFile.exe newName.exe` |
| `exit` | `exit` | Exits the program | `exit` |

### Operators

Operators allow you to do more things with commands. If one command doesn't work, you can run another only if it doesn't work. 

Below exists a table of current supported operators:

| Operator | Description | Example |
| :---: | :--- | :---: |
| `&` | Means **AND**. <br>If the command to its left executed successfully, will also execute the command to its right | `go path & create file myFile.txt` |
| `?` | Means **OR**. <br>If the command to its left executed successfully, it will *not* execute the command to its right | `create file myPath/myFile.txt ? create dir myPath` |

## 4. Roadmap

> [!NOTE]
> Please see the official [Kanban Roadmap](https://github.com/users/bannev1/projects/10) for more details.


### Planned Features

The following features are planned to be implemented or are currently being implemented:

- [ ] Support for external commands (i.e, Vim, git, etc)
- [ ] Support for quotation marks in commands
- [ ] Ability to download new commands
- [ ] Support for basic arithmetic
- [ ] Thread support for commands *(allowing multiple commands to be executed at the same time)*
- [ ] Pipe `|` operator allowing for the input of one command to be "piped" into another command
- [ ] Ability to configure the shell
  - [ ] Option to remove its requirement of semicolons for each command
- [ ] Create compiler for .daille files


## 5. Contributing

If you want to contribute to this project, please follow the guidelines below:

1. Fork the repository
2. Create a new branch for your changes
3. Make your changes and commit them
4. Push the new branch to your fork
5. Submit a pull request

## 6. License

This project is licensed under the GNU General Public License V3. See our [LICENSE](LICENSE) for more information.

## 7. Credits

Thank you very much to all the people involved in this project:

- [Valentina Banner](https://github.com/bannev1) - *Creator*

## 8. Contact

If you need to contact someone urgently or directly regarding this project, you may contact the owner of the repository by filling out [this form](https://valentinabanner.com/#contact).

If you would like to simply make a bug report or request a feature, please create a [new Issue](https://github.com/bannev1/DailleShell/issues) through GitHub.
