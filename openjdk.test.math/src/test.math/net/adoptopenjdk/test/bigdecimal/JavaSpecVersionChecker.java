package net.adoptopenjdk.test.bigdecimal;

public class JavaSpecVersionChecker {
	public static boolean isJDKWithin13And19() {
		try {
			int specVersion = Integer.parseInt(System.getProperty("java.specification.version")); 
			return (specVersion > 12 && specVersion < 20); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false; 
		}
	}
}
