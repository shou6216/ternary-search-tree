package com.yoshinoda.shou6216;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        List<Integer> nums = IntStream.rangeClosed(1, 2000)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(nums);
        System.out.println(nums);
        for (int n : nums) {
            binaryTree.add(n);
        }
        binaryTree.showTree(x -> System.out.print(x + " "));
    }
}
