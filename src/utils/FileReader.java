package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {
    public static String readFile(String fileName) throws IOException {
        Path path = Paths.get(fileName).toRealPath();
        if (!Files.exists(path)){
            throw new FileNotFoundException();
        }
        return Files.readString(path);
    }

    public static List<String> findAllTxt(String dirName) throws IOException {
        Path path = Paths.get(dirName).toRealPath();
        if (!Files.exists(path) || !Files.isDirectory(path) || dirName.equals("")){
            throw new FileNotFoundException();
        }
        List<String> fileNames = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(path)) {
            paths.filter(Files::isRegularFile).filter(file -> checkIfTxt(file.toString())).forEach(file -> fileNames.add(file.toString()));
        } catch (IOException e){
            throw new IOException(e);
        }
        return fileNames;
    }

    public static String getAbsolutePath(String fileName){
        return Paths.get(fileName).toAbsolutePath().toString();
    }

    public static Boolean checkIfTxt(String fileName){
        return fileName.endsWith(".txt");
    }

    public static Boolean checkIfDir(String dirName){
        return Files.isDirectory(Paths.get(dirName));
    }

    public static Boolean checkIfFile(String fileName){
        return Files.isRegularFile(Paths.get(fileName));
    }
}
