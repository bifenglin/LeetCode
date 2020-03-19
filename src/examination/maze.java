package examination;

import java.util.*;

/**
 * @program: LeetCode
 * @description:
 * @author: maple
 * @create: 2020-03-15 19:45
 **/
public class maze {
    private static int res = 0;
    private static Map<Integer, ArrayList<Integer[]>> map = new HashMap();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int w = in.nextInt();
        int[][] tab=new int[w][h];
        int startX= 0;
        int startY= 0;
        for (int i=0; i<w;i++) {
            for (int j = 0; j < h; j++) {
                int temp = in.nextInt();
                tab[i][j] = temp;
                if (temp == -2){
                    startX = i;
                    startY = j;
                }
                if (temp>1){
                    ArrayList<Integer[]> list = new ArrayList();
                    Integer[] integers = new Integer[2];
                    integers[0]=i;
                    integers[1]=j;
                    if (map.get(temp) == null){
                        list.add(integers);
                        map.put(temp,list);
                    } else {
                        list = map.get(temp);
                        list.add(integers);
                        map.put(temp, list);
                    }
                }
            }
        }
        dfs(tab, startX, startY, 0);
        System.out.print(res);

    }

    public static void dfs(int[][] tab, int x, int y,int step){
        // 越界
        if (x <0 || x>=tab.length || y < 0|| y>=tab[0].length){
            return;
        }
        // 如果终点返回
        if (tab[x][y] == -3){
            res = Math.max(res, step);
            return;
        }
        // 不通过或者已经走过
        if (tab[x][y] == -1 || tab[x][y] == -4 || tab[x][y]==-2){
            return ;
        }
        // 传送
        if(tab[x][y] > 1){
            List<Integer[]> list = map.get(tab[x][y]);
            if (list.get(0)[0]==x&& list.get(0)[1]==y){
                x=list.get(1)[0];
                y=list.get(1)[1];
            }else {
                x=list.get(0)[0];
                y=list.get(0)[1];
            }
        }
        tab[x][y] = -4;
        dfs(tab, x+1, y, step+1);
        dfs(tab, x, y+1,step+1);
        dfs(tab, x-1, y,step+1);
        dfs(tab, x, y-1,step+1);
        return;
    }
}
