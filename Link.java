package com.game.main;

public class Link<T> {
    public T data;
    public Link nextLink;

    public Link(T newData) {
        this.data = newData;
    }
}
