package org.zhl;

/**
 * @author zhanghanlin
 * @date 2022/8/3
 **/
public class SimpleToken implements Token{

    private TokenTypeEnum tokenType;

    private String text;

    public SimpleToken(TokenTypeEnum tokenType, String text) {
        this.tokenType = tokenType;
        this.text = text;
    }

    public SimpleToken() {
    }

    @Override
    public TokenTypeEnum getType() {
        return null;
    }

    @Override
    public String getText() {
        return null;
    }
}
