package com.qacart.com.objects;

public class Task {
    private String item;
    private boolean isCompleted;

    public Task(String item,boolean isCompleted)
    {
        this.isCompleted=isCompleted;
        this.item=item;


    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }



    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


}
