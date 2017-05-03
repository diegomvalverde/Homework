package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


class HttpGetRequest extends Thread
{
    private final String USER_AGENT = "Mozilla/5.0";
    private String StringToFind;

    public void run()
    {

        String url = "http://www.google.com/search?q=" + StringToFind;               // Url con la que llamamos al Google
        try {
            sleep(1);
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

            // Generando un objeto html
            MyHtml tmp = new MyHtml();
            tmp.setName(StringToFind);
            tmp.setHtml(response.toString());

            CacheMemory cache = CacheMemory.getInstance();
            cache.add(StringToFind, tmp);

            //print result
            System.out.println(response.toString());
        }catch(IOException | InterruptedException e)
        {
            e.printStackTrace();
        }

    }



    void getRequest(String pTmp)
    {
        this.StringToFind = pTmp;
    }


}
