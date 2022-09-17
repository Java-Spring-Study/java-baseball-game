
import java.util.HashSet;
import java.util.List;

public class Error {
    public void validateLength(String[] inputArr){
        if (inputArr.length != Constant.LIST_SIZE){
            throw new IllegalArgumentException(ErrorMessage.LENGTH_ERROR.getMessage());
        }
    }
    public void validateNumberValue(List<Integer> playersNumer){
        for (int i= 0; i< Constant.LIST_SIZE;i++){
            if (isNumberValueError(playersNumer.get(i))){
                throw new IllegalArgumentException(ErrorMessage.VALUE_ERROR.getMessage());
            }
        }
    }
    private boolean isNumberValueError(int number){
        if (Constant.BALL_MIN<=number && number <= Constant.BALL_MAX){
            return false;
        }
        else{
            return true;
        }
    }
    public void validateDupicateNumber(List<Integer> playersNumer){
        HashSet<Integer> set = new HashSet<>(playersNumer);
        if (!(set.size() == Constant.LIST_SIZE)){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATENUMBER_ERROR.getMessage());
        }
    }
    public void validateRestart(int restartSignal){
        if (restartSignal != RestartStatus.RESTART.getRestartStatus() && restartSignal != RestartStatus.END.getRestartStatus()){
            throw new IllegalArgumentException(ErrorMessage.RESTART_ERROR.getMessage());
        }
    }
    enum ErrorMessage {
        LENGTH_ERROR ("숫자 3개를 입력해 주세요."),
        VALUE_ERROR ("1부터 9 사이의 숫자를 입력해 주세요."),
        DUPLICATENUMBER_ERROR ("숫자를 중복 없이 입력해 주세요."),
        RESTART_ERROR ("숫자 1 또는 2를 입력해 주세요.");
        private String message;
        ErrorMessage(String message){
            this.message = message;
        }
        public String getMessage(){
            return this.message;
        }
    }
}
