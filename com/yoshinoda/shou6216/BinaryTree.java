package com.yoshinoda.shou6216;//
// tree.java : 二分探索木
//
//             Copyright (C) 2016-2021 Makoto Hiroi
//

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

class BinaryTree<E extends Comparable<? super E>> implements Iterable<E> {
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

    // 挿入
    public void add(E x) {
        root = root.add(x);
    }

    // 巡回
    public void forEach(Consumer<? super E> action) {
        root.forEach(action);
    }

    // イテレータ
    public Iterator<E> iterator() {
        // 無名クラス
        return new Iterator<E>() {
            {
                stack = new ArrayList<>();
                nextNode(root);
            }

            private List<Node> stack;

            private void nextNode(Node node) {
                while (node != nil) {
                    stack.add(node);
                    node = node.left;
                }
            }

            public boolean hasNext() {
                return stack.size() > 0;
            }

            public E next() {
                Node node = stack.remove(stack.size() - 1);
                nextNode(node.right);
                return node.item;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // 文字列に変換
    public String toString() {
        return "(" + root.toString().trim() + ")";
    }
}