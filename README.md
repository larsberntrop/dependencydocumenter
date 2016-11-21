# Dependency Documenter
An IBM Domino Designer plugin that uses graphviz to visually show the dependencies within Script Libraries

## Visually document the dependency tree of Script Libraries in your database with one click

The two **ugly sisters of software quality** are **documentation** and **testing**. Both are sure-fire indicators of how easy a piece of software is going to be to maintain. They are not sexy, though, and most customers or end users don’t care about them.

Nor pay for them.

Bad documentation and missing testing routines makes their hit on quality insidiously, as codebases become incrementally more complex, more difficult to decipher, and changes to the software become, apparently unexplainably, more and more costly, and risky, until it reaches the ‘legacy’ status – change me at your own risk and peril, bwoa-ha-ha-ha!

**Manually generated documentation is useless**. It’s almost immediately out of date. The only real documentation is the code itself, and that’s why **any kind of documentation should be automatic**, taken from the actual application. JavaDoc is superb, as was Mikkel Heisterberg’s lsdoc.org (which is sadly not online anymore – please join me in bribing Mikkel to reinstate it).

The Domino Designer Plug-in Dependency Documenter is a modest contribution to help you document IBM Notes applications. Once the plug-in is installed, a **click of the button will make a diagram showing how the database’s script libraries depend on each other.**

The practical application is to help fight the compilation problems that sometimes happens when Notes gets confused about time-stamps (Generic LSE Failure (no information), anybody?), and a sure way to work this around is to re-save the script libraries in reverse order of dependency. The diagram helps you to find out where to start.

![alt tag](https://andrewmagerman.files.wordpress.com/2015/02/final-result.png?w=1008&h=837)

Please note that the heavy lifting of the diagram generation is done by Graphviz, which you’ll need to install separately on your development machine. Graphviz is a free, open source library which does a remarkably good job of making clear diagrams based on a simple inputted text file.

The plugin itself is still somewhat rough around the edges, and I’d welcome any kind of feedback or any feature requests you might find useful.

All of this would not have been possible without the previous work of Karsten Lehmann (mindoo), René Winkelmeyer (midpoints), Ulrich Krause (BCC Consulting) and Ralf Petters (Artweger GmbH), all of whom contributed fantastic presentations and blog entries on creating Notes Plug-ins. A special thanks to Ralf, who held my hand whilst I was trying to set up the development environment for plug-in development.
