package ru.streamframework.core;


import ru.streamframework.annotations.PROCCESS;
import ru.streamframework.annotations.START;
import ru.streamframework.annotations.STOP;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by Stukolov on 29.07.2018.
 */
public class StreamImpl implements Stream {

    StreamController controller;
    StreamImpl stream;
    Method[] methods;
    HashMap<String, Method> methodsMap;

    public StreamImpl(StreamController controller) {
        this.controller = controller;
        stream = this;
        methods = controller.getClass().getDeclaredMethods();
        methodsMap = new HashMap<String, Method>();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof START) {
                    methodsMap.put("START", method);
                }
                else if (annotation instanceof PROCCESS) {
                    methodsMap.put("PROCCESS", method);
                }
                else if (annotation instanceof STOP) {
                    methodsMap.put("STOP", method);
                }
            }
        }
    }

    public Stream start() {
        try {
            methodsMap.get("START").invoke(controller, (Object[])null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Stream proccess() {
        try {
            methodsMap.get("PROCCESS").invoke(controller, (Object[])null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Stream stop() {
        try {
            methodsMap.get("STOP").invoke(controller, (Object[])null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return this;

    }

    public Stream clear() {
        controller.setId("");
        return this;
    }

}
