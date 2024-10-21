/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matti
 */

public class HelloWorld implements Welcome{
    @UpperCase
    public String welcomeBIG;
    @LowerCase
    public String welcomeLow;
    
    public HelloWorld(){
        this.welcomeBIG = "HELLO WORLD";
        this.welcomeLow = "hello world";
    }
    
    @Override
    public String getWelcomeMessageLowercase() {
        return welcomeLow;
    }

    @Override
    public String getWelcomeMessageUppercase() {
        return welcomeBIG;
    }
    
}
