package net.adoptopenjdk.test.auth;

import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.security.KeyStore;

public class Client {
    private static String key;
    private static String protocol;

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("please pass testKey spec as 1st argument");
            System.exit(-1);
        }
        key = args[0];
        protocol = args[1];

        java.net.Authenticator.setDefault(PASSWORD);
        URL url = new URL("http://localhost:12001/login/foo.html");
        HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
        InputStream is = urlc.getInputStream();
        byte[] token = new byte[32];
        while (is.read(token) != -1) {
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(token);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        int authCode;
        try {
            authCode = dataInputStream.readInt();
        } finally {
            byteArrayInputStream.close();
            dataInputStream.close();
        }

        System.out.println("log in YES!");
        System.out.println(authCode);

        URL request = new URL("https://localhost:12234/request/foo.html");
        HttpURLConnection urlConnection = (HttpURLConnection) request.openConnection();
        if (urlConnection instanceof HttpsURLConnection) {
            HttpsURLConnection urlcs = (HttpsURLConnection) urlConnection;
            urlcs.setSSLSocketFactory(getSSLContext().getSocketFactory());
            urlcs.setHostnameVerifier((hostname, session) -> true);
        }
        urlConnection.setDoOutput(true);
        urlConnection.setRequestMethod("POST");

        OutputStream os = new BufferedOutputStream(urlConnection.getOutputStream());
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        try (DataOutputStream dataOutputStream = new DataOutputStream(b)) {
            dataOutputStream.writeInt(authCode);
        }
        os.write(b.toByteArray());
        os.close();

        int resp = urlConnection.getResponseCode();

        InputStream resultStream = urlConnection.getInputStream();
        byte[] result = new byte[32];
        while (resultStream.read(result) != -1) {
        }

        if (!new String(result).startsWith("passed")) {
            throw new RuntimeException("unexpected result" + new String(result));
        }

        return;
    }

    private static final Authenticator PASSWORD = new java.net.Authenticator() {
        public PasswordAuthentication getPasswordAuthentication() {
            PasswordAuthentication pw;
            pw = new PasswordAuthentication("user", "passphrase".toCharArray());
            return pw;
        }
    };

    private static SSLContext getSSLContext() throws Exception {
        String tlsType = System.getProperty("test.security.tls.type", protocol);
        char[] passphrase = "passphrase".toCharArray();

        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream(key), passphrase);

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, passphrase);

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(ks);

        SSLContext ctx = SSLContext.getInstance(tlsType);
        ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        return ctx;
    }


}