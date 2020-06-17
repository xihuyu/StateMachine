package com.data;

import java.util.Stack;

/**
 * @version V1.0
 * @description: 括号匹配， 比如
 * 比如
 * <1>{[{}]} 返回true
 * <2>{[{}} 返回false
 *
 * @author: fenggaopan
 * @date: 2020-06-16 13:38:11
 */
public class BracketMatching {
    public static void main(String[] args) {
        String phrase = "{[()]}";
        System.out.println(matchPhrase(phrase));
    }

    /**
     * 校验字符串是否合法
     * @param phrase 字符串
     * @return 返回结果
     */
    public static boolean matchPhrase(String phrase) {
        Stack<Character> phraseStack = new Stack<>();
        char[] phraseChars = phrase.toCharArray();
        for(char c : phraseChars) {
            if(c == '[' || c == '{' || c == '(') {
                phraseStack.push(c);
            }
            //获取最上面的元素
            Character cc = phraseStack.peek();
            if((cc == '{' && '}' == c) || (cc == '[' &&']' == c) || (cc == '(' && ')' == c))  {
                phraseStack.pop();
            }
        }
        return phraseStack.isEmpty();
    }
}
