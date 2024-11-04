package tokenizer;

import java.util.List;

public class  SimpleTokenizerImpl implements Tokenizer<String> {

    @Override
    public List<String> tokenize(String text) {
        return List.of(text.split("\\s+"));
    }
}
