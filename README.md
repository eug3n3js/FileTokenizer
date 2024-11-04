
# Text File Indexing Service

## Usage


Once the application is running, the console interface provides three options:

1. **Tokenize file or directory**: Indexes text files by specifying either a file path or a directory path.
2. **Search for a word**: Queries indexed files to list those containing a specific word.
3. **Exit**: Terminates the application.

### Example Usage

Here’s a sample session demonstrating the basic functionality.

#### 1. Index a File or Directory
To index a text file or all text files in a directory:

```plaintext
Enter 1 to tokenize file or dir.
Enter 2 to search files for a specific word.
Enter 3 to exit.
1
Enter file or directory absolute path / relative path in project folder
files/lorem1.txt
File tokenized successfully
```

```plaintext
Enter 1 to tokenize file or dir.
Enter 2 to search files for a specific word.
Enter 3 to exit.
1
Enter file or directory absolute path / relative path in project folder
files
Tokenized: 2 files out of: 2
```

#### 2. Search for Files Containing a Specific Word
After indexing, you can search for files containing a word:

```plaintext
Enter 1 to tokenize file or dir.
Enter 2 to search files for a specific word.
Enter 3 to exit.
2
Enter word to search
Lorem
Found 1 result:
C:\Users\user\IdeaProjects\FileTokenizer\files\lorem1.txt
C:\Users\user\IdeaProjects\FileTokenizer\files\lorem2.txt
```

#### 3. Exit the Program
```plaintext
Enter 1 to tokenize file or dir.
Enter 2 to search files for a specific word.
Enter 3 to exit.
3

Process finished with exit code 0
```


