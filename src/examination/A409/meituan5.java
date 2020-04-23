package examination.A409;

/**
 * @program: LeetCode
 * @description: 字典树
 * @author: maple
 * @create: 2020-04-09 20:56
 **/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class meituan5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        String[] strs = temp.split(" ");
        int n = Integer.valueOf(strs[0]);
        int k = Integer.valueOf(strs[1]);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int n = 9;
//        int k = 3;

        // 子串
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String word = sc.nextLine();
            words.add(word);
        }

        // 设置flag，防止重复添加或删除
        boolean[] flag = new boolean[k];
        Arrays.fill(flag, true);

        // 构建 Trie
        TrieNode root = BuildTrie(words);

        for (int i = 0; i < n; i++) {
            String op = sc.nextLine();
            if (op.charAt(0) == '+') {
                int index = Integer.valueOf(op.substring(1)) - 1;
                if (flag[index] == false) {
                    flag[index] = true;
                    addWord(words.get(index), root);
                }
            } else if (op.charAt(0) == '-') {
                int index = Integer.valueOf(op.substring(1)) - 1;
                if (flag[index] == true) {
                    flag[index] = false;
                    deleteWord(words.get(index), root);
                }
            } else if (op.charAt(0) == '?') {
                String str = op.substring(1);
                int ans = 0;
                for (int j = 0; j < str.length(); j++) {
                    TrieNode p = root;
                    for (int kk = j; kk < str.length(); kk++) {
                        int index = str.charAt(kk) - 'a';
                        if (p.next[index] != null) {
                            ans += p.next[index].leaf;
                            p = p.next[index];
                        } else {
                            break;
                        }
                    }
                }
                System.out.println(ans);
            }
        }
    }

    private static TrieNode BuildTrie(ArrayList<String> words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (p.next[index] == null) {
                    p.next[index] = new TrieNode();
                }
                p = p.next[index];
            }
            p.leaf++;
        }
        return root;
    }

    private static void addWord(String word, TrieNode root) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.next[index] == null) {
                p.next[index] = new TrieNode();
            }
            p = p.next[index];
        }
        p.leaf++;
    }

    private static void deleteWord(String word, TrieNode root) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.next[index] == null) {
                return;
            }
            p = p.next[index];
        }
        p.leaf--;
    }
}

class TrieNode {
    TrieNode[] next;
    int leaf;

    TrieNode() {
        leaf = 0;
        next = new TrieNode[26];
        Arrays.fill(next, null);
    }
}