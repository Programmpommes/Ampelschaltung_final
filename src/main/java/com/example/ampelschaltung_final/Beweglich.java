package com.example.ampelschaltung_final;

public class Beweglich {
    Ampel ampel1 = new Ampel();
    public Boolean halt = false;


    public void stopGo(){
        if(ampel1.istRot1 || ampel1.istRot2){
            halt = true;
        }
        else if (!ampel1.istRot1 || !ampel1.istRot2){
            halt = false;
        }
    }



}
