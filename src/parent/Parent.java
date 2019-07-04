package parent;

public class Parent {

    private void test(){
        System.out.println(111);
    }

    public static void main(String[] args) {
        Parent sun = new Sun();
        sun.test();
    }
}
