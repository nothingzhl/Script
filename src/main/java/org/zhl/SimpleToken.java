package org.zhl;

/**
 * @author zhanghanlin
 * @date 2022/8/3
 **/
public class SimpleToken implements Token {

    private TokenTypeEnum tokenType;

    private String text;

    private boolean completed;

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
    public void setType(TokenTypeEnum tokenTypeEnum) {
        this.tokenType = tokenTypeEnum;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean isComplete() {
        return completed;
    }
}
