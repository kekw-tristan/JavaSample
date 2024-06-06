package de.fherfurt.lat.storage.models;


import de.fherfurt.lat.storage.logic.Logic;

public class Main
{
    public static void main(String[] args)
    {
       Logic logic = new Logic();
       logic.init();
       logic.fin();
    }
}
