package net.adoptopenjdk.test.auth;

import com.sun.net.httpserver.*;
import net.adoptopenjdk.test.auth.util.AESUtil;

import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.net.Authenticator;
import java.security.KeyStore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
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
        InetSocketAddress addr = new InetSocketAddress(12234);
        HttpsServer server = HttpsServer.create(addr, 0);
        server.setHttpsConfigurator(new HttpsConfigurator(getSSLContext()));
        ServerHandler serverHandler = new ServerHandler();
        HttpContext ctx = server.createContext("/request", serverHandler);
        ExecutorService executor = Executors.newCachedThreadPool();
        server.setExecutor(executor);
        server.start();
        return ;
    }

    private static class ServerHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            InputStream is = t.getRequestBody();
            byte[] bytes = new byte[256];
            while (is.read(bytes) != -1) ;
            is.close();

            t.sendResponseHeaders(200, 200);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            try {
                int authCode = dataInputStream.readInt();
                byte[] token = getCachedToken(authCode);
                byte[] resource = getProtectedResource(token);
                t.getResponseBody().write(resource);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                dataInputStream.close();
                byteArrayInputStream.close();
            }
            t.close();

        }
    }

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

    private static byte[] getCachedToken(int authCode) throws IOException {
        URL url = new URL("http://localhost:12001/token/foo.html");
        HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
        urlc.setDoOutput(true);
        OutputStream outputStream = urlc.getOutputStream();
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        try (DataOutputStream dataOutputStream = new DataOutputStream(b)) {
            dataOutputStream.writeInt(authCode);
            dataOutputStream.flush();
        }
        outputStream.write(b.toByteArray());
        InputStream is = urlc.getInputStream();
        byte[] token = new byte[32];
        while (is.read(token) != -1) {
        }
        return token;
    }

    private static byte[] getProtectedResource(byte[] token) throws IOException {
        URL url = new URL("http://localhost:12001/resource/foo.html");
        HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
        urlc.setDoOutput(true);
        urlc.getOutputStream().write(token);
        InputStream is = urlc.getInputStream();
        byte[] result = new byte[32];
        while (is.read(result) != -1) {
        }
        return result;
    }

    private static final Authenticator PASSWORD = new java.net.Authenticator() {
        public PasswordAuthentication getPasswordAuthentication() {
            PasswordAuthentication pw;
            pw = new PasswordAuthentication("appid", "appsecret".toCharArray());
            return pw;
        }
    };

}
