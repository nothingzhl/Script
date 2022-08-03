package org.zhl;

import java.io.CharArrayReader;

/**
 * @author zhanghanlin
 * @date 2022/8/3
 **/
public class SimpleTokenParser implements Parser {

    private SimpleTokenParser() {
    }

    public static SimpleTokenParser getInstance() {
        return SimpleTokenParserHolder.INSTANCE;
    }

    @Override
    public Token parse(CodeProvider codeProvider) {
        final String code = codeProvider.provide();
        final CharArrayReader charArrayReader = new CharArrayReader(code.toCharArray());

        int ch = 0;
        try {
            while ((ch = charArrayReader.read())!=-1) {

            }
        }catch (Exception e){

        }
        return null;
    }

    private static class SimpleTokenParserHolder {
        static final SimpleTokenParser INSTANCE = new SimpleTokenParser();
    }

}
