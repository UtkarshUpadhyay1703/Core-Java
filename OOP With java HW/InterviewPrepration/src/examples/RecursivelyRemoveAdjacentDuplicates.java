package examples;

public class RecursivelyRemoveAdjacentDuplicates {
	public static String rremove(String s) {
		String[] arr = s.split("");
//		int count = 1;
		String str="";
		String ans="";
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				str+=arr[i];
				for (int j = i; j < arr.length - 1; j++) {
					if (arr[j] != arr[j + 1]) {
//						count++;
						break;
					}else {
					str += arr[j];
					}
				}
				s=s.replace(str, "");
				ans=rremove(s);
				break;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(RecursivelyRemoveAdjacentDuplicates.rremove("geeksforgeek"));

	}

}
