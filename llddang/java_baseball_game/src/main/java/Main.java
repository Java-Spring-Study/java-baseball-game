public class Main {
  public static void main(String[] args) {
    Baseball baseball = new Baseball();
    int opinion;
    do{
      baseball.gameStart();
      baseball.gameProcessing();
      opinion = baseball.getOpinion();
    }while(opinion == Opinion.RESTART.value());
  }
}