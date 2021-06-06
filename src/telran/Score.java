package telran;

public class Score {
    private String name;
    private final long result;

    public Score(String name, long result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public long getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Score{" +
                "name='" + name + '\'' +
                ", result=" + result +
                '}';
    }
}
