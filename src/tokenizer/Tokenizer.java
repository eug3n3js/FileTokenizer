package tokenizer;

import java.util.List;

public interface Tokenizer<T> {
    List<T> tokenize(String text);
}
