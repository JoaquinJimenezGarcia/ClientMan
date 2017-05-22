package controller;

import java.io.IOException;

/**
 * Created by joaquinjimenezgarcia on 22/5/17.
 */
public class WrongMailException extends IOException{
    public WrongMailException(){

    }
    public WrongMailException(String msgError){
        super(msgError);
    }
}
