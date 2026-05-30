package jlox.Scanner;
import java.util.ArrayList;


class Scanner {
    private String source;
    private final List<Token> tokens = new ArrayList<>();
    
    Scanner(String source) {
        this.source = source;
    }


}
