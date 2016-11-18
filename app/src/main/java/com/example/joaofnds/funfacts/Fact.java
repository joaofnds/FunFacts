package com.example.joaofnds.funfacts;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Fact extends RealmObject {
    @PrimaryKey
    private String mFact;

    public String getFact() {
        return mFact;
    }

    public void setFact(String fact) {
        mFact = fact;
    }
}
