package telran;

import java.util.List;
import java.util.Random;

public class CreativeIssuer implements Runnable {
    private String name;
    private int minTime;
    private int maxTime;
    private int amountOfCredits;
    private List<Score> resultList;
    private int turboMin;
    private int turboMax;
    private int turboCapacity;
    private int inspiredProbability;
    Random random = new Random();

    public CreativeIssuer(String name, int minTime, int maxTime, int amountOfCredits, List<Score> resultList, int turboMin, int turboMax, int turboCapacity, int inspiredProbability) {
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.amountOfCredits = amountOfCredits;
        this.resultList = resultList;
        this.turboMin = turboMin;
        this.turboMax = turboMax;
        this.turboCapacity = turboCapacity;
        this.inspiredProbability = inspiredProbability;
    }

    @Override
    public void run() {
        int inspiration = random.nextInt(100+1);
        long start = System.currentTimeMillis();
        if(inspiration <= inspiredProbability){

            for (int i = 0; i < amountOfCredits/turboCapacity; i++) {
                int randomTime = random.nextInt(turboMax - turboMin + 1)+turboMin;
                try {
                    Thread.sleep(randomTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }else{

            for (int i = 0; i < amountOfCredits; i++) {
                int randomTime = random.nextInt(maxTime-minTime+1)+maxTime;
                try {
                    Thread.sleep(randomTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        long end = System.currentTimeMillis();
        long result = end - start;
        resultList.add(new Score(name,result));

    }
}
