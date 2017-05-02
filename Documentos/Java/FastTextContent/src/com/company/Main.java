package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
//	    Interface tmp = new Interface();
//	    tmp.showPanel();
        HttpGetRequest http = new HttpGetRequest();

        System.out.println("Testing 1 - Send Http GET request");
        http.getRequest("Hola");

        System.out.println("\nTesting 2 - Send Http POST request");
        http.getRequest("Avion");

    }
}
