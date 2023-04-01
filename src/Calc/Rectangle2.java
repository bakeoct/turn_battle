package Calc;

public class Rectangle2 {
    int x=0;
    int y=0;
    int width;
    int height;
    final int INITIAL_WIDTH=0;
    final int INITIAL_HEIGHT=0;
    Rectangle2(){
      width=INITIAL_WIDTH;
      height=INITIAL_HEIGHT;
      x=0;
      y=0;
    }
    Rectangle2(int width,int height){
        this.width=width;
        this.height=height;
        this.x=0;
        this.y=0;

    }
    Rectangle2(int x,int y,int width,int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
    void setLocation(int x,int y){

    }
    void setSise(int width,int height){

    }
    @Override
    public String toString(){
        return "["+x+","+y+","+width+","+height+"]";
    }
    Rectangle2 intersect(Rectangle2 r){
        int sx=Math.max(this.x,r.x);
        int sy=Math.max(this.y,r.y);
        int ex=Math.min(this.x+this.width,r.x+r.width);
        int ey=Math.min(this.y+this.height,r.y+r.height);
        int newwidth=ex-sx;
        int newheight=ey-sy;
        if (newwidth>0 &&newheight>0){
            return new Rectangle2(sx,sy,newwidth,newheight);
        }else {
            return null;
        }
    }
    public static void main(String[] args){
       Rectangle2 r2a=new Rectangle2(10,2,5,3);
       Rectangle2 r2b=new Rectangle2(5,3,20,1);
       System.out.println(r2a);
       System.out.println(r2b);
       System.out.println(r2a.intersect(r2b));
    }
}
