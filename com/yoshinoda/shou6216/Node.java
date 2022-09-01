package com.yoshinoda.shou6216;

import java.util.function.Consumer;

/**
 * 木構造のノードを表すクラスです
 */
public class Node {

    public static final Node NO_VALUE_LEAF = new Node(null);
    private Integer item;
    private Node left;
    private Node right;

    public Node(Integer x) {
        item = x;
        left = NO_VALUE_LEAF;
        right = NO_VALUE_LEAF;
    }

    // 挿入
    Node add(Integer x) {
        if (this == NO_VALUE_LEAF) {
            return new Node(x);
        } else {
            int r = x.compareTo(item);
            if (r < 0)
                left = left.add(x);
            else if (r > 0)
                right = right.add(x);
            return this;
        }
    }

    // 巡回
    void forEach(Consumer<Integer> action) {
        if (this != NO_VALUE_LEAF) {
            left.forEach(action);
            action.accept(item);
            right.forEach(action);
        }
    }

    // 文字列に変換
    public String toString() {
        System.out.println("aaa");
        String[] s = {""};
        forEach(x -> s[0] += x.toString() + " ");
        return s[0];
    }
}