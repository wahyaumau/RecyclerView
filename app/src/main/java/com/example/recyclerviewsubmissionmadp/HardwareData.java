package com.example.recyclerviewsubmissionmadp;

import java.util.ArrayList;

public class HardwareData {
    public static String[][] datas = new String[][]{
            {"Mouse", "Hardware for pointing cursor", "Input device", "mouse", String.valueOf(12000)},
            {"Monitor", "Hardware for displaying data", "Output device", "monitor", String.valueOf(42380)},
            {"Printer", "Hardware for print data to paper", "Output device", "printer", String.valueOf(41420)},
            {"Scanner", "Hardware for scan picture to computer","Input Device", "scanner",String.valueOf(32221)},
            {"Server", "Hardware for storing large data", "Storage Device","server",String.valueOf(32221)},
            {"Processor", "Hardware for processing some process in computer", "Processing Device", "processor",String.valueOf(90898)},
            {"Memory", "Hardware for storing data", "Storage Device", "memory",String.valueOf(76755)},
            {"Keyboard", "Hardware for inputing data to computer", "Input Device", "keyboard",String.valueOf(87656)},
            {"Projector", "Hardware for displaying data from computer to surface", "Output Device", "projector",String.valueOf(98776)},
            {"VR Glasses", "Hardware for displaying data in form of glasses", "Output Device", "vr",String.valueOf(221)},
            {"Speaker", "Hardware for playing sound from computer", "Output Device", "speaker",String.valueOf(1212)},
            {"RAM", "Hardware for storing some temporary data to doing some process", "Storage Device", "ram",String.valueOf(12323)},
    };

    public static ArrayList<Hardware> getListData(){
        Hardware hardware;
        ArrayList<Hardware> list = new ArrayList<>();
        for (String[] data : datas) {
            hardware = new Hardware();
            hardware.setName(data[0]);
            hardware.setDescription(data[1]);
            hardware.setType(data[2]);
            hardware.setPhoto(data[3]);
            hardware.setPrice(Float.parseFloat(data[4]));
            list.add(hardware);
        }

        return list;
    }
}
