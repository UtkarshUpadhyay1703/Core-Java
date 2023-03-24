package examples;

public class PrRp {
	static long solve(int X, int Y, String S) {
		// code here
		int x = 0, y = 0;
		long sum = 0;	
		if(X>Y) {
		while (S.contains("pr") || S.contains("rp")) {
				if (S.indexOf("pr") != -1) {
					S = S.replaceFirst("pr", "");
					x++;
					} else {
					S = S.replaceFirst("rp", "");
					y++;
				}
			}
		}else {
			while (S.contains("pr") || S.contains("rp")) {
				if (S.indexOf("rp") != -1) {
					S = S.replaceFirst("rp", "");
					y++;
					} else {
						S = S.replaceFirst("pr", "");
						x++;
					
				}
			}
		}
		
		sum = Long.valueOf(x * X + y * Y);
		return sum;

	}

	public static void main(String[] args) {
//		System.out.println(PrRp.solve(5, 4, "abppprrr"));
		System.out.println(PrRp.solve(10, 20, "lrrfrrprgprpppppmurr"));

	}

}
