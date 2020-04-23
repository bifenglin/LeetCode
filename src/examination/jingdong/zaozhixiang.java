//package examination.jingdong;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// * @program: LeetCode
// * @description:
// * @author: maple
// * @create: 2020-04-18 19:46
// **/
//public class zaozhixiang {
//    /*请完成下面这个函数，实现题目要求的功能
//当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
//******************************开始写代码******************************/
//    static boolean getResult(int[][] A) {
//        int n = A.length;
//
//        for (int i = 0; i < n; i++) {
//            if (A[i][0] > A[i][1]) {
//                int temp = A[i][0];
//                A[i][0] = A[i][1];
//                A[i][1] = temp;
//            }
//        }
//        // 统计边的数量
//        Map<int[][], Integer> mm = new HashMap<>();
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < 2; j++) {
//                Integer b = mm.get(A[i][j]);
//                b ++;
//            }
//        }
////
////        if (mm.size() > 3) return false;
////        if (mm.size() == 1) {  //正方体
////            Integer a = mm.get(0);
////            return a == 6 && mm[0] == it->first.second;
////        }
////        if (mm.size() == 2) {
////            auto first = mm.begin();
////            auto second = mm.begin();
////            ++second;
////            if (first->second == 4 && second->second == 2) {
////                int a1 = first->first.first;
////                int a2 = first->first.second;
////                int b1 = second->first.first;
////                int b2 = second->first.second;
////                if (b1 == b2 && (b1 == a1 || b1 == a2)) return true;
////                return false;
////            } else if (first->second == 2 && second->second == 4) {
////                int a1 = first->first.first;
////                int a2 = first->first.second;
////                int b1 = second->first.first;
////                int b2 = second->first.second;
////                if (a1 == a2 && (a1 == b1 || a1 == b2)) return true;
////                return false;
////            } else {
////                return false;
////            }
////        }
////        if (mm.size() == 3) {
////            for (auto it : mm) {
////                if (it.second != 2) return false;  // 每种类型的边出现2次
////                if (it.first.first == it.first.second) return false;  // 不能相等
////            }
////            // 统计点出现的次数
////            map<int, int> m2;
////            for (auto it : mm) {
////                m2[it.first.first]++;
////                m2[it.first.second]++;
////            }
////            // 必须3个点
////            if (m2.size() != 3) return false;
////            // 每个点数量必须是2
////            for (auto it : m2) {
////                if (it.second != 2) return false;
////            }
////            return true;
////        }
//
//        Map map = new HashMap();
////        for (int i = 0; i < a.length; i++) {
//
//        }
//        return false;
//    }
//    /******************************结束写代码******************************/
//
//
//    public static void main(String[] args){
////        int T;
////        cin >> T;
////        while (T--) {
////            vector<pair<int, int>> A(6);
////            for (int i = 0; i < 6; ++i) cin >> A[i].first >> A[i].second;
////            cout << (solve(A) ? "POSSIBLE" : "IMPOSSIBLE") << endl;
////        }
////        return 0;
//
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        boolean res;
//        for (int i = 0; i < n; i++) {
//            int[][] a = new int[6][2];
//            for (int j = 0; j < 6; j++) {
//                for (int k = 0; k < 2; k++) {
//                    a[j][k] = in.nextInt();
//                }
//            }
//            res = getResult(a);
//            if (res){
//                System.out.println("POSSIBLE");
//            } else {
//                System.out.println("IMPOSSIBLE");
//            }
//        }
//
////        res = ();
////        System.out.println(String.valueOf(res ? 1 : 0));
//    }
//}
