package helltaker;

import java.util.Scanner;

public class start {
    public static void start(int[][] map,int[][] map1,change success,change chance,change key, change message, change a, change b, change target_a,change target_b ){
         change c = new change();
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
                        c.change_a(map,a.value,b.value);
                    }
                }
                else if(map[a.value][b.value]==2){
                    if(map[a.value][b.value-1]==1){     //옮기는 부분이 공간이있으면 해골 옮기기
                        c.changeskel_a(map,a.value,b.value);
                    }
                    else{
                        map[a.value][b.value]=1;        //막혀있다면 해골부수기
                    }
                    b.value++;
                }

                else if(map[a.value][b.value]==3){          //돌이 있다면
                    if(map[a.value][b.value-1]==1) {        //옮기는 부분이 공간이있으면 돌 옮기기
                        c.changestone_a(map, a.value, b.value);
                    }
                    b.value++;
                }
                else {
                    if(map1[a.value][b.value]==3){      //덫을 밟으면 하나더 감소
                        chance.value--;
                    }
                    c.check_key(map1,key,a.value,b.value);
                    c.change_a(map,a.value,b.value);
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
                        c.change_w(map,a.value,b.value);
                    }
                }
                else if(map[a.value][b.value]==2){
                    if(map[a.value-1][b.value]==1){
                        c.changeskel_w(map,a.value,b.value);
                    }
                    else{
                        map[a.value][b.value]=1;        //막혀있다면 해골부수기
                    }
                    a.value++;
                }
                else if(map[a.value][b.value]==3){
                    if(map[a.value-1][b.value]==1) {
                        c.changestone_w(map, a.value, b.value);
                    }
                    a.value++;
                }
                else {
                    if(map1[a.value][b.value]==3){
                        chance.value--;
                    }

                    c.check_key(map1,key,a.value,b.value);
                    c.change_w(map,a.value,b.value);
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
                        c.change_d(map,a.value,b.value);
                    }
                }
                else if(map[a.value][b.value]==2){
                    if(map[a.value][b.value+1]==1){
                        c.changeskel_d(map,a.value,b.value);
                    }
                    else{
                        map[a.value][b.value]=1;        //막혀있다면 해골부수기
                    }
                    b.value--;
                }
                else if(map[a.value][b.value]==3){
                    if(map[a.value][b.value+1]==1) {
                        c.changestone_d(map, a.value, b.value);
                    }
                    b.value--;
                }
                else {
                    if(map1[a.value][b.value]==3){
                        chance.value--;
                    }
                    c.check_key(map1,key,a.value,b.value);
                    c.change_d(map,a.value,b.value);
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
                        c.change_s(map,a.value,b.value);
                    }
                }
                else if(map[a.value][b.value]==2){
                    if(map[a.value+1][b.value]==1){
                        c.changeskel_s(map,a.value,b.value);
                    }
                    else{
                        map[a.value][b.value]=1;        //막혀있다면 해골부수기
                    }
                    a.value--;
                }
                else if(map[a.value][b.value]==3){
                    if(map[a.value+1][b.value]==1) {
                        c.changestone_s(map, a.value, b.value);
                    }
                    a.value--;
                }
                else {
                    if(map1[a.value][b.value]==3){
                        chance.value--;
                    }
                    c.check_key(map1,key,a.value,b.value);
                    c.change_s(map,a.value,b.value);
                }
            }

            else{                                                                   //그외에 반응
                System.out.println("정상적 방향을 입력하세요");
            }

            c.print_map(map,map1);                                                         //현재 map 상황 출력

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
            if(key.value==0)
                System.out.println("key 존재 x ");
            else
                System.out.println("key 존재");
            if(chance.value<0){
                System.out.println("fail");
                break;
            }
            if(success.value==1)
                System.out.println("success");
        }
        while(success.value==0);                //1이되면 성공이니 더할필요없지
    }
}
