package Calc.study;

public class PlacedRectangle extends Rectangle {
    public int x;
    public int y;
    public PlacedRectangle(){
        super(1,2);
    }
    public PlacedRectangle(int x,int y){
        this();
    }
    public PlacedRectangle(int x,int y,int width,int height){
        super(width,height);
        this.x=x;
        this.y=y;
    }
    public void setLocation(int x,int y){

    }
    @Override
    public String toString(){
        return "[("+this.x+","+this.y+") ["+super.width+","+super.height+"]]";
    }
    public static void main(String[] args){
        PlacedRectangle placedRectangle =new PlacedRectangle(12,34,123,45);
        System.out.println(placedRectangle.toString());
        Rectangle rectangle =new Rectangle(1,1);
    }
}
