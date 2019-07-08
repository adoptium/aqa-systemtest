package net.adoptopenjdk.test.bigdecimal;

public class JavaSpecVersionChecker {
	public static boolean isJDK13OrNewer() {
		String specVersion = System.getProperty("java.specification.version"); 
		try { 
			return Integer.parseInt(specVersion) > 12; 
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false; 
		}
	}
}
