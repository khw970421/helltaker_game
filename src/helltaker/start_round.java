package helltaker;

public class start_round {
    public start_round(){};
    static change c = new change();
    public static void start_round1(){
        int [][] map= {
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,5,0,0},
                {0,0,1,1,2,1,1,0,0},
                {0,0,1,2,1,2,0,0,0},
                {0,1,1,0,0,0,0,0,0},
                {0,1,3,1,1,3,1,0,0},
                {0,1,3,1,3,1,1,4,0},
                {0,0,0,0,0,0,0,0,0}
        };
        int [][] map1= {
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0}
        };
        change success = new change(0);
        change chance = new change(23);
        change key = new change(0);
        change message= new change('a');

        change a = new change(1);
        change b = new change(6);
        change target_a = new change(6);
        change target_b = new change(7);


        c.print_map(map);                             //현재 map 상황 출력

        c.start(map,map1,success,chance,key,message,a,b,target_a,target_b );
        if(success.value==1)
            System.out.println("success");
    }

    public static void start_round2(){
        int [][] map= {
                {0,0,0,0,0,0,0,0,0},
                {0,0,1,1,1,1,1,1,0},
                {0,0,1,0,1,1,1,1,0},
                {0,1,1,0,0,1,1,1,0},
                {0,1,1,0,0,1,1,1,0},
                {0,5,1,0,0,1,1,1,0},
                {0,0,0,0,0,4,1,1,0},
                {0,0,0,0,0,0,0,0,0}
        };
        int [][] map1= {
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,0,0,0},
                {0,0,1,0,0,1,0,0,0},
                {0,0,0,0,0,1,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0}
        };

        change chance = new change(20);
        change success = new change(0);

        change message= new change('a');
        change key = new change(0);

        change a = new change(5);
        change b = new change(1);

        change target_a = new change(6);
        change target_b = new change(5);


        c.print_map(map);                             //현재 map 상황 출력

        c.start(map,map1,success,chance,key,message,a,b,target_a,target_b );
        if(success.value==1)
            System.out.println("success");
    }

    public static void start_round3(){
        int [][] map= {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,4,4,4,1,0,0},
                {0,0,0,0,0,0,0,9,0,0},
                {0,0,0,1,1,1,1,1,5,0},
                {0,0,0,1,0,1,0,1,1,0},
                {0,0,0,1,1,2,1,1,0,0},
                {0,1,0,1,0,1,0,1,0,0},
                {0,1,1,1,1,1,2,1,0,0},
                {0,0,0,0,0,0,0,0,0,0}
        };
        int [][] map1 = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0},
                {0,0,0,0,0,0,1,1,0,0},
                {0,2,0,1,0,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}
        };

        change chance = new change(32);
        change success = new change(0);

        change message= new change('a');
        change key = new change(0);

        change a = new change(3);
        change b = new change(8);

        change target_a = new change(1);
        change target_b = new change(6);


        c.print_map(map);                             //현재 map 상황 출력

        c.start(map,map1,success,chance,key,message,a,b,target_a,target_b );
        if(success.value==1)
            System.out.println("success");
    }
    public static void start_round4(){
        int [][] map= {
                {0,0,0,0,0,0,0,0,0,0},
                {0,5,0,1,1,3,0,0,0,0},
                {0,1,3,1,3,1,9,1,0,0},
                {0,3,1,3,1,3,3,1,4,0},
                {0,1,3,1,3,1,3,3,1,0},
                {0,0,1,3,1,3,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}
        };
        int [][] map1 = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,2,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0}
        };

        change chance = new change(23);
        change success = new change(0);

        change message= new change('a');
        change key = new change(0);

        change a = new change(1);
        change b = new change(1);

        change target_a = new change(3);
        change target_b = new change(8);


        c.print_map(map);                             //현재 map 상황 출력

        c.start(map,map1,success,chance,key,message,a,b,target_a,target_b );
        if(success.value==1)
            System.out.println("success");
    }

}
