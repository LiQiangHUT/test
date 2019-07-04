package testload;

public class TestLoad {
    public static void main(String[] args) {

        Son son1 = new Son();
        System.out.println("第二次new对象  ==========");
        Son son2 = new Son();

    }
}


class Father{

    public int i = test();
    private static int j = method();

    static {
        System.out.println("1 父类静态代码块");
    }

    Father(){
        System.out.println("2 父类构造方法");
    }

    {
        System.out.println("3 父类普通代码块");
    }

    public int test(){
        System.out.println("4 父类普通类变量test()");
        return 1;
    }

    public static int method(){
        System.out.println("5 父类静态类变量method()");
        return 1;
    }
}


class Son extends Father{
    private char c='c';
    private String a="2";
    public int i = test();
    private int i2 = test2();
    private static int j = method();

    static {
        System.out.println("6 子类静态代码块");
    }

    Son(){
        System.out.println("7 子类构造方法");
    }

    {
        System.out.println("8 子类普通代码块");
    }


    public int test(){
        System.out.println("9 子类普通类变量test()"+a+c);
        return 1;
    }
    public int test2(){
        System.out.println("9-2 子类普通类变量test2()");
        return 1;
    }
    public static int method(){
        System.out.println("10 子类静态类变量method()");
        return 1;
    }
}