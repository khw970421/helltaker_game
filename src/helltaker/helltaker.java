package helltaker;
import java.util.Scanner;
public class helltaker {
    public static void main(String args[]){
        start_round1();
    }

    int value;
    char value1;
    helltaker(int value)
    {
        this.value = value;
    }
    helltaker(char value1)
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

    public static void check_key(int[][] map1,helltaker key,int a,int b) {
        if (map1[a][b] == 2) {
            key.value = 1;
        }
    }

    public static void start(int[][] map,int[][] map1,helltaker success,helltaker chance,helltaker key, helltaker message, helltaker a, helltaker b, helltaker target_a,helltaker target_b ){
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
        while(success.value==0);
    }

    public static void start_round1(){
        int [][] map= {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,1,5,0,0},{0,0,1,1,2,1,1,0,0},{0,0,1,2,1,2,0,0,0},{0,1,1,0,0,0,0,0,0},{0,1,3,1,1,3,1,0,0},{0,1,3,1,3,1,1,4,0},{0,0,0,0,0,0,0,0,0}};
        int [][] map1= {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};
        helltaker success = new helltaker(0);
        helltaker chance = new helltaker(23);
        helltaker key = new helltaker(0);
        helltaker message= new helltaker('a');

        helltaker a = new helltaker(1);
        helltaker b = new helltaker(6);
        helltaker target_a = new helltaker(6);
        helltaker target_b = new helltaker(7);


        print_map(map);                             //현재 map 상황 출력

        start(map,map1,success,chance,key,message,a,b,target_a,target_b );
        if(success.value==1)
            System.out.println("success");
    }

    public static void start_round2(){
        int [][] map= {{0,0,0,0,0,0,0,0,0},{0,0,1,1,1,1,1,1,0},{0,0,1,0,1,1,1,1,0},{0,1,1,0,0,1,1,1,0},{0,1,1,0,0,1,1,1,0},{0,5,1,0,0,1,1,1,0},{0,0,0,0,0,4,1,1,0},{0,0,0,0,0,0,0,0,0}};
        int [][] map1= {{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,1,1,0,0,0},{0,0,1,0,0,1,0,0,0},{0,0,0,0,0,1,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};

        helltaker chance = new helltaker(20);
        helltaker success = new helltaker(0);

        helltaker message= new helltaker('a');
        helltaker key = new helltaker(0);

        helltaker a = new helltaker(5);
        helltaker b = new helltaker(1);

        helltaker target_a = new helltaker(6);
        helltaker target_b = new helltaker(5);


        print_map(map);                             //현재 map 상황 출력

        start(map,map1,success,chance,key,message,a,b,target_a,target_b );
        if(success.value==1)
            System.out.println("success");
    }
}


/* 06.28 진행상황 : 어떠한 배열에 대해 움직여서 도착까지는 기회랑 0이상으로 나가는 충돌은 방지
 보안사항 : 함수를 실행을 하면 매개변수로 바로 위치에 주인공, 여성이 있는 위치를 가져올수있게 만들면 좋을듯

 06.30 진행상황 : 새로운 배열을 같이 생성해 덫, 열쇠 구현
                   원래있던 배열에 자물쇠를 구현 =>열쇠가없을경우 앞으로 나아가지 못하게 구현
                 함수를 선언하여 좀 더 이해를 쉽게 하도록 구현 => change함수
 보안 사항 : 함수를 좀 더 선언하여 해골, 돌 구현 전에 좀더 보기쉽게 구현해야할듯 , 코드 설명 좀 옆에 필요할듯

7.4 this를 사용해봤는데 생각해보니 배열은 안바꿔도 되는게 배열을 매개변수로 하면 애초 call by reference이니까 그대로 사용하고
그외에 helltaker 자료형으로 만들어 call by reference를 나머지 변수들에게도 적용시키고
이때 check key 함수같은경우에는 배열에 넣는 값은 int형일 필요가 있어 int 매개변수가 필요하므로 메인함수에서도 a.value, b.value 필요함
helltaker 자료형을 통해 start 부분외에 필요부분만 바꿔서 함수의 재활용을 사용가능
=>해야할것 : start_round2()만들어보기,해골이랑 돌 구현 , 좀더 키랑 트랩을 보이게 할수있는 방법을 연구


7.7 start_round2() 함수를 이용해 다른 맵을 생성하고 실행까지 진행, 처음 오류가 나다가 start함수의 도착했을때의 코드도 오류가 존재해서 수정
그외에 새로운 함수선언할때 맵 뿐만아니라 그위치에 시작되는 주인공과 공략대상 위치도 정확히 잡아야 처리가능
=>해야할것 : 해골이랑 돌 구현(해골과 돌의 연관관계중요),  좀더 키랑 트랩을 보이게 할수있는 방법을 연구
=> 해골 1) 원하는위치에 해골이있으면 민곳으로 밀기(주인공 가만히) 2) 미는위치가 막혀있으면 없애기( 주인공 가만히)
     1을제외한 어떠한거로 막혀있다면 =>if(옮길위치!=1) 해골을 1(통로,해골없애기)로 만들기 chance감수
=> 해골 2) 원하는위치에 돌이있으면 민곳으로 밀기(주인공 가만히) 2) 미는위치가 막혀있으면 없애기 불가능( 주인공 가만히)
                               =>if(옮길위치!=1) 돌은 그대로 chance감수

7.12 해골(2)과 돌(3) 구현 완료 및 실행 정상작동
=> 해야할것 : 코드를 좀더 줄이고 새로운 파일로 연결하여 함수들을 분산시켜놓아 보기 쉽게 만들기, 남은 라운드 구현해놓기, 덫이나 열쇄 그림구현
 */