package com.example.barangkushopserver.Service;

import com.example.barangkushopserver.Common.Common;
import com.example.barangkushopserver.Object.Token;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshToken = FirebaseInstanceId.getInstance().getToken();
        updateToRefresh(refreshToken);
    }

    private void updateToRefresh(String refreshToken) {
        if (Common.currentUser != null) {

            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference tokens = db.getReference("Tokens");
            Token data = new Token(refreshToken, true);
            tokens.child(Common.currentUser.getPhone()).setValue(data);
        }
    }
}
