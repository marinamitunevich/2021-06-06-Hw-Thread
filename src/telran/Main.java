package telran;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int CREDITS_NUM = 15;
    public static void main(String[] args) throws InterruptedException {

        List<Score> result = new ArrayList<>();
        Issuer issuer1 = new Issuer("Tanya",100,200,CREDITS_NUM,result);
        Issuer issuer2 = new Issuer("Petya",200,300,CREDITS_NUM,result);
        CreativeIssuer issuer3 = new CreativeIssuer("Vasya",200,300,CREDITS_NUM,result,50,100,3,20);
        List<Thread> threads = new ArrayList<>();

        threads.add(new Thread(issuer1));
        threads.add(new Thread(issuer2));
        threads.add(new Thread(issuer3));

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(result);

    }

}
