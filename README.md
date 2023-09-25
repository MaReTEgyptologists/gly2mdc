# Gly2Mdc v. 1.0
### Gly2Mdc is a tool to convert gly-files produced with JSesh (https://jsesh.qenherkhopeshef.org) to plain text files with cleaned Manuel de Codage (MdC) encoding.

The gly-files are binary-files that require a hieroglyphic text editor to open them. From JSesh it is possible to copy out the mdc coding of the text but this requires several steps and takes time. The copied text is, furthermore, cluttered with lines (instead of M17 Z7 A1 G17 O1 Z1 A1 the output is M17_-Z7_-A1_-G17_-O1_-Z1_-A1).

With **Gly2mdc v. 1.0** it is possible to extract cleaned mdc code with one command. For example:

    java -jar Gly2mdc.jar Texts/OAshm113.gly

The resulting file with the mdc will have the same name+\_gly2mdc.txt).

The folder <i>Texts</i> contains a gly-file produced with JSesh (OAshm113.gly), a file showing the content of the gly-file when parsed to string (OAshm113_glyToString), a file with copied encoding from JSesh (OAshm113_mdc.txt) and a file produced with Gly2mdc (OAshm113_gly2mdc).

Update on 22.9.2023:
Changed the extension of the mdc-file to _gly2mdc.txt so that it can be opened by any text editor. The old version is in the folder OldFiles.

TODO:
- ~~Write output to file~~
- Add option to convert several files with one command
- Handle text that has been marked as red
- Handle the white spaces in hieroglyphic text that is mdc are produced with full stops
- Handle shading of text
- Add option: output text as Unicode charaters
- Output the text in TEI file format
