package testload;

public class B

{
/*    @Override
    public int hashCode(){
      return 999999999;
    }*/
    @Override
    public B clone(){
        B b=null;
        try {
            b = (B) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return b;
    }
    public boolean equals(Object obj) {
        return true;
    }
    public static B t1 = new B();
    public static B t2 = new B();
    {

        System.out.println("构造块");
    }
    static
    {
        System.out.println("静态块");
    }
    public static void main(String[] args)
    {
        B t = new B();
    }
}