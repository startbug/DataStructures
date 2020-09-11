package com.ggs.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Starbug
 * @Date 2020/9/10 16:23
 */
public class Calculator {

    public static void main(String[] args) {

        //需要两个栈,一个符号栈,一个数栈
        CalculatorLinkedStack numStack = new CalculatorLinkedStack();
        CalculatorLinkedStack operStack = new CalculatorLinkedStack();

        //1.遍历表达式,获取每一个字符
        String expression = "900-64/16+7*2-90/3+6";
        //2.得到一个符号后,判断是字符还是数字
        for (int i = 0; i < expression.length(); i++) {
            Character val = expression.charAt(i);
            //3.如果是数字,则直接进入数栈
            if (!CalculatorLinkedStack.isOper(val)) {
                //数字
//                numStack.push(Integer.parseInt(val.toString()));
                int index = i;
//                char indexNum = expression.charAt(index);
                //如果下一个还是数字,则拼接完整后再放入数栈中
                if (index < expression.length()-1 && !CalculatorLinkedStack.isOper(expression.charAt(index + 1))) {
                    //如果下一个字符也是数字,则继续拼接

                    StringBuilder sb = new StringBuilder(val.toString());
                    while (!CalculatorLinkedStack.isOper(expression.charAt(++index))) {
                        Character numIndex = expression.charAt(index);
                        sb.append(numIndex);
                    }
                    numStack.push(Integer.parseInt(sb.toString()));
                    i=index-1;
                } else {
                    //如果不是数字,则直接放入数栈中
                    numStack.push(Integer.parseInt(val.toString()));
                }
//                if (!CalculatorLinkedStack.isOper(indexNum)) {
//                    StringBuilder stringBuilder = new StringBuilder();
//                    while (true) {
//
//                    }
//                } else {
//                    //如果下一个是符号,跳出该层循环
//                    break;
//                }
            } else {
                //4.如果是符号,则分情况操作
                //操作符
                if (operStack.isEmpty()) {
                    //如果符号栈为空,则直接放入
                    operStack.push(val);
                } else {
                    //4.1如果优先级大于当前栈顶的操作符,则直接入栈
                    //4.2如果当前符号优先级小于或等于栈中的操作符,则先不放入,
                    // 先取出该符号,再从数栈中取出两个数,先取出的num1,后取出的num2 => num2 操作符 num1
                    //得到的结果再放入到数栈中
                    if (operStack.peek() == null || CalculatorLinkedStack.priority(val) > CalculatorLinkedStack.priority((char) operStack.peek().value)) {
                        //新的操作符比符号栈顶的操作符优先级大,直接放入符号栈
                        operStack.push(val);
                    } else {
                        //新的操作符比符号栈顶的操作符优先级小,进行运算,将运算结果放入数栈中,然后再将新的符号放入符号栈中
                        CalculatorLinkedStack.calculateAndPush(operStack, numStack);
                        //运算后,如果发现下一个符号是负号(-),则 需要继续计算,算到下一个符号不是符号位置
                        while (true) {
                            if (operStack.peek() != null && '-' == operStack.peek().value) {
                                CalculatorLinkedStack.calculateAndPush(operStack, numStack);
                            } else {
                                break;
                            }
                        }
                        operStack.push(val);
                    }
                }
            }
        }

        //5.当扫描完毕后,按照顺序从数栈和符号栈中pop数据,进行运算
        while (true) {
            //如果符号栈为空,则表示已经得出结果,运算结束
            if (operStack.isEmpty()) {
                break;
            }
            CalculatorLinkedStack.calculateAndPush(operStack, numStack);
        }
        //6.当数栈中只有一个数(或者符号栈为空时),这就是结果
        int result = numStack.pop();
        System.out.println("result = " + result);

    }
}

class CalculatorLinkedStack {

    private CalculatorLinkedNode top;

    private static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('*', 1);
        map.put('/', 1);
        map.put('+', 0);
        map.put('-', 0);
    }

    public CalculatorLinkedNode peek() {
        return top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public CalculatorLinkedStack push(int num) {
        CalculatorLinkedNode node = new CalculatorLinkedNode(num);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
        return this;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空,无法获取数据");
        }
        CalculatorLinkedNode popNode = top;
        top = top.next;
        return popNode.value;
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈空,无法获取数据");
        }
        CalculatorLinkedNode temp = top;
        while (true) {
            System.out.println("temp = " + temp);
            temp = temp.next;
            if (temp == null) {
                break;
            }
        }
    }

    //判断操作符的优先级,自定义:数字越大,优先级越高
    // * / 优先级: 1
    // + - 优先级: 0
    //其他的优先级为: -1
    public static int priority(Character oper) {
        char key = (char) oper;
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return -1;
        }
    }

    //判断一个字符是不是算术运算符
    public static boolean isOper(char val) {
        return '*' == val || '/' == val || '+' == val || '-' == val;
    }

    //运算
    public static int calculate(int num1, int num2, int oper) {
        int result = 0;
        switch (oper) {
            case '*':
                result = num2 * num1;
                break;
            case '/':
                result = num2 / num1;
                break;
            case '+':
                result = num2 + num1;
                break;
            case '-':
                result = num2 - num1;
                break;
        }
        return result;
    }


    public static void calculateAndPush(CalculatorLinkedStack operStack, CalculatorLinkedStack numStack) {
        int oper = operStack.pop();
        int num1 = numStack.pop();
        int num2 = numStack.pop();
        int result = CalculatorLinkedStack.calculate(num1, num2, oper);
        numStack.push(result);
    }
}

class CalculatorLinkedNode {

    public int value;
    public CalculatorLinkedNode next;

    @Override
    public String toString() {
        return "CalculatorLinkedNode{" +
                "value=" + value +
                '}';
    }

    public CalculatorLinkedNode(int value) {
        this.value = value;
    }
}
