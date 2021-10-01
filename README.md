# gly2mdc
Gly2mdc is a tool to convert gly-files produced with JSesh to plain text files with Manuel de Codage (mdc) encoding

The .gly-files produced with for example JSesh are binary-files that require a hieroglyphic text editor to open them. From JSesh it is possible to copy out the mdc coding of the text but this takes several steps and takes time.

With Gly2mdc it is possible to extract the mdc code with one command. For example:

    java -jar Gly2mdc.jar Texts/OAshm113.gly

The folder <i>Texts</i> contains a gly-file produced with JSesh (OAshm113.gly), a file with copied encoding of the text (OAshm113.mdc) and a file produced with Gly2mdc (OAshm113_)

TODO:
- Write output to file
- Add option: output text as Unicode charaters
