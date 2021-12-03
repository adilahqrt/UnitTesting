<?php

class LoginMock
{
    //membuat sebuah fungsi loginProcess pada class Login-Mock
    public function loginProcess($email, $password){
        if ($email == 'adilah.qurrotu25@gmail.com')
            return 'SUCCESSFULL';
        else
            return 'FAILED';
    }
}
?>