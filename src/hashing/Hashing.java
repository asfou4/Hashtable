/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author fitri ratna
 */
public class Hashing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        System.err.print("Masukan website : ");
        String website = "";
        website = x.readLine();
        
        String url_baru = "http://" + website;
        Document doc = Jsoup.connect(url_baru).get();
        //System.out.println(url_baru);
        Elements teks = doc.select("body");
        
        String a = teks.text();
        //System.out.println(a);
        String tes = a.replaceAll("dan", "").replaceAll("tapi", "").replaceAll("[&,|]", "").replaceAll("dengan", "").replaceAll("yang", "");
        //System.out.println(tes);
        StringTokenizer b = new StringTokenizer(tes, " ");
//        int c = 0;
        
        Vector<String> hasil = new Vector();
        Vector<String> hasil2 = new Vector();
        Vector hitung = new Vector();   
        
        while(b.hasMoreTokens()){
            hasil.add(b.nextToken());
            //System.out.println(b.nextToken());
        }
//        
        for (int i = 0; i < hasil.size(); i++) {
            //System.err.println(hasil.get(i));
            hasil2.add(hasil.get(i));
            //System.err.println(hasil2.get(i));
        }
               //System.out.println(c);
     
        Hashtable data = new Hashtable();
        
        
        for(Object key : hasil){
            int angka = 0;
            for(String key2 : hasil2){
                if(key.equals(key2)){
                    angka++;
                }
            }
            hitung.add(angka);
        }
        for (int i = 0; i < hasil.size(); i++) {
            data.put(hasil.get(i), hitung.get(i));
            //        System.out.println(data);
        }
        Enumeration k;
        k = data.keys();
        String akhir;
        while (k.hasMoreElements()) {
            akhir = (String) k.nextElement();
            System.out.println(akhir + ": " + data.get(akhir));
        }


     //=====================================================================
        
    }
    
}
