package droidProject;

public class Droid {
    String name;
    int batteryLevel = 100;

    public Droid(String droidName){
    name = droidName;
    }

    public String toString(){
      return "Hello, I'm the droid: " + name;
    }

    public void performTask(String task){
      System.out.println(name + " is performing task: " + task);
      batteryLevel -= 10;
    }

    public void energyReport(){
      System.out.println("My battery level is at " + batteryLevel);
      batteryLevel -= 10;
    }

    public void transferEnergy(Droid d1, Droid d2){
      d1.batteryLevel -= 20;
      d2.batteryLevel += 20;
    }

public static void main(String[] args) {
    Droid Codey = new Droid("Codey");
    Droid Sam = new Droid("Sam");
    System.out.println(Codey);
    Codey.performTask("jumping");
    Codey.energyReport();
    Codey.transferEnergy(Codey, Sam);
    Codey.energyReport();
    Sam.energyReport();
}
}
