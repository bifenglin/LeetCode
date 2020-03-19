package examination;

import java.util.*;

public class userType {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String userType = in.next();
            String fileModel = in.next();
            if (map.get(fileModel) == null) {
                List<String> list = new ArrayList<>();
                list.add(userType);
                map.put(fileModel, list);
            } else {
                List<String> list = map.get(fileModel);
                list.add(userType);
                map.put(fileModel, list);
            }
        }
        int j=1;
        for (String key : map.keySet()) {
            System.out.print(key);
            List<String> list = map.get(key);
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.print(" ");
                System.out.print(list.get(i));
                if (i == list.size()) {
                    System.out.println();
                }
            }
            if(j != map.size()){
                System.out.println();
                j++;
            }
        }
    }
}