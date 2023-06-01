package Activities;

public class CustomException extends Exception{
    String message = "message";
    public CustomException(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }

}
