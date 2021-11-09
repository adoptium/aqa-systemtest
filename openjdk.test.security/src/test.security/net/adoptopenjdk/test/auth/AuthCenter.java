package net.adoptopenjdk.test.auth;

import com.sun.net.httpserver.*;
import net.adoptopenjdk.test.auth.util.AESUtil;

import java.io.*;
import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AuthCenter {

    public static void main(String[] args) throws Exception {
        InetSocketAddress addr = new InetSocketAddress(12001);
        HttpServer server = HttpServer.create(addr, 0);
        LoginHandler loginHandler = new LoginHandler();
        HttpContext ctx = server.createContext("/login", loginHandler);
        ctx.setAuthenticator(new BasicAuthenticator("adoptium@test.adoptium") {
            public boolean checkCredentials(String username, String pw) {
                return "user".equals(username) && "passphrase".equals(pw);
            }
        });

        TokenHandler tokenHandler = new TokenHandler();
        HttpContext tokenCtx = server.createContext("/token", tokenHandler);
        tokenCtx.setAuthenticator(new BasicAuthenticator("adoptium@test.adoptium") {
            public boolean checkCredentials(String username, String pw) {
                return "appid".equals(username) && "appsecret".equals(pw);
            }
        });

        ProtectedResourceHandler resourceHandler = new  ProtectedResourceHandler();
        HttpContext resourceCtx = server.createContext("/resource", resourceHandler);


        ExecutorService executor = Executors.newCachedThreadPool();
        server.setExecutor(executor);
        server.start();


    }

    public static boolean error = false;


    static class TokenHandler implements HttpHandler {
        public void handle(HttpExchange t)
                throws IOException {
            InputStream is = t.getRequestBody();
            OutputStream rawOut = t.getResponseBody();
            byte[] bytes = new byte[36];
            while (is.read(bytes) != -1) ;
            is.close();

            t.sendResponseHeaders(200, 200);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            HttpPrincipal p;

            try {
                int authCode = dataInputStream.readInt();
                p = authCodeMap.get(authCode);
            } finally {
                dataInputStream.close();
                byteArrayInputStream.close();
            }

            if (p != null) {
                try {
                    byte[] token = AESUtil.encrypt(p.getName() + p.getRealm());
                    rawOut.write(token);
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }
            }
            rawOut.close();
        }
    }


    static class LoginHandler implements HttpHandler {
        public void handle(HttpExchange t)
                throws IOException {
            InputStream is = t.getRequestBody();
            while (is.read() != -1) ;
            is.close();
            HttpPrincipal p = t.getPrincipal();
            if (!p.getUsername().equals("user")) {
                error = true;
            }
            if (!p.getRealm().equals("adoptium@test.adoptium")) {
                error = true;
            }
            t.sendResponseHeaders(200, 200);
            OutputStream rawOut = t.getResponseBody();
            int authCode = (p.getUsername() + p.getRealm()).hashCode() % 10000;
            authCodeMap.put(authCode, t.getPrincipal());

            ByteArrayOutputStream b = new ByteArrayOutputStream();
            try (DataOutputStream dataOutputStream = new DataOutputStream(b)) {
                dataOutputStream.writeInt(authCode);
                dataOutputStream.flush();
            }

            rawOut.write(b.toByteArray());
            rawOut.close();
        }
    }

    private static HashMap<Integer, HttpPrincipal> authCodeMap = new HashMap<>();

    static class ProtectedResourceHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            try {
                InputStream is = t.getRequestBody();
                byte[] bytes = new byte[32];
                while (is.read(bytes) != -1) ;
                is.close();
                if (!validToken(bytes)) {
                    t.sendResponseHeaders(401, 0);
                    t.close();
                }

                OutputStream rawOut = t.getResponseBody();
                ByteArrayOutputStream b = new ByteArrayOutputStream();
                try (DataOutputStream dataOutputStream = new DataOutputStream(b)) {
                    dataOutputStream.writeBytes("passed");
                    dataOutputStream.flush();
                }
                t.sendResponseHeaders(200, b.toByteArray().length);
                rawOut.write(b.toByteArray());
                rawOut.close();
            } catch (Exception e ){e.printStackTrace();}
        }

        private static boolean validToken(byte[] bytes) {
            try {
                String str = AESUtil.decrypt(bytes);
                for (HttpPrincipal value : authCodeMap.values()) {
                    if (str.equals(value.getName() + value.getRealm()))
                        return true;
                }

            } catch (Exception e) {
            }
            return false;

        }
    }

}
