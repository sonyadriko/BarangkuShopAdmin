package com.example.barangkushopserver.Common;

import com.example.barangkushopserver.Object.Request;
import com.example.barangkushopserver.Object.User;
import com.example.barangkushopserver.Remote.APIService;
import com.example.barangkushopserver.Remote.FCMRetrofitClient;
import com.example.barangkushopserver.Remote.RetrofitClient;

import java.util.Calendar;
import java.util.Locale;

public class Common {
    public static User currentUser;
    public static Request currentRequest;

    public static final String UPDATE = "Update";
    public static final String DELETE = "Delete";


    public static final int PICK_IMAGE_REQUEST = 71;
    public static String PHONE_TEXT = "userPhone";

    public static String convertCodeToStatus(String code){
        if (code.equals("0"))
            return "Menunggu Pembayaran";
        else if (code.equals("1"))
            return "Pembayaran Berhasil";
        else if (code.equals("2"))
            return "Sedang di Proses Admin";
        else
            return "Transaksi Selesai";
    }

    public static final String fcmURL = "https://fcm.googleapis.com/";

    public static APIService getFCMClient(){
        return FCMRetrofitClient.getClient(fcmURL).create(APIService.class);
    }

    public static String getDate(long time) {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        StringBuilder date = new StringBuilder(
                android.text.format.DateFormat.format("dd-MM-yyyy HH:mm", calendar).toString());
        return date.toString();
    }
}
