# MergeSort

Implementation of the Merge Sort of several presorted files with Java language.

The program can work with integers or strings and perform ascending or descending sort.

### Prerequisites:
* Java version 8 or above
* Maven version 3.5.4

### Build:
1. Download the source code.
2. Open the CLI and navigate to the MergeSort folder. 
3. Execute the following command to create an executable jar file:
    mvn clean install
4. Check the MergeSort/target folder created and contains MergeSort-1.0.jar file.

### Usage:
Use the following commands to start the program (examples are run from the MergeSort folder):
* Ascending sorting of the integer files:
    * java -jar target/MergeSort-1.0.jar -i out_int.txt int1.txt int2.txt
    * java -jar target/MergeSort-1.0.jar -i -a out_int.txt int1.txt int2.txt
* Descending sorting of the integer files:
    * java -jar target/MergeSort-1.0.jar -i -d out_int.txt int3.txt int4.txt
* Ascending sorting of the string files:
    * java -jar target/MergeSort-1.0.jar -s -a out_string.txt string1.txt string2.txt
* Descending sorting of the string files:
    * java -jar target/MergeSort-1.0.jar -s -d out_string.txt string3.txt string4.txt

### Special notes:
* The output file should be the the first file in the arguments.
* In case the output file already exist, it will be rewritten with the program execution.
* To use more than 2 files for sorting split them with space.
* The program won't sort one file passed as input argument, it will return the file as it is.

The program do not guarantee the correct work in the following situations:
* Less than 2 files are given as input parameters (one output file and one or more input files should be granted).
* No keys or incorrect keys are provided with stating command 
    * Required keys: -i for integer sort, -s for string sort
    * Optional keys: -d for descending, -a for ascending(used by default)
* Input files are empty
* Input files don't match with sorted values type
* Input files are not presorted or partly presorted (in this case program does not guarantee the correct output result)
* Input files contains fractional number instead of required ints
* Incorrect path to files
* Both alternative keys are passed (-a and -d or -s and -i)

<h6> P.S.This is a test task for CFT Java course. Please check the task at <a href="https://google.com">GoogleDrive</a></h6>