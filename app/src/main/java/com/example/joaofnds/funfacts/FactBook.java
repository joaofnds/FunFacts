package com.example.joaofnds.funfacts;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class FactBook {

    public RealmList<Fact> mFacts;
    private Realm realm;

    private final String[] mFactsArray = new String[]{
            "Ants stretch when they wake up in the morning.",
            "Ostriches can run faster than horses.",
            "Olympic gold medals are actually made mostly of silver.",
            "You are born with 300 bones; by the time you are an adult you will have 206.",
            "It takes about 8 minutes for light from the Sun to reach Earth.",
            "Some bamboo plants can grow almost a meter in just one day.",
            "The state of Florida is bigger than England.",
            "Some penguins can leap 2-3 meters out of the water.",
            "On average, it takes 66 days to form a new habit.",
            "Mammoths still walked the earth when the Great Pyramid was being built."
    };

    public FactBook() {
        realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (String fact : mFactsArray) {
                    Fact f = new Fact();
                    f.setFact(fact);
                    realm.copyToRealmOrUpdate(f);
                }
            }
        });
    }

    public String getFact() {

        RealmResults<Fact> results = realm.where(Fact.class).findAll();
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(results.size());
        return results.get(randomNumber).getFact();
    }
}
