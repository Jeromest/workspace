public class myThread2 extends Thread{
    @Override
    public void run() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        Thread thread=new myThread2();
        thread.start();
    }
}
