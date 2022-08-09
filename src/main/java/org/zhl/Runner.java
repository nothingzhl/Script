package org.zhl;

/**
 * @author zhanghanlin
 * @date 2022/8/9
 **/
public class Runner {
    public static void main(String[] args) {
        final SimpleTokenParser simpleTokenParser = new SimpleTokenParser(new CodeProvider() {
            @Override
            public String provide() {
                return "int age > 40";
            }
        });
        simpleTokenParser.parse();
        System.out.println(simpleTokenParser.getTokens());
    }
}
