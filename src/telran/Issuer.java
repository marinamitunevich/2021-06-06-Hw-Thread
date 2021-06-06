package telran;

import java.util.List;
import java.util.Random;

public class Issuer implements Runnable{
    private String name;
    private int minTime;
    private int maxTime;
    private int amountOfCredits;
    private List<Score> resultList;
    Random random = new Random();

    public Issuer(String name, int minTime, int maxTime, int amountOfCredits, List<Score> resultList) {
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.amountOfCredits = amountOfCredits;
        this.resultList = resultList;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < amountOfCredits; i++) {
            int randomTime = random.nextInt(maxTime-minTime+1)+minTime;
            try {
                Thread.sleep(randomTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        long result = end -start;

            resultList.add(new Score(name, result));

    }
}
