public interface Critical {
    //add here
    int CRITICAL = 2;
    default int calcCritical(int atk){
        return atk * CRITICAL;
    }
}
