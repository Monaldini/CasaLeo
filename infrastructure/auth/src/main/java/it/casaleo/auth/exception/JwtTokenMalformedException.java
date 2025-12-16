package it.casaleo.auth.exception;

public class JwtTokenMalformedException extends RuntimeException{

    public JwtTokenMalformedException (String message){
         super(message);
    }
}
