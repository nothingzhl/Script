package org.zhl;

/**
 * @author zhanghanlin
 * @date 2022/8/3
 **/
public interface Token {

    TokenTypeEnum getType();

    void setType(TokenTypeEnum tokenTypeEnum);

    String getText();

    void setText(String text);
}
