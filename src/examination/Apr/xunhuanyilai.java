package examination.Apr;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-04-01 19:58
 **/
public class xunhuanyilai {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashMap<String, String> map = new HashMap<>();
        while (!s.contains("search head file")){
            String[] temp = s.split(":");
            map.put(temp[0],temp[1]);
            s = scanner.nextLine();
        }
        String find = s.split(":")[1];
        List<List<String>> res = new ArrayList<>();
        List<String> list = new LinkedList<>();
        list.add(find);
        String path = map.get(find);
        boolean flag = false;
        HashSet<String> set = new HashSet();

        while (path != null){
            if (path.equals(find) || set.contains(path)){
                List tempList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals(path)){
                        tempList.add(list.subList(i, list.size()));
                        res.add(tempList);
                    }
                }
                flag = true;
                if (path.equals(find))
                    break;
            }
            list.add(path);
            set.add(path);
            path = map.get(path);
        }
        if (flag){
            System.out.println("Bad coding -- loop include as bellow:");
            for (int i = 0; i < res.size(); i++) {
                List<String> tempList = res.get(i);
                for (int j = 0; j < tempList.size(); j++) {
                    String tempList1 = tempList.get(i);
//                    for (int k = 0; k < tempList1.size(); k++) {
//                        System.out.print(tempList1.get(k) + " ");
//                    }
                }
                System.out.println();
            }
            System.out.println();
        } else {
            System.out.println("none loop include "+find);
        }

    }
}
