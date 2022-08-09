package org.zhl;

/**
 * @author zhanghanlin
 * @date 2022/8/3
 **/
public abstract class Token {

    private TokenTypeEnum tokenType;

    private boolean completed;

    private StringBuilder tmpSb;

    public Token() {
        this.tmpSb = new StringBuilder();
        this.completed = false;
    }

    public boolean isComplete() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getText() {
        return tmpSb.toString();
    }

    public TokenTypeEnum getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(TokenTypeEnum tokenTypeEnum) {
        this.tokenType = tokenTypeEnum;
    }

    public void addCh(char cr) {
        tmpSb.append(cr);
    }

    @Override
    public String toString() {
        return "Token{" + "tokenType=" + tokenType + ", tmpSb=" + tmpSb + '}';
    }
}
