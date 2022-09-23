package baseball.tool;

import java.util.Random;
import java.util.Scanner;

public class BaseballTool{
    private Scanner sc=new Scanner(System.in);
    private int[] solution=new int[3];
    private int[] inputNums=new int[3];
    private int strike=0;
    private int ball=0;


    private void reset(){
        this.strike=0;
        this.ball=0;
    }

    public void makeRamdomNumbers(){
        Random random=new Random();
        for(int i=0;i<3;i++) {
            this.solution[i] = random.nextInt(9) + 1;
            for(int j=0;j<i;j++){
                if(solution[j]==solution[i]){
                    i--;
                    break;
                }
            }
        }
    }
    public void setInputNumber() throws IllegalArgumentException{
        String inputString;
        System.out.print("숫자를 입력해주세요 : ");
        inputString=sc.next();

        int num;
        if(inputString!=null&&inputString.matches("[1-9]+")) {
            num = Integer.parseInt(inputString);
            if (num < 1000 && num > 99) {
                setInputNums(num);  //input된 number를 배열로 저장
            }else throw new IllegalArgumentException();

        }else throw new IllegalArgumentException();
    }
    private void setInputNums(int num){
        for(int i=2;i>=0;i--){
            this.inputNums[i]=num%10;
            num/=10;
        }
    }
    public boolean checkStrike(){
        if(this.strike==3) {
            return true;
        }
        return false;
    }
    public void calcResult(){
        reset();
        for(int i=0;i<this.inputNums.length;i++){
            if(inputNums[i]==solution[i]) strike++;
            else{
                for(int j=0;j<this.solution.length;j++) {
                    if (inputNums[i] == solution[j]){
                        ball++;
                        break;
                    }
                }
            }
        }
    }
    public void printResult(){
        String resultStr = "";
        if(ball>0) resultStr+=ball+"볼 ";
        if(strike>0) resultStr+=strike+"스트라이크";
        if(ball==0&&strike==0) resultStr="낫싱";
        System.out.println(resultStr);
    }
    public int getSignalCode() throws IllegalArgumentException{
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String signalCode=sc.next();

        if(signalCode!=null&&signalCode.matches("[1-2]")) {
            return Integer.parseInt(signalCode);
        }else throw new IllegalArgumentException();
    }

}
