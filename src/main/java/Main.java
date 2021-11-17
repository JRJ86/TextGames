import static Testing.NonUnittestTesting.test;

public class Main {

    public static void main(String[] args) {
//        JFrame frame = new JFrame("MATADOR");
//        JMenuBar menuBar = new JMenuBar();
//
//        GUI gui = new GUI();
//        gui.gameScreen(frame,menuBar);

        try {
            test();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
