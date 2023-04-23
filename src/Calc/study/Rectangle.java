package Calc.study;

public class Rectangle {
    int width;
    int height;
    Rectangle(int width,int height){
        width=keisann(width);
        height=keisann(height);
        this.width=width;
        this.height=height;

    }
    @Override
    public String toString(){
        return "Rectangle("+this.width+","+this.height+")";

    }
    int keisann(int atai){
        if (atai<0){
            atai=0;
        }
        return atai;
    }
    public static void main(String [] args){
        Rectangle r =new Rectangle(123,45);
        System.out.println(r);
    }
}
