public class Driver {
    public static void main(String[]args){
        QueenBoard q1 = new QueenBoard(3);
        QueenBoard q2 = new QueenBoard(4);
        QueenBoard q3 = new QueenBoard(5);
        QueenBoard q4 = new QueenBoard(6);
        QueenBoard q5 = new QueenBoard(7);
        QueenBoard q6 = new QueenBoard(8);
        System.out.println(q1.countSolutions());
        System.out.println(q2.countSolutions());
        System.out.println(q3.countSolutions());
        System.out.println(q4.countSolutions());
        System.out.println(q5.countSolutions());
        System.out.println(q6.countSolutions());
    }
}
