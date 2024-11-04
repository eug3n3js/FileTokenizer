package uinterface;

import indexer.Indexer;
import tokenizer.Tokenizer;
import utils.FileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ConsoleInterface<T> {
    private final Indexer<T> indexer;
    private final Scanner scanner;

    public ConsoleInterface(Tokenizer<T> tokenizer){
        indexer = new Indexer<>(tokenizer);
        scanner = new Scanner(System.in);
    }

    private void processAddFileOrDir(String dirName){
        if (FileReader.checkIfDir(dirName)){
            List<String> fileNames;
            try {
                fileNames = FileReader.findAllTxt(dirName);
            } catch (IOException e){
                if (e instanceof FileNotFoundException){
                    System.out.println("Dir you entered not found");
                } else {
                    System.out.println("Can't find txt files from this dir");
                }
                return;
            }
            int failCounter = 0;
            for (var fileName: fileNames){
                String fileText;
                try {
                    fileText = FileReader.readFile(fileName);
                } catch (IOException e){
                    System.out.println("Can't open file: " + fileName);
                    failCounter++;
                    continue;
                }
                indexer.processText(fileText, fileName);
            }
            System.out.println("Tokenized: " + (fileNames.size() - failCounter) + " files out of: " + fileNames.size());
        } else if (FileReader.checkIfFile(dirName)) {
            if (FileReader.checkIfTxt(dirName)){
                String fileText;
                try {
                    fileText = FileReader.readFile(dirName);
                } catch (IOException e){
                    if (e instanceof FileNotFoundException){
                        System.out.println("File you entered not found");
                    } else {
                        System.out.println("Can't open this file");
                    }
                    return;
                }
                dirName = FileReader.getAbsolutePath(dirName);
                indexer.processText(fileText, dirName);
                System.out.println("File tokenized successfully");
            } else {
                System.out.println("File you entered is not txt");
            }
        } else {
            System.out.println("Your input is not dir nor file");
        }
    }

    private void processSearch(String word){
        List<String> fileNames = indexer.findMatches(word);
        if (fileNames.size() == 0){
            System.out.println("No results.");
        } else {
            System.out.println("Found " + fileNames.size() + " results");
        }
        for(var fileName: fileNames){
            System.out.println(fileName);
        }
    }

    public void processUserInput(){
        while(true){
            System.out.println("Enter 1 to tokenize file or dir.\nEnter 2 to search files for a specific word.\nEnter 3 to exit.");
            String action = scanner.nextLine();
            switch (action) {
                case "1" -> {
                    System.out.println("Enter file or directory absolute path / relative path in project folder");
                    processAddFileOrDir(scanner.nextLine());
                }
                case "2" -> {
                    System.out.println("Enter word to search");
                    processSearch(scanner.nextLine());
                }
                case "3" -> {
                    return;
                }
                default -> System.out.println("Incorrect user input");
            }
        }
    }
}
