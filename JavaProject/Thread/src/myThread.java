public class myThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new myThread());
        thread.start();
        System.out.println("world");
    }
}
