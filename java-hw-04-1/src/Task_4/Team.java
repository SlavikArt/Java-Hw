package Task_4;

public class Team {
    private IWorker[] workers;
    private int workerCount;

    public Team(int maxWorkers) {
        this.workers = new IWorker[maxWorkers];
        this.workerCount = 0;
    }

    public void addWorker(IWorker worker) {
        if (workerCount < workers.length) {
            workers[workerCount] = worker;
            workerCount++;
        }
    }

    public void buildHouse(House house) {
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < workerCount; j++)
                workers[j].work(house);
    }
}
