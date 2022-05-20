package com.example.kynguyen_pnv23_finalproject.controllers;

import com.example.kynguyen_pnv23_finalproject.Manager;

public abstract class Controller {
    protected final Manager mg = new Manager();
    public Manager getManager () {return mg;}
}
