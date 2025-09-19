package steven.maven.example.Base;

public class Extend10 {
    public static void main(String[] args) {
        // extend10 extendFun = new Animal();
        // extendFun.Animal
        // extendFun.InputOutStream();
    }

    public static class Animal {
        private final String name;
        private final int id;

        public Animal(String myName, int myid) {
            name = myName;
            id = myid;
        }

        public void eat() {
            System.out.println(name + "正在吃");
        }

        public void sleep() {
            System.out.println(name + "正在睡");
        }

        public void introduction() {
            System.out.println("大家好！我是" + id + "号" + name + ".");
        }
    }

    public static class Penguin extends Animal {
        public Penguin(String myName, int myid) {
            super(myName, myid);
        }
    }

    public static class Mouse extends Animal {
        public Mouse(String myName, int myid) {
            super(myName, myid);
        }
    }
}

