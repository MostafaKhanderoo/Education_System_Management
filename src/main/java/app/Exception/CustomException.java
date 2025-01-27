package app.Exception;

 import jakarta.persistence.NoResultException;

public class CustomException extends Exception {
 public CustomException (){
  super("Error");
 }
 public CustomException(String message){
  super(message);
 }
 public CustomException(String message,Throwable cause){
  super(message,cause);
 }
}
