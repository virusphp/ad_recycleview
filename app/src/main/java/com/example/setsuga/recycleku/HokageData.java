package com.example.setsuga.recycleku;

import java.util.ArrayList;

public class HokageData {
    public static String[][] data = new String[][]{
            {"Hasirama Senju", "Hokage Pertama Konoha", "http://2.bp.blogspot.com/_lMgDZXkNegQ/TPYSbhNrUjI/AAAAAAAAAjA/71IWGYKd9MY/s200/hokage+pertama.jpg"},
            {"Tobirama Senju", "Hokage Kedua Konoha", "https://1.bp.blogspot.com/_x2ahpm8L_GI/Rmadhp0U3hI/AAAAAAAAABc/ZcK-WtgONTg/s320/2hokage.jpg"},
            {"Sarutobi", "Hokage Ketiga Konoha", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGd0kneSHI-9eiVCd5avv6tD5MFVspzDxx2RCbLfX6EQGVH59l9A"},
            {"Minato Namikaze", "Hokage Keempat Konoha", "http://rs259.pbsrc.com/albums/hh316/Hyenn/naruto_wallpaper_12msolata.jpg~c200"},
            {"Tsunade", "Hokage Kelima Konoha", "http://narutopedia.ru/w/images/thumb/f/fd/Tsunade_Hokage.jpg/300px-Tsunade_Hokage.jpg"},
            {"Kakashi", "Hokage Keenam Konoha", "https://pp.userapi.com/c840228/v840228858/8b8ff/OTIQdy2xyZE.jpg"},
            {"Uzumaki Naruto", "Hokage Ketujuh Konoha", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSd5_s9gRp-JtQSl7-eGu2-437nFU71_EIr-0gzv6qCtqULt6S9"}
    };

    public static ArrayList<Hokage> getListData() {
        Hokage hokage = null;
        ArrayList<Hokage> list = new ArrayList<>();
        for (int i = 0; i <data.length; i++) {
            hokage = new Hokage();
            hokage.setNama(data[i][0]);
            hokage.setRemarks(data[i][1]);
            hokage.setFoto(data[i][2]);

            list.add(hokage);
        }

        return list;
    }
}
