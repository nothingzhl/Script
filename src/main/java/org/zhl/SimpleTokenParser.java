package org.zhl;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhanghanlin
 * @date 2022/8/3
 * int age = 40
 **/
public class SimpleTokenParser implements Parser {

    private CodeProvider codeProvider;

    public SimpleTokenParser(CodeProvider codeProvider) {
        this.codeProvider = codeProvider;
    }

    @Override
    public Parser parse() {

        final CharArrayReader charArrayReader = new CharArrayReader(codeProvider.provide().toCharArray());

        int ch = 0;
        // dfa 初始状态
        DFAStateEnum dfaState = DFAStateEnum.Initial;
        try {
            while ((ch = charArrayReader.read()) != -1) {
                final char tS = (char)ch;
                Token token = new SimpleToken();
                switch (dfaState) {
                    case Initial:
                        dfaState = initToken(tS, token);
                        break;
                }
            }
        } catch (Exception e) {

        }
        return this;
    }

    private DFAStateEnum initToken(char tS, Token token) {
        DFAStateEnum dfaStateEnum = DFAStateEnum.Initial;
        if (token.isComplete()) {
            return dfaStateEnum;
        }
        if (Character.isAlphabetic(tS)) {

        } else if (Character.isDigit(tS)) {

        } else if (Objects.equals('>', tS)) {

        }

        return dfaStateEnum;
    }

    enum DFAStateEnum {
        Initial,
        ID;
    }

    private static class TokenHolder {
        List<Token> tokens = new ArrayList<>(32);

        void addToken(Token token) {
            tokens.add(token);
        }

    }

}
