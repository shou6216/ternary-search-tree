package com.yoshinoda.shou6216;//

import java.util.function.Consumer;

class TernaryTree {
    // 節
    // アクセスメソッドは用意しない
    private class Node {
        Integer item;
        Node left;
        Node right;

        Node(Integer x) {
            item = x;
            left = nil;
            right = nil;
        }

        // 挿入
        Node add(Integer x) {
            if (this == nil) {
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
            if (this != nil) {
                left.forEach(action);
                action.accept(item);
                right.forEach(action);
            }
        }

        // 文字列に変換
        public String toString() {
            String[] s = {""};
            forEach(x -> s[0] += x.toString() + " ");
            return s[0];
        }
    }

    // 終端
    private Node nil = new Node(null);
    // ルート
    private Node root;

    TernaryTree() {
        root = nil;
    }

    /**
     * ノードを追加します
     *
     * @param n ノード
     */
    public void add(Integer n) {
        root = root.add(n);
    }

    /**
     * 三分木を表示します。
     */
    public void showTree() {
        root.forEach(x -> System.out.print(x + " "));
    }
}