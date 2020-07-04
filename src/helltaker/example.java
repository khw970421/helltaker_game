package helltaker;

public class example {
    int value;
    example(int value)
    {
        this.value = value;
    }
    public static void main(String args[]){
        int[][] p = {{10,20,30},{40,50,60}};
        example a=new example(1);
        example b=new example(2);

        swap(p,a.value,b.value);
        swap1(a,b);
        System.out.println(a.value);
        System.out.println(b.value);
        System.out.println(p[1][2]+":p[1][2]");
    }
    public static void swap(int[][]p,int a, int b){         //배열과 관련된 내용은 int 매개변수로 처리를한다. 이 함수에서 a와 b는 call by value에 의해처리
        p[a][b]=100;
        a=1000;                                             //현재문장의 a는 아무곳에도 사용되지않는다. (call by value이므로)
    }
    public static void swap1(example a, example b){         //그외에는 example을 통해 값을 call by reference로 진행한다.
        b.value++;
        a.value++;
    }
}
