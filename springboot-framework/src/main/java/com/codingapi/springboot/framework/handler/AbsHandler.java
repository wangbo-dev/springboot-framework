package com.codingapi.springboot.framework.handler;

import java.lang.reflect.ParameterizedType;

import com.codingapi.springboot.framework.event.IEvent;

public abstract class AbsHandler<T extends IEvent> implements IHandler{

    private final Class<T> clazz;

    public AbsHandler(){
        this. clazz = (Class<T>)((ParameterizedType)(getClass().getGenericSuperclass())).getActualTypeArguments()[0];
        ApplicationHandlerUtils.getInstance().addHandler(this);        
    }


    @Override
    public void handler(IEvent event) {        
        if(event!=null){
            if(event.getClass().equals(clazz)){
                handler0((T)event);
            }          
        }        
    }

    public abstract void handler0(T event);
    
}
