# Find the nth largest palindromes in a given string

## Usage
Build the project by running the following command:
On Linux:
```sh
./gradlew clean fatJar
```
On Windows:
```sh
.\gradlew.bat clean fatJar
```
To run search for the three longest unique palindromes from file(only reads the first line):
```sh
java -cp build/libs/find-palindrome-all.jar com.williamhaw.palindrome.Main /path/to/text/file
```