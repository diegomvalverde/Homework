package com.company;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


class HttpGetRequest
{

    private final String USER_AGENT = "Mozilla/5.0";


    void getRequest(String tmp) throws Exception {                          // Metodo para realizar un request a Google.

        String url = "http://www.google.com/search?q=" + tmp;               // Url con la que llamamos al Google

        URL obj = new URL(url);                                             // Objeto URL
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");                                        // Pedimos la info del servidor

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);                // Le enviamos la info del "Navegador"

        int responseCode = con.getResponseCode();                           // Obtenemos lo que devuelve Google
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }


}
