package com.ggs.stack;

import java.util.*;

/**
 * @Author Starbug
 * @Date 2020/9/11 16:28
 * 逆波兰表达式=>后缀表达式
 */
public class PolandNotation {

    public static void main(String[] args) {
        //先给出定义的逆波兰表达式
        //(3+4)*5-6 => (((34)+5)*)6- => 3 4 + 5 * 6 -
//        String suffixExpression = "30 4 + 5 * 6 -";

        //思路
        //1.先将表达式放入ArrayList中,按空格分割
        //2.将ArrayList配合站完成计算
//        List<String> list = getListString(suffixExpression);
//        System.out.println("list = " + list);
//
//        int result = calculate(list);
//        System.out.println("result = " + result);

        String suffixExpression = "1+((2+3)*4)-10/5+((10+5)*3)/10";
        System.out.println("中缀表达式: " + suffixExpression);
        List<String> list = toInfixExpressionList(suffixExpression);
//        System.out.println(list);

        List<String> suffixList = parseSuffixExpressionList(list);
        System.out.println("后缀表达式: " + suffixList);

        int result = calculate(suffixList);
        System.out.println("计算后缀表达式结果: " + result);
    }

    private static final Map<String, Integer> map = new HashMap<>();

    static {
        map.put("+", 1);
        map.put("-", 1);
        map.put("*", 2);
        map.put("/", 2);
    }

    private static int operPriority(String str) {
        if (map.containsKey(str)) {
            return map.get(str);
        } else {
            return -1;
        }
    }

    //中缀表达式转换成后缀表达式
    private static List<String> parseSuffixExpressionList(List<String> list) {

        List<String> parseList = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (String str : list) {
            if (str.matches("\\d+")) {
                //是数字,直接放入list中
                parseList.add(str);
            } else if (str.equals("(")) {
                //如果是左括号,放入栈中
                stack.push(str);
            } else if (str.equals(")")) {
                //如果是有括号,则从栈中一个个取出已经放入的运算符,直到遇到左括号
                while (!stack.peek().equals("(")) {
                    parseList.add(stack.pop());
                }
                //最后弹出左括号
                stack.pop();
            } else {
                //如果是+ - * / 运算符,则按照其优先级进行相应操作 priority
                int priority = operPriority(str);
                while (stack.size() != 0 && operPriority(str) <= operPriority(stack.peek())) {
                    //如果当前的运算符优先级小于等于栈顶的运算符,则将栈中的运算符弹出,parseList
                    parseList.add(stack.pop());
                }
                //将符号压入栈中
                stack.push(str);
            }
        }

        //parseList
        while (stack.size() != 0) {
            parseList.add(stack.pop());
        }

        return parseList;
    }


    //将中缀表达式转换成对应的LIst
    private static List<String> toInfixExpressionList(String suffixExpression) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < suffixExpression.length(); ) {
            if (suffixExpression.charAt(i) < 48 || suffixExpression.charAt(i) > 57) {
                //如果不是数字 0 => 48  9 => 56,直接加入集合中
                list.add(suffixExpression.charAt(i) + "");
                i++;
            } else {
                //如果是数字,需要考虑多位数的情况
                String num = "";
                //长度小于字符串的最大长度,并且是数字,则继续进行拼接
                while (i < suffixExpression.length() && suffixExpression.charAt(i) >= 48 && suffixExpression.charAt(i) <= 57) {
                    num += suffixExpression.charAt(i) + "";
                    i++;
                }
                list.add(num);
            }
        }
        return list;
    }

    //计算后缀表达式
    private static int calculate(List<String> list) {
        Stack<Integer> stack = new Stack<>();
        for (String s : list) {
            //匹配数字
            if (s.matches("\\d+")) {
                stack.push(Integer.parseInt(s));
            } else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                int result = calculateResult(num1, num2, s);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private static int calculateResult(Integer num1, Integer num2, String s) {
        int result = 0;
        switch (s) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        return result;
    }


    private static List<String> getListString(String suffixExpression) {

        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }

        return list;
    }

}
