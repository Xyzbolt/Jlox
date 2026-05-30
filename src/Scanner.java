import java.util.ArrayList;
import static TokenType.*;


class Scanner {
    private String source;
    private final List<Token> tokens = new ArrayList<>();
    
    Scanner(String source) {
        this.source = source;
    }
}
