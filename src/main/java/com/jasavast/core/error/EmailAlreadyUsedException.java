package com.jasavast.core.error;

public class EmailAlreadyUsedException extends BadRequestAlertException{
    public EmailAlreadyUsedException(){
        super(ErrorConstants.EMAIL_ALREADY_USED_TYPE,"email sudah digunakan","user","400");
    }
}
