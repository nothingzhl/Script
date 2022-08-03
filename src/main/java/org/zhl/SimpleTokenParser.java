package org.zhl;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghanlin
 * @date 2022/8/3
 **/
public class SimpleTokenParser implements Parser {

    @Override
    public Parser parse(CodeProvider codeProvider) {
        final String code = codeProvider.provide();
        final CharArrayReader charArrayReader = new CharArrayReader(code.toCharArray());

        int ch = 0;
        // dfa 初始状态
        DFAStateEnum dfaState = DFAStateEnum.Initial;

        try {
            while ((ch = charArrayReader.read()) != -1) {
                final char tS = (char)ch;
                switch (dfaState) {
                    case Initial:
                        break;
                }
            }
        } catch (Exception e) {

        }
        return this;
    }

    enum DFAStateEnum {
        Initial;
    }

    private static class TokenHolder {
        List<Token> tokens = new ArrayList<>(32);

        void addToken(Token token) {
            tokens.add(token);
        }

    }

}
