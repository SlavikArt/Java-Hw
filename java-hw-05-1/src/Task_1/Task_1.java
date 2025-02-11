package Task_1;

public class Task_1 {
    public static void main(String[] args) {
        SimulationParameters parameters = new SimulationParameters();
        parameters.inputParameters();

        Dock dock = new Dock(parameters);
        dock.runSimulation();
    }
}
