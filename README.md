# gly2mdc
Gly2mdc is a tool to convert gly-files produced with JSesh to plain text files with Manuel de Codage (mdc) encoding

The .gly-files produced with for example JSesh are binary-files that require a hieroglyphic text editor to open them. From JSesh it is possible to copy out the mdc coding of the text but this takes several clicks and manually inserting the copied text to a text file.

With Gly2mdc it is possible to extract the mdc code to a text file with one command. For example:

    java -jar Gly2mdc.jar Texts/OAshm113.gly
