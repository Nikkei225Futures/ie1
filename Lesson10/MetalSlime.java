public class MetalSlime extends Monster {
    public MetalSlime(String name, int hp, int atk){
        super(name, hp, atk);
    }

    public void attack(Human hu){
        System.out.println(this.name + "は逃げだした !");
    }

  }
  