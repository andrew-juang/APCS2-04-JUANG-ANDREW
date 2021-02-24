public class Driver{
    public static void main(String[]args){
        String filename = "data1.dat";
        try{
            Maze f;
            f = new Maze(filename);//true animates the maze.

            //f.setAnimate(true);//only uncomment if you are not on gitbash/powershell
            f.solve();
            System.out.println(f);
        }catch(FileNotFoundException e){
            System.out.println("Invalid filename: "+filename);
        }
    }
}
