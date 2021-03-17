package com.huawei.OD;


public class LongestHuiWenSubStr {
	public static String getLongestHuiWenSubStr(String s) {
		int strlen = s.length();
		int maxlen = 0;
		String max = "";
		if(strlen == 0 || null == s) {
			return "";
		}
		
		for(int i=0;i<strlen;i++) {
			for(int j=i;j<strlen;j++) {
				if(isHuiWenSubStr(s.substring(i, j+1)) && j+1-i > max.length()) {
					max = s.substring(i, j+1);
				}
			}
		}
		return max;

	}
	private static boolean isHuiWenSubStr(String str) {
		String d = new StringBuilder(str).reverse().toString();
		return str.equals(d);
	}
	
	//中心探测法--未完成
//	public static String ExpandFromCenter(String s) {
//		if(s == null ||s.length() <2){
//			return s;
//		}
		
		//给字符串填充分隔符以规避讨论字符串奇偶长度的问题
//		String tmp = "#";
//		for(char c:s.toCharArray()) {
//			tmp += c;
//			tmp += "#";
//		}
//		
//		int len = tmp.length();
//		int right  = 0;
//		int maxlen = 0;
//		int start = 0;
//		String maxsubstr = "";
//		
//		for(int left=right;right<len;right++) {
//			while(left>=0 && right < len && tmp.charAt(right)==tmp.charAt(left)) {
//				left --;
//				right ++;
//			}
//			
//			maxlen =(right-left-2)/2 > maxlen ? (right-left-2)/2:maxlen;
//			start = (left+2)/2;
//		}
//		
//		return s.substring(start,start+maxlen-1);
//	}
	
	
	
	
public static void main(String[] args) {
	long start,end;
	String s = "gphyvqruxjmwhonjjrgumxjhfyupajxbjgthzdvrdqmdouuukeaxhjumkmmhdglqrrohydrmbvtuwstgkobyzjjtdtjroqpyusfsbjlusekghtfbdctvgmqzeybnwzlhdnhwzptgkzmujfldoiejmvxnorvbiubfflygrkedyirienybosqzrkbpcfidvkkafftgzwrcitqizelhfsruwmtrgaocjcyxdkovtdennrkmxwpdsxpxuarhgusizmwakrmhdwcgvfljhzcskclgrvvbrkesojyhofwqiwhiupujmkcvlywjtmbncurxxmpdskupyvvweuhbsnanzfioirecfxvmgcpwrpmbhmkdtckhvbxnsbcifhqwjjczfokovpqyjmbywtpaqcfjowxnmtirdsfeujyogbzjnjcmqyzciwjqxxgrxblvqbutqittroqadqlsdzihngpfpjovbkpeveidjpfjktavvwurqrgqdomiibfgqxwybcyovysydxyyymmiuwovnevzsjisdwgkcbsookbarezbhnwyqthcvzyodbcwjptvigcphawzxouixhbpezzirbhvomqhxkfdbokblqmrhhioyqubpyqhjrnwhjxsrodtblqxkhezubprqftrqcyrzwywqrgockioqdmzuqjkpmsyohtlcnesbgzqhkalwixfcgyeqdzhnnlzawrdgskurcxfbekbspupbduxqxjeczpmdvssikbivjhinaopbabrmvscthvoqqbkgekcgyrelxkwoawpbrcbszelnxlyikbulgmlwyffurimlfxurjsbzgddxbgqpcdsuutfiivjbyqzhprdqhahpgenjkbiukurvdwapuewrbehczrtswubthodv\"";
	start = System.currentTimeMillis();
	System.out.println(getLongestHuiWenSubStr(s));
//	System.out.println(ExpandFromCenter(s));
	end = System.currentTimeMillis();
	System.out.println("耗时："+(end-start)+"ms");
	
}
}



