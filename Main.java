public class Main {

    public static void main(String[] args) {

        new Window(); //Policsek, 15*15, 3986504467184881838, -5753571078561718291, -3434131705064385839
        /*int a = 5;
        if ((a % 2 == 0) {

        } else {

        }*/
        /*double time2 = 0;
        Grid grid;
        long start;
        long finish;
        for (int i = 0; i < 1; i++) {
            grid = new Grid(500, 500);
            start = System.nanoTime();
            AldousBroder.on(grid);
            finish = System.nanoTime();
            time2 += (double) (finish - start) / 1000000;
        }
        System.out.println("Policsek: " + time2);

        /*
        grid = new Grid(500, 500);
        start = System.nanoTime();
        HuntAndKill.on(grid);
        finish = System.nanoTime();
        time2 = (double) (finish - start) / 1000000;
        System.out.println("Hunt-and-Kill:" + time2);
        grid = new Grid(1000, 1000);
        start = System.nanoTime();
        Policsek6.on(grid);
        finish = System.nanoTime();
        time2 = (double) (finish - start) / 1000000;
        System.out.println("Policsek6:" + time2);*/

    }
}