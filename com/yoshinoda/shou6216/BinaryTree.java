package com.yoshinoda.shou6216;//
// tree.java : 二分探索木
//
//             Copyright (C) 2016-2021 Makoto Hiroi
//

import java.util.function.Consumer;

class BinaryTree<E extends Comparable<? super E>> {
    // 節
    // アクセスメソッドは用意しない
    private class Node {
        E item;
        Node left;
        Node right;

        Node(E x) {
            item = x;
            left = nil;
            right = nil;
        }

        // 挿入
        Node add(E x) {
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
        void forEach(Consumer<? super E> action) {
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

    BinaryTree() {
        root = nil;
    }

    /**
     * ノードを追加します
     *
     * @param n ノード
     */
    public void add(E n) {
        root = root.add(n);
    }

    /**
     * 三分木を表示します。
     *
     * @param action
     */
    public void showTree(Consumer<? super E> action) {
        root.forEach(action);
    }
}