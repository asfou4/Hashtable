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

public class Hashing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        input();
    }

    private static void input() throws IOException {
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Masukan website : ");
        String website = x.readLine();
        parsing(website);
    }

    private static void parsing(String url) throws IOException {
        url = "http://" + url;
        Document doc = Jsoup.connect(url).timeout(0).get();
        Elements text = doc.select("body");
        String teks = text.text();
        teks = teks.replaceAll("[(-+.^:,'|&?!)]", "").replaceAll("yang", "").replaceAll("dengan", "").replaceAll("dan", "").replaceAll("dari", "");
        String[] kata = teks.split(" ");

        //-----------------------------------
        String[] kata1 = new String[kata.length];
        for (int i = 0; i < kata.length; i++) {
            kata1[i] = kata[i];
        }

        Vector<String> index_kata = new <String>Vector();
        Vector<Integer> hitung_kata = new <Integer>Vector();
        for (int i = 0; i < kata1.length; i++) {
            int hitung = 0;
            for (int j = 1; j < kata.length; j++) {
                if (kata1[i].equals(kata[j])) {
                    hitung++;
                }
            }
            if (index_kata.size() == 0) {
                index_kata.add(kata1[i]);
                hitung_kata.add(hitung);
            } else {
                int ada = 0;
                for (int j = 0; j < index_kata.size(); j++) {
                    if (kata1[i].equals(index_kata.get(j))) {
                        ada++;
                    }
                }

                if (ada == 0) {
                    index_kata.add(kata1[i]);
                    hitung_kata.add(hitung);
                }
            }
        }

//        for (int i = 0; i < kata1.length; i++) {
//            System.out.println(kata1[i]);
//        }

        System.out.println(kata.length + "<>" + index_kata.size());
        Hashtable tabel_kata = new Hashtable();
        for (int i = 0; i < index_kata.size(); i++) {
            System.out.println(index_kata.get(i) + "=" + hitung_kata.get(i));
            tabel_kata.put(index_kata.get(i),hitung_kata.get(i));
        }
        
        
    }

}
