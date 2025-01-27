package app.Exception;

public class NotFoundException extends Exception{
    public NotFoundException(){
        super("query result Not found");
    }
    public NotFoundException (String a)throws NotFoundException{
        super(a);
    }
}
