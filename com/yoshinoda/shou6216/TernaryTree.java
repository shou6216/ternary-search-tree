package com.yoshinoda.shou6216;//

/**
 * 三分木を管理するクラスです
 */
class TernaryTree {
    // ルート
    private Node root = Node.NO_VALUE_LEAF;

    /**
     * ノードを追加します
     *
     * @param value ノードの値
     */
    public void add(Integer value) {
        root = root.add(value);
    }

    /**
     * 三分木を表示します。
     */
    public void showTree() {
        root.forEach(x -> System.out.print(x + " "));
    }
}