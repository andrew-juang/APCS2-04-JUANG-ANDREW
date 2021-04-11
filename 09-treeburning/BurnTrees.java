import java.util.*;
public class BurnTrees{
    private int[][]map;
    private int ticks;
    private static int TREE = 2;
    private static int FIRE = 1;
    private static int ASH = 3;
    private static int SPACE = 0;

    public int run(){
        while(!done()){
            tick();
        }
        return getTicks();
    }

    public BurnTrees(int width,int height, double density){
        map = new int[height][width];
        for(int r=0; r<map.length; r++ )
        for(int c=0; c<map[r].length; c++ )
        if(Math.random() < density)
        map[r][c]=2;
        ticks = 0;
        start();//set the left column on fire.
    }

    public boolean done(){
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        for(int r=0;r<map.length;r++){
            for(int c=0;c<map[r].length;c++){
                if(map[r][c]==FIRE){
                    for(int i=0;i<4;i++){
                        if(r+dx[i]>=0&&r+dx[i]<map.length&&c+dy[i]>=0&&c+dy[i]<map[0].length){
                            if(map[r+dx[i]][c+dy[i]]==TREE){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public void tick(){
        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};
        for(int c=0;c<map[0].length;c++){
            for(int r=0;r<map.length;r++){
                if(map[r][c]==FIRE){
                    for(int i=0;i<4;i++){
                        if(r+dx[i]>=0&&r+dx[i]<map.length&&c+dy[i]>=0&&c+dy[i]<map[0].length){
                            if(map[r+dx[i]][c+dy[i]]==TREE){
                                map[r+dx[i]][c+dy[i]]=FIRE;
                            }
                        }
                    }
                    map[r][c]=ASH;
                }
            }
        }
    }

    public void start(){
        ticks=1;
        for(int i = 0; i < map.length; i++){
            if(map[i][0]==TREE){
                map[i][0]=FIRE;
            }
        }
    }

    public int getTicks(){
        return ticks;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int c = 0; c < map[i].length; c++) {
                if(map[i][c]==SPACE)
                builder.append(" ");
                else if(map[i][c]==TREE)
                builder.append("@");
                else if(map[i][c]==FIRE)
                builder.append("w");
                else if(map[i][c]==ASH)
                builder.append(".");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public String toStringColor(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int c = 0; c < map[i].length; c++) {
                if(map[i][c]==0)
                builder.append(" ");
                else if(map[i][c]==2)
                builder.append(Text.color(Text.GREEN)+"@");
                else if(map[i][c]==1)
                builder.append(Text.color(Text.RED)+"w");
                else if(map[i][c]==3)
                builder.append(Text.color(Text.DARK)+".");
            }
            builder.append("\n"+Text.RESET);
        }
        return builder.toString()+ticks+"\n";
    }

    public int animate(int delay) {
        System.out.print(Text.CLEAR_SCREEN);
        System.out.println(Text.go(1,1)+toStringColor());
        Text.wait(delay);
        while(!done()){
            tick();
            System.out.println(Text.go(1,1)+toStringColor());
            Text.wait(delay);
        }
        return getTicks();
    }

    public int outputAll(){
        System.out.println(toString());
        while(!done()){
            tick();
            System.out.println(toString());
        }
        return getTicks();
    }

    public static void main(String[]args)  throws InterruptedException{
        int WIDTH = 20;
        int HEIGHT = 20;
        int DELAY = 200;
        double DENSITY = .7;
        if(args.length > 1){
            WIDTH = Integer.parseInt(args[0]);
            HEIGHT = Integer.parseInt(args[1]);
            DENSITY = Double.parseDouble(args[2]);
        }
        if(args.length > 3){
            DELAY = Integer.parseInt(args[3]);
        }
        BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);


        //System.out.println(b.animate(DELAY));//animate all screens and print the final answer
        System.out.println(b.outputAll());//print all screens and the final answer
    }


}
