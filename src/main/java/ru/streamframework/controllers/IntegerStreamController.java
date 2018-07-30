package ru.streamframework.controllers;


import ru.streamframework.annotations.PROCCESS;
import ru.streamframework.annotations.START;
import ru.streamframework.annotations.STOP;
import ru.streamframework.core.StreamController;

/**
 * Created by Stukolov on 29.07.2018.
 */
public class IntegerStreamController implements StreamController {
    private Object id;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }
    @START
    public void start() throws InterruptedException {
        System.out.println(this.getClass().getName() + ": started\n");
        Thread.sleep(1000);
    }

    @STOP
    public void stop() throws InterruptedException {
        System.out.println(this.getClass().getName() + ": stoped\n");
        Thread.sleep(1000);
    }

    @PROCCESS
    public void proccess() throws InterruptedException {
        System.out.println(this.getClass().getName() + ": proccessing\n");
        Thread.sleep(1000);
    }
}
