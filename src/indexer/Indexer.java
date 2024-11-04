package indexer;

import tokenizer.Tokenizer;

import java.util.*;

public class Indexer<T> {
    final private Tokenizer<T> tokenizer;
    final private Map<T, Set<String>> fileIndexer;

    public Indexer(Tokenizer<T> tokenizer){
        this.tokenizer = tokenizer;
        fileIndexer = new HashMap<>();
    }

    public void processText(String text, String filename){
        List<T> tokens = tokenizer.tokenize(text);
        tokens.forEach(token -> fileIndexer.computeIfAbsent(token, k -> new HashSet<>()).add(filename));
    }

    public List<String> findMatches(String word){
        List<T> tokens = tokenizer.tokenize(word);
        if (tokens.size() < 1){
            return List.of();
        }
        if (tokens.size() > 1){
            return List.of();
        }
        return new ArrayList<>(fileIndexer.getOrDefault(tokens.get(0), new HashSet<>()));
    }
}
