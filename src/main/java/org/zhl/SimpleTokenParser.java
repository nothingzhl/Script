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

    private TokenHolder tokenHolder;

    public SimpleTokenParser(CodeProvider codeProvider) {
        this.codeProvider = codeProvider;
        this.tokenHolder = new TokenHolder();
    }

    @Override
    public Parser parse() {

        final CharArrayReader charArrayReader = new CharArrayReader(codeProvider.provide().toCharArray());

        int ch = 0;
        // dfa 初始状态
        DFAStateEnum dfaState = DFAStateEnum.Initial;
        Token token = new SimpleToken();
        try {
            while ((ch = charArrayReader.read()) != -1) {
                final char tS = (char)ch;
                if (token.isComplete()) {
                    token = new SimpleToken();
                }
                switch (dfaState) {
                    case Initial:
                        dfaState = initToken(tS, token);
                        break;
                    case ID:
                        dfaState = handId(tS, token);
                        break;
                    case IntLiteral:
                        dfaState = handIntL(tS, token);
                        break;
                    case GT:
                        dfaState = initGt(tS, token);
                        break;
                    default:
                        throw new RuntimeException("解析出错");
                }
            }
            token.setCompleted(true);
            tokenHolder.addToken(token);
        } catch (Exception e) {
            System.out.println(e);
        }
        return this;
    }

    private DFAStateEnum initGt(char tS, Token token) {
        DFAStateEnum dfaStateEnum = DFAStateEnum.GT;
        if ('>' == tS) {
            token.addCh(tS);
        } else {
            dfaStateEnum = DFAStateEnum.Initial;
            token.setCompleted(true);
            tokenHolder.addToken(token);
        }
        return dfaStateEnum;
    }

    private DFAStateEnum handIntL(char tS, Token token) {
        DFAStateEnum dfaStateEnum = DFAStateEnum.IntLiteral;
        if (Character.isAlphabetic(tS)) {
            token.addCh(tS);
        } else {
            dfaStateEnum = DFAStateEnum.Initial;
            token.setCompleted(true);
            tokenHolder.addToken(token);
        }
        return dfaStateEnum;
    }

    private DFAStateEnum handId(char tS, Token token) {
        DFAStateEnum dfaStateEnum = DFAStateEnum.ID;
        if (Character.isDigit(tS)) {
            token.addCh(tS);
        } else {
            dfaStateEnum = DFAStateEnum.Initial;
            token.setCompleted(true);
            tokenHolder.addToken(token);
        }
        return dfaStateEnum;
    }

    private DFAStateEnum initToken(char tS, Token token) {
        DFAStateEnum dfaStateEnum = DFAStateEnum.Initial;

        if (token.isComplete()) {
            return dfaStateEnum;
        }

        token.addCh(tS);
        // 字母
        if (Character.isAlphabetic(tS)) {
            token.setTokenType(TokenTypeEnum.Identifier);
            dfaStateEnum = DFAStateEnum.IntLiteral;
        } else if (Character.isDigit(tS)) { // 数字
            token.setTokenType(TokenTypeEnum.ID);
            dfaStateEnum = DFAStateEnum.ID;
        } else if (Objects.equals('>', tS)) { // gt
            token.setTokenType(TokenTypeEnum.GT);
            dfaStateEnum = DFAStateEnum.GT;
        } else {
            token.setCompleted(true);
            tokenHolder.addToken(token);
        }

        return dfaStateEnum;
    }

    public List<Token> getTokens() {
        return tokenHolder.getTokens();
    }

    enum DFAStateEnum {
        Initial,
        ID,
        IntLiteral,
        GT;
    }

    private static class TokenHolder {
        List<Token> tokens = new ArrayList<>(32);

        void addToken(Token token) {
            tokens.add(token);
        }

        List<Token> getTokens() {
            return tokens;
        }
    }
}
