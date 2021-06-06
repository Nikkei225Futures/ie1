public class Machine {
  protected boolean power;
  protected int battery;

  public Machine() {
    power = false;
    battery = 100;
  }

  public Machine(int battery) {
    power = false;
    this.battery = battery;
  }

  public void start() {
    power = true;
  }

  public void stop() {
    power = false;
  }

  public void printInfo() {
    if (power == true) {
      System.out.println("電源: ON");
    } else {
      System.out.println("電源: OFF");
    }
    System.out.println("バッテリー残量:" + battery);
  }
}
