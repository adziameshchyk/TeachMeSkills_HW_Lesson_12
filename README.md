# Files. IO streams
>This repository was created for homework in lessons №11 - "Files. IO streams".
## Tasks

### Mandatory task:  
0. Let's go back to the homework assignment for lesson number 12 and modify it.  
  The program should receive file names with document numbers from the console: each new line is the path to the file and the file name.  
  To complete the file list entry, enter 0.  
  After receiving the list of documents, the program must process each document: subtract document numbers from the file and validate them.  
  At the end of the work, create one report file with the output information: document number - comment (valid or not valid and for what reason).  
  Let each file contain each document number on a new line and no other information on the line, just the document number.  
  A valid document number must be 15 characters long and begin with the sequence docnum (hereinafter any sequence of letters/numbers) or kontract (hereinafter any sequence of letters/numbers).  
  Please note that document numbers can be repeated within the same file, and different documents can also contain the same document numbers.  
  If document numbers are repeated, then duplicate document numbers should not be checked or validated.

  Some technical details:  
  1) Read a list of documents from the console: if it’s a list, then these are collections of the List type, there are no other conditions - that means we save all the file names from the console into the ArrayList data structure.   
  2) Document numbers can be repeated, but repeated documents do not need to be processed and validated, i.e. in fact, we don’t need duplicates - this means we need to read document numbers from files and save all document numbers into a collection of the Set type. There     are no other conditions, which means you can use HashSet.  
  3) At the end there should be a structure document number - comment - i.e. This structure is of key-value type, which means it is a collection of type Map.  
   
  There are no other conditions - which means you can use HashMap. Create such a structure and then make a cycle through this structure and write all the information from this map into a report file.  

### Additional task:  
1. Let's imagine that there is no collection of type ArrayList in Java.  
   Create your own class that simulates the work of a dynamic collection class - i.e. create your custom collection.  
   The collection will be based on an array.  
   A custom collection must store elements of different classes (i.e. it is generic).   
   Provide operations for adding an element, deleting an element, getting an element by index, checking whether an element is in a collection, a method for clearing all collections.  
   Provide a parameterless constructor - creates an array of default size.  
   Provide a constructor with a specified size of the internal array.  
   Provide the ability to automatically expand the collection when adding an element in the case when the collection is already full.  
