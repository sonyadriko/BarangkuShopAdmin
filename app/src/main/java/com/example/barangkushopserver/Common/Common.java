package com.example.barangkushopserver.Common;

import com.example.barangkushopserver.Object.Request;
import com.example.barangkushopserver.Object.User;
import com.example.barangkushopserver.Remote.APIService;
import com.example.barangkushopserver.Remote.FCMRetrofitClient;
import com.example.barangkushopserver.Remote.RetrofitClient;

public class Common {
    public static User currentUser;
    public static Request currentRequest;

    public static final String UPDATE = "Update";
    public static final String DELETE = "Delete";


    public static final int PICK_IMAGE_REQUEST = 71;

    public static String convertCodeToStatus(String code){
        if (code.equals("0"))
            return "Placed";
        else if (code.equals("1"))
            return "On Procced";
        else
            return "Shipped";
    }

    public static final String fcmURL = "https://fcm.googleapis.com/";

    public static APIService getFCMClient(){
        return FCMRetrofitClient.getClient(fcmURL).create(APIService.class);
    }
}
