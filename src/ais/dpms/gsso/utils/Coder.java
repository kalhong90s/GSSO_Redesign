package ais.dpms.gsso.utils;

import phoebe.externalib.apache.commons.lang.StringEscapeUtils;

public class Coder {
	 
	public static String decodeEscapeCharacters(String nonXmlText) {
   	try {
   		String decodeEscapeCharacters = StringEscapeUtils.unescapeXml(nonXmlText);
   		return decodeEscapeCharacters;
   		
//   		String decodeEscapeCharacters = nonXmlText
//					.replaceAll("&amp;", "&")
//					.replaceAll("&quot;", "\"")
//					.replaceAll("&apos;", "'")
//					.replaceAll("&lt;", "<")
//					.replaceAll("&gt;", ">");
//			return decodeEscapeCharacters;
		} catch (Exception e) {
			return nonXmlText;
		}
   }
	
	public static String encodeEscapeCharacters(String nonXmlText) {
   	try {
   		String encodeEscapeCharacters = StringEscapeUtils.escapeXml(nonXmlText);
			return encodeEscapeCharacters;
//			
//			String encodedXmlText = nonXmlText
//					.replaceAll("&", "&amp;")
//					.replaceAll("\"", "&quot;")
//					.replaceAll("'", "&apos;")
//					.replaceAll("<", "&lt;")
//					.replaceAll(">", "&gt;");
//			return encodedXmlText;
		} catch (Exception e) {
			return nonXmlText;
		}
   }
}
