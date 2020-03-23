package examination;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-03-22 19:55
 **/
public class shoujihaojiazhi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] in = line.split(",");
        PhoneNumber[] arr = shoujihaojiazhi(in);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i].phone).append(",");
        }
        if (stringBuilder.length() == 0){
            System.out.print("null");
        } else {
            System.out.print(stringBuilder.deleteCharAt(stringBuilder.length() - 1));
        }
    }

    static class myComparator implements Comparator<PhoneNumber> {
        @Override
        public int compare(PhoneNumber o1, PhoneNumber o2) {
            if (o1.value > o2.value) {
                return -1;
            } else if (o1.value == o2.value) {
                return o2.type - o1.type;
            }
            return 0;
        }
    }

    static class PhoneNumber {
        String phone;
        int value;
        int type; // 0代表顺子 1代表豹子
    }

    static PhoneNumber[] shoujihaojiazhi(String[] in) {
        List<PhoneNumber> list = new ArrayList<>();
        PhoneNumber phoneNumber;
        for (int i = 0; i < in.length; i++) {
            phoneNumber = getValue(in[i]);
            if (phoneNumber != null) {
                list.add(phoneNumber);
            }
        }
        PhoneNumber[] arr = new PhoneNumber[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr, new myComparator());
        return arr;
    }

    static PhoneNumber getValue(String s) {
        if (s.length() >11){
            return null;
        }
        int type = 0;
        int value = 0;
        int temp = 1;
        // 升序
        for (int i = 4; i < s.length(); i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                temp++;
            } else {
                value = Math.max(value, temp);
                temp = 1;
            }
        }
        value = Math.max(value, temp);
        temp = 1;
        // 降序
        for (int i = 4; i < s.length(); i++) {
            if (s.charAt(i) - s.charAt(i - 1) == -1) {
                temp++;
            } else {
                value = Math.max(value, temp);
                temp = 1;
            }
        }
        value = Math.max(value, temp);
        temp = 1;
        // 豹子
        for (int i = 4; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                temp++;
            } else {
                if (temp > value) {
                    type = 1;
                }
                value = Math.max(value, temp);
                temp = 1;
            }
        }
        if (temp > value) {
            type = 1;
        }
        value = Math.max(value, temp);
        if (value >= 3) {
            PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.phone = s;
            phoneNumber.type = type;
            phoneNumber.value = value;
            return phoneNumber;
        }
        return null;
    }


}
