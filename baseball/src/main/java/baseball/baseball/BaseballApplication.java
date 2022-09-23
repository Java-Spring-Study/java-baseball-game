package baseball.baseball;

import baseball.tool.BaseballTool;

public class BaseballApplication {
	public static void main(String[] args) {
		try{
			while(true){
				BaseballTool tool=new BaseballTool();
				tool.makeRamdomNumbers();	//랜덤한 숫자를 생성한다.

				while(!tool.checkStrike()){	//확인한다.
					tool.setInputNumber();	//input을 받는다.
					tool.calcResult();		//게임 결과를 계산한다.
					tool.printResult();		//게임 결과를 출력한다.
				}
				if(tool.getSignalCode()==2) break;
			}
		}catch(IllegalArgumentException e){
			System.err.println("input error");
		}
	}

}
