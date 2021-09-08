package net.adoptopenjdk.test.auth;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TestEnumSupportedProtocols assert current vm supports:
 * TLSv1.3
 * TLSv1.2
 * TLSv1.1
 * TLSv1
 * SSLv3
 * SSLv2Hello
 */
public class EnumSupportedProtocols {
    private static final String[] PROTOCOLS = new String[]{
            "TLSv1.3",
            "TLSv1.2",
            "TLSv1.1",
            "TLSv1",
            "SSLv3",
            "SSLv2Hello"
    };

    public static void supportedProtocols() throws Exception {
        SSLContext ctx = SSLContext.getDefault();
        SSLParameters params = ctx.getSupportedSSLParameters();
        Set<String> supportedProtocols = Arrays.stream(params.getProtocols()).collect(Collectors.toSet());
        for (String supportedProtocol : supportedProtocols) {
            System.out.println(supportedProtocol);
        }

        for (String protocol : PROTOCOLS) {
            if (!supportedProtocols.contains(protocol)) {
                if (protocol != "TLSv1.3") {
                    throw new RuntimeException("protocol is TLSv1.3");
                }

                String javaVersion = System.getProperty("java.version");
                /**
                 * According to https://docs.oracle.com/javase/8/docs/technotes/guides/security/jsse/JSSERefGuide.html#enabling-tls-1.3
                 * TLS: version 1.0, 1.1, 1.2, and 1.3 (since JDK 8u261)
                 */
                if (!javaVersion.startsWith("1.8.0") || Integer.parseInt(javaVersion.split("_")[1]) >= 261) {
                    throw new RuntimeException(protocol + " is not supported in " + javaVersion);
                }
            }
        }
    }
}
