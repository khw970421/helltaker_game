package helltaker;
import java.util.Scanner;
public class helltaker {
    public static void main(String args[]){
        int [][] map= {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,1,5,0,0},{0,0,1,1,1,1,1,0,0},{0,0,1,1,1,1,0,0,0},{0,1,1,0,0,0,0,0,0},{0,1,1,1,1,1,1,0,0},{0,1,1,1,1,1,9,4,0},{0,0,0,0,0,0,0,0,0}};
        int [][] map1= {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,1,2,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};
        int success = 0;
        int chance = 20;
        int key=0;
        int [] control = {'a','w','d','s'};
        char message;
        Scanner scan = new Scanner(System.in);      // 문자 입력을 인자로 Scanner 생성
        int a=1,b=6;


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        do {

            System.out.println("메시지를 입력하세요:");

            message = scan.next().charAt(0);           // 키보드 문자 입력
            if (message == 'a') {
                b--;
                chance--;
                if(map[a][b]==0) {
                    chance++;
                    b++;
                }
                else if(map[a][b]==9){
                    if(key!=1){
                        chance++;
                        b++;
                    }
                    else{
                        change_a(map,a,b);
                    }
                }
                else {
                    if(map1[a][b]==1){
                        chance--;
                    }
                    else if(map1[a][b]==2){
                        key=1;
                    }
                    change_a(map,a,b);
                }
            }
            else if (message == 'w') {
                a--;
                chance--;
                if(map[a][b]==0){
                    chance++;
                    a++;
                }
                else if(map[a][b]==9){
                    if(key!=1){
                        chance++;
                        a++;
                    }
                    else{
                        change_w(map,a,b);
                    }
                }
                else {
                    if(map1[a][b]==1){
                        chance--;
                    }
                    else if(map1[a][b]==2){
                        key=1;
                    }
                    change_w(map,a,b);
                }
            }
            else if (message == 'd') {
                b++;
                chance--;
                if(map[a][b]==0){
                    chance++;
                    b--;
                }
                else if(map[a][b]==9){
                    if(key!=1){
                        chance++;
                        b--;
                    }
                    else{
                        change_d(map,a,b);
                    }
                }
                else {
                    if(map1[a][b]==1){
                        chance--;
                    }
                    else if(map1[a][b]==2){
                        key=1;
                    }
                    change_d(map,a,b);
                }
            }
            else if (message == 's') {
                a++;
                chance--;
                if(map[a][b]==0){
                    chance++;
                    a--;
                }
                else if(map[a][b]==9){
                    if(key!=1){
                        chance++;
                        a--;
                    }
                    else{
                        change_s(map,a,b);
                    }
                }
                else {
                    if(map1[a][b]==1){
                        chance--;
                    }
                    else if(map1[a][b]==2){
                        key=1;
                    }
                    change_s(map,a,b);
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            for (int i = 0; i < 4; i++) {
                if (map[6][6] - 1 == 4) {
                    success = 1;
                }
            }
            System.out.println("남은 횟수"+chance);
            System.out.println("key"+key);
            if(chance<0){
                System.out.println("fail");
                break;
            }
        }
        while(success==0);
        if(success==1)
            System.out.println("success");
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
}


// 06.28 진행상황 : 어떠한 배열에 대해 움직여서 도착까지는 기회랑 0이상으로 나가는 충돌은 방지
// 보안사항 : 함수를 실행을 하면 매개변수로 바로 위치에 주인공, 여성이 있는 위치를 가져올수있게 만들면 좋을듯

// 06.30 진행상황 : 새로운 배열을 같이 생성해 덫, 열쇠 구현
//                   원래있던 배열에 자물쇠를 구현 =>열쇠가없을경우 앞으로 나아가지 못하게 구현
//                 함수를 선언하여 좀 더 이해를 쉽게 하도록 구현 => change함수

// 보안 사항 : 함수를 좀 더 선언하여 해골, 돌 구현 전에 좀더 보기쉽게 구현해야할듯