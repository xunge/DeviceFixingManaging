//SLIAN
package edu.heusoft.DeviceFixingManaging.common;

public class StateUtil {
	
	public static int reportRecordStateToInt(String state){
		if(state.equals("进行中")) return 0;
		else if(state.equals("结束")) return 1;
		else if(state.equals("撤销")) return 2;
		else return -1;
	}
}
