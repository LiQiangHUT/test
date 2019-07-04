package parent;

import testload.B;

import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        B b = new B();
        B a = new B();
        B c = new B();
        map.put(a,1);
        map.put(b,2);
        map.put(c,3);
        System.out.println(map);
        System.out.println(b.clone());

    }

    public void test(){
        int i=3;
        int a=99;
        int b=i+a;
        System.out.println(b);
    }
}
