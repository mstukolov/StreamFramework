package ru.streamframework.core;

/**
 * Created by Stukolov on 29.07.2018.
 */
public interface Stream {

    Stream start();
    Stream proccess();
    Stream stop();
    Stream clear();

}
