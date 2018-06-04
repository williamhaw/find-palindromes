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

## Assumptions
1. One character substrings are palindromes.
2. Empty substrings are palindromes.
3. Repeated palindromes at different indexes should not be included in output.

## Approach
The input string is split in a top-down manner. The palindrome search checks the whole string to see if it is a palindrome,
then all substrings of input.length() - 1, input.length() - 2, and so on. The palindrome check is performed using pointers 
at the start and end of the substring, checking the characters and moving them towards the middle of the substring if they
are equal. The search skips over all previously found palindromes and terminates once it has found the nth longest palindrome.