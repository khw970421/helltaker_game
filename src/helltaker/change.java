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
    public static void print_map(int[][] map)   //현재 map 상황 출력
    {
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[0].length; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
    }

    public static void check_key(int[][] map1,change key,int a,int b) {
        if (map1[a][b] == 2) {
            key.value = 1;
        }
    }

    public static void start(int[][] map,int[][] map1,change success,change chance,change key, change message, change a, change b, change target_a,change target_b ){
        Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
        do {
            System.out.println("AWSD 중 하나의 방향 메시지를 입력하세요:");

            message.value1 = scan.next().charAt(0);           // 키보드 문자 입력

            if (message.value1 == 'a'||message.value1=='A') {   //A 혹은 a를 눌렀을때 반응
                b.value--;
                chance.value--;
                if(map[a.value][b.value]==0) {          //막혀있으면 못가게 그위치에서 원상복귀
                    chance.value++;
                    b.value++;
                }
                else if(map[a.value][b.value]==9){      //자물쇠이면
                    if(key.value!=1){                   //key가 없으면 원상복귀
                        chance.value++;
                        b.value++;
                    }
                    else{                               //key가 있으면 자물쇠열고 그위치로 옮기기
                        change_a(map,a.value,b.value);
                    }
                }
                else if(map[a.value][b.value]==2){
                    if(map[a.value][b.value-1]==1){
                        changeskel_a(map,a.value,b.value);
                    }
                    else{
                        map[a.value][b.value]=1;        //막혀있다면 해골부수기
                    }
                    b.value++;
                }
                else if(map[a.value][b.value]==3){
                    if(map[a.value][b.value-1]==1) {
                        changestone_a(map, a.value, b.value);
                    }
                    b.value++;
                }
                else {
                    if(map1[a.value][b.value]==1){      //덫을 밟으면 하나더 감소
                        chance.value--;
                    }
                    check_key(map1,key,a.value,b.value);
                    change_a(map,a.value,b.value);
                }
            }

            else if (message.value1 == 'w'||message.value1=='W') {      //w 혹은 W 눌렀을때 반응
                a.value--;
                chance.value--;
                if(map[a.value][b.value]==0){
                    chance.value++;
                    a.value++;
                }
                else if(map[a.value][b.value]==9){
                    if(key.value!=1){
                        chance.value++;
                        a.value++;
                    }
                    else{
                        change_w(map,a.value,b.value);
                    }
                }
                else if(map[a.value][b.value]==2){
                    if(map[a.value-1][b.value]==1){
                        changeskel_w(map,a.value,b.value);
                    }
                    else{
                        map[a.value][b.value]=1;        //막혀있다면 해골부수기
                    }
                    a.value++;
                }
                else if(map[a.value][b.value]==3){
                    if(map[a.value-1][b.value]==1) {
                        changestone_w(map, a.value, b.value);
                    }
                    a.value++;
                }
                else {
                    if(map1[a.value][b.value]==1){
                        chance.value--;
                    }

                    check_key(map1,key,a.value,b.value);
                    change_w(map,a.value,b.value);
                }
            }

            else if (message.value1 == 'd'||message.value1=='D') {      //d 혹은 D를 눌렀을때 반응
                b.value++;
                chance.value--;
                if(map[a.value][b.value]==0){
                    chance.value++;
                    b.value--;
                }
                else if(map[a.value][b.value]==9){
                    if(key.value!=1){
                        chance.value++;
                        b.value--;
                    }
                    else{
                        change_d(map,a.value,b.value);
                    }
                }
                else if(map[a.value][b.value]==2){
                    if(map[a.value][b.value+1]==1){
                        changeskel_d(map,a.value,b.value);
                    }
                    else{
                        map[a.value][b.value]=1;        //막혀있다면 해골부수기
                    }
                    b.value--;
                }
                else if(map[a.value][b.value]==3){
                    if(map[a.value][b.value+1]==1) {
                        changestone_d(map, a.value, b.value);
                    }
                    b.value--;
                }
                else {
                    if(map1[a.value][b.value]==1){
                        chance.value--;
                    }
                    check_key(map1,key,a.value,b.value);
                    change_d(map,a.value,b.value);
                }
            }

            else if (message.value1 == 's'||message.value1=='S') {  //s 혹은 S를 눌렀을때 반응
                a.value++;
                chance.value--;
                if(map[a.value][b.value]==0){
                    chance.value++;
                    a.value--;
                }
                else if(map[a.value][b.value]==9){
                    if(key.value!=1){
                        chance.value++;
                        a.value--;
                    }
                    else{
                        change_s(map,a.value,b.value);
                    }
                }
                else if(map[a.value][b.value]==2){
                    if(map[a.value+1][b.value]==1){
                        changeskel_s(map,a.value,b.value);
                    }
                    else{
                        map[a.value][b.value]=1;        //막혀있다면 해골부수기
                    }
                    a.value--;
                }
                else if(map[a.value][b.value]==3){
                    if(map[a.value+1][b.value]==1) {
                        changestone_s(map, a.value, b.value);
                    }
                    a.value--;
                }
                else {
                    if(map1[a.value][b.value]==1){
                        chance.value--;
                    }
                    check_key(map1,key,a.value,b.value);
                    change_s(map,a.value,b.value);
                }
            }

            else{                                                                   //그외에 반응
                System.out.println("정상적 방향을 입력하세요");
            }

            print_map(map);                                                         //현재 map 상황 출력

            //주인공이 도착했을때
            if (map[target_a.value-1][target_b.value] - 1 == 4)
                success.value = 1;
            if (map[target_a.value+1][target_b.value] - 1 == 4)
                success.value = 1;
            if (map[target_a.value][target_b.value-1] - 1 == 4)
                success.value = 1;
            if (map[target_a.value][target_b.value+1] - 1 == 4)
                success.value = 1;



            System.out.println("남은 횟수: "+chance.value);
            System.out.println("key.value: "+key.value);
            if(chance.value<0){
                System.out.println("fail");
                break;
            }
        }
        while(success.value==0);                //1이되면 성공이니 더할필요없지
    }


    public static void start_round1(){
        int [][] map= {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,1,5,0,0},{0,0,1,1,2,1,1,0,0},{0,0,1,2,1,2,0,0,0},{0,1,1,0,0,0,0,0,0},{0,1,3,1,1,3,1,0,0},{0,1,3,1,3,1,1,4,0},{0,0,0,0,0,0,0,0,0}};
        int [][] map1= {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};
        change success = new change(0);
        change chance = new change(23);
        change key = new change(0);
        change message= new change('a');

        change a = new change(1);
        change b = new change(6);
        change target_a = new change(6);
        change target_b = new change(7);


        print_map(map);                             //현재 map 상황 출력

        start(map,map1,success,chance,key,message,a,b,target_a,target_b );
        if(success.value==1)
            System.out.println("success");
    }

    public static void start_round2(){
        int [][] map= {{0,0,0,0,0,0,0,0,0},{0,0,1,1,1,1,1,1,0},{0,0,1,0,1,1,1,1,0},{0,1,1,0,0,1,1,1,0},{0,1,1,0,0,1,1,1,0},{0,5,1,0,0,1,1,1,0},{0,0,0,0,0,4,1,1,0},{0,0,0,0,0,0,0,0,0}};
        int [][] map1= {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,1,1,0,0,0},{0,0,1,0,0,1,0,0,0},{0,0,0,0,0,1,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};

        change chance = new change(20);
        change success = new change(0);

        change message= new change('a');
        change key = new change(0);

        change a = new change(5);
        change b = new change(1);

        change target_a = new change(6);
        change target_b = new change(5);


        print_map(map);                             //현재 map 상황 출력

        start(map,map1,success,chance,key,message,a,b,target_a,target_b );
        if(success.value==1)
            System.out.println("success");
    }
}
