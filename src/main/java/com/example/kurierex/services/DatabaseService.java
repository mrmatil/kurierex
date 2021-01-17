package com.example.kurierex.services;

import com.example.kurierex.models.DatabaseUserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DatabaseService implements Runnable{

    private FirebaseService fbs = null;
    private DatabaseReference ref = null;

    @Override
    public void run() {
        try {
            fbs = new FirebaseService();
            ref = fbs.getDb().getReference("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addRequest(DatabaseUserModel databaseUserModel) {
        List<DatabaseUserModel> databaseUserModelList = new LinkedList<>();
        databaseUserModelList.add(databaseUserModel);

        ref.child("/"+generateRandomString()).setValue(databaseUserModelList, (databaseError, databaseReference) -> {

        });
    }

    public String generateRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 20;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
