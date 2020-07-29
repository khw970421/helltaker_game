package helltaker;

import java.util.Scanner;

public class change {
    public change(){};
    int value;
    char value1;
    change(int value)
    {
        this.value = value;
    }
    change(char value1)
    {
        this.value1=value1;
    }

    public static void change_a(int [][]map,int a,int b){
        map[a][b] = 5;
        map[a][b+1] = 1;
    }
    public static void change_w(int [][]map,int a,int b){
        map[a][b] = 5;
        map[a + 1][b] = 1;
    }
    public static void change_d(int [][]map,int a,int b){
        map[a][b] = 5;
        map[a][b-1] = 1;
    }
    public static void change_s(int [][]map,int a,int b){
        map[a][b] = 5;
        map[a - 1][b] = 1;
    }
    public static void changeskel_a(int [][]map,int a,int b){
        map[a][b] = 1;
        map[a][b-1] = 2;
    }
    public static void changeskel_w(int [][]map,int a,int b){
        map[a][b] = 1;
        map[a-1][b] = 2;
    }
    public static void changeskel_d(int [][]map,int a,int b){
        map[a][b] = 1;
        map[a][b+1] = 2;
    }
    public static void changeskel_s(int [][]map,int a,int b){
        map[a][b] = 1;
        map[a+1][b] = 2;
    }
    public static void changestone_a(int [][]map,int a,int b){
        map[a][b] = 1;
        map[a][b-1] = 3;
    }
    public static void changestone_w(int [][]map,int a,int b){
        map[a][b] = 1;
        map[a-1][b] = 3;
    }
    public static void changestone_d(int [][]map,int a,int b){
        map[a][b] = 1;
        map[a][b+1] = 3;
    }
    public static void changestone_s(int [][]map,int a,int b){
        map[a][b] = 1;
        map[a+1][b] = 3;
    }
    public static void print_map(int[][] map,int[][] map1)   //현재 map 상황 출력
    {
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.print("\t");
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map1[i][j]);
            }
            System.out.println();
        }
    }

    public static void check_key(int[][] map1,change key,int a,int b) {
        if (map1[a][b] == 2) {
            key.value = 1;
        }
    }






}
