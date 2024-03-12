package com.mashang.chater01.q06;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        File file = new File("myFile.txt");

        String data = in.readLine();

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                String content = new String(buffer, 0, bytesRead);
                System.out.print(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
