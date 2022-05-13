package ais.dpms.gsso.manager.statistic;

import ais.dpms.gsso.constants.EStat;
import ec02.af.utils.AFLog;
import phoebe.eqx.icarus.utility.Assistance;

public class Statistic {
	public static void increaseStatistic(Assistance assistance, EStat stat){
    	if(stat == null){
    		return;
    	}
    	assistance.incrementStats(stat.getStat());
        AFLog.d("[Stat] Write Stat : " + stat.getStat());
    }
}
