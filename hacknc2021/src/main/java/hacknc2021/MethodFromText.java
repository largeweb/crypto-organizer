package hacknc2021;

import java.util.ArrayList;

public class MethodFromText {
	
	private String[] m1list = {"big"};
	private String[] m2list = {"small"};
//	private ArrayList<String> m1keywords, m2keywords;
	
	public MethodFromText() {
//		for(int i=0; i<m1list.length; i++) {
//			m1keywords.add(m1list[i]);
//		}
//		for(int i=0; i<m2list.length; i++) {
//			m2keywords.add(m1list[i]);
//		}
	}
	
	public String findMethodToRun(String[] stringlist) {
		int m1match = 0;
		int m2match = 0;
		for(int i=0; i<stringlist.length; i++) {
			for(int j=0; j<m1list.length; j++) {
				if(stringlist[i].equals(m1list[j])) {
					m1match += 1;
				}
			}
			for(int j=0; j<m2list.length; j++) {
				if(stringlist[i].equals(m2list[j])) {
					m2match += 1;
				}
			}
		}
		if(m1match > m2match) {
			return "m1chart";
		}
		if(m2match > m1match) {			
			return "m2chart";
		}
		if(m1match == m2match) {
			return "equalmatch";
		}
		return "nomatch";
	}

}
