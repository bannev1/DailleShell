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
	- [2. Usage](#2-usage)
		- [Prerequisites](#prerequisites)
		- [Compile](#compile)
		- [Running a Compiled Version](#running-a-compiled-version)
		- [Run (without compiling)](#run-without-compiling)
		- [Example session](#example-session)
	- [3. Roadmap](#3-roadmap)
		- [Planned Features](#planned-features)
	- [4. Contributing](#4-contributing)
	- [5. License](#5-license)
	- [6. Credits](#6-credits)
	- [7. Contact](#7-contact)

## 1. Introduction

The name *"Daille"* stems from the Old Norse word *"dæll"*, meaning easy. Like its namesake, Daille Shell is designed to be easy to use. It intends to serve as a simpler version of the more popular [shells](https://en.wikipedia.org/wiki/Shell_(computing)) like [Bash](https://en.wikipedia.org/wiki/Bash_(Unix_shell)) and [PowerShell](https://en.wikipedia.org/wiki/PowerShell), whilst serving as a learning opportunity for myself.

To briefly explain how this shell works, it first gathers user input, then it [tokenizes](https://www.ibm.com/think/topics/tokenization) said input, [parses](https://en.wikipedia.org/wiki/Parsing) these tokens into an [Abstract Syntax Tree (AST)](https://en.wikipedia.org/wiki/Abstract_syntax_tree), before executing the commands.

It is produced for a class project, and is written in Java. *Why Java?* Java was chosen due to its 

## 2. Usage

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

If you've followed the [Compile](#compile) section or you have downloaded a compiled version of this project from the Releases tab, you can simply run

```

```

### Run (without compiling)

1. Download `daille-shell.jar` from the [Releases](<LINK>) page.
2. Run:
```
java -jar daille-shell.jar
```

### Example session
```
<paste a real session here: your prompt, a few commands, and the output>
```

## 3. Roadmap

> [!NOTE]
> Please see the official [Kanban Roadmap](https://github.com/users/bannev1/projects/10) for more details.


### Planned Features

The following features are planned to be implemented or are currently being implemented:

- [ ] 


## 4. Contributing

If you want to contribute to this project, please follow the guidelines below:

1. Fork the repository
2. Create a new branch for your changes
3. Make your changes and commit them
4. Push the new branch to your fork
5. Submit a pull request

## 5. License

This project is licensed under the GNU General Public License V3. See our [LICENSE](LICENSE) for more information.

## 6. Credits

Thank you very much to all the people involved in this project:

- [Valentina Banner](https://github.com/bannev1) - *Creator*

## 7. Contact

If you need to contact someone urgently or directly regarding this project, you may contact the owner of the repository by filling out [this form](https://valentinabanner.com/#contact).

If you would like to simply make a bug report or request a feature, please create a [new Issue](https://github.com/bannev1/DailleShell/issues) through GitHub.
