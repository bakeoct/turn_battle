package Calc;
class sab4 {
    String name;
    int dennwa;
    int zyuusyo;
    void setdata(String n,int d,int z){
        name=n;
        dennwa=d;
        zyuusyo=z;
    }
    void print(double ares){
        System.out.println(name+" : "+dennwa+" : "+zyuusyo);
    }
    void print(String ki){
        System.out.println(name+" : "+dennwa+" : "+zyuusyo);
    }
    void print(int u){
        System.out.println(name+" : "+dennwa+" : "+zyuusyo);
    }
    public static void main(String[] ares){
        sab4 zyuusyo1 =new sab4();
        sab4 zyuusyo2 =new sab4();
        sab4 zyuusyo3 =new sab4();
        zyuusyo1.setdata("A君",1015116645,256585);
        zyuusyo2.setdata("B君",1035684897,351587);
        zyuusyo3.setdata("C君",1015627843,956344);
        zyuusyo1.print(50000000);
        zyuusyo2.print(1.1111);
        zyuusyo3.print("つつつつつ");
    }
}
