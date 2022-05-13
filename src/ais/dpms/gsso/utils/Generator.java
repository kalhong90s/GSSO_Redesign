package ais.dpms.gsso.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import ec02.af.utils.AFLog;
import ec02.core.utils.NumberPool;

public class Generator {
	private static final AtomicLong atomicLong = new AtomicLong(0L);
	public static String generateInvoke(String session, String command) {
        StringBuilder invoke = new StringBuilder("");
        Random random = new Random();
        invoke.append("InvokeForSession:").append(session)
                .append(":WithMsgId:").append(atomicLong.getAndIncrement())
                .append(":").append(NumberPool.getInstance("1").getAtomicLong())
                .append(":").append(random.nextInt(10000))
                .append(":WithCommand:").append(command);
        return invoke.toString();
    }
	
	public static String generateOrderReference(String nodeName, ArrayList<String> listOrderReference) {
		String orderRefNumber = "";
		boolean isUnique = false;
		while (!isUnique) {

			StringBuilder result = new StringBuilder();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");// 20151122114411
			Date resultdate = new Date(System.currentTimeMillis());
			String date = sdf.format(resultdate);

			/* add node name 2 digit and date format yyyyMMddHHmmss 14 digit */
			result.append(nodeName).append(date);

			/* New require add random number 2 digit */
			for (int idx = 0; idx < 2; ++idx) {
				result.append(randomInteger());
			}
			orderRefNumber = result.toString();
			if (listOrderReference.size() > 0) {
				if (!listOrderReference.contains(orderRefNumber)) {
					isUnique = true;
				}
			}
			else {
				isUnique = true;
			}
		}
		listOrderReference.add(orderRefNumber);

		AFLog.d("ORDER REFERENCE GENERATE: " + orderRefNumber);

		return orderRefNumber;
	}
	
	private static int randomInteger() {
		int aStart = 0;
		int aEnd = 9;

		/** Initialize SecureRandom **/
		long range = (long) aEnd - (long) aStart + 1;	
		double randomDouble =  Math.random();
		long fraction = (long) (range * randomDouble);
		int randomNumber = (int) (fraction + aStart);

		return randomNumber;
	}
}
