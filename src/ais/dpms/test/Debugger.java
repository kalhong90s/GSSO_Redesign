package ais.dpms.test;

import phoebe.eqx.icarus.debug.DebugTool;

public class Debugger {
	public static void main(String[] args) {
		String testName = "GSSO";
		String configFile = "./conf/gsso.EC02.gsso.0";
		String requestMsgFile = "./dummy/eqxmsg.xml";
		String homeDirectory = "./";
		String libraryDirectory = "./jar";

		DebugTool.runModernDebug(testName, configFile, requestMsgFile, homeDirectory, libraryDirectory, false);
		
	}
}