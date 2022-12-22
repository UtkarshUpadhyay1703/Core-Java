package tester;

import static utils.BankingUtils.populateBankAccounts;

import java.util.Map;
import java.util.TreeMap;

import com.app.banking.BankAccount;

public class SortAccountsByAcctNoAsc {

	public static void main(String[] args) {
		try {
			// get sample data
			Map<Integer, BankAccount> accounts = populateBankAccounts();
			System.out.println("All accounts ");
			for (BankAccount a : accounts.values())
				System.out.println(a);
			System.out.println("Sorted accts as per acct no ");
			TreeMap<Integer,BankAccount> sortedMap=new TreeMap<>(accounts);
			//in above stmt : JVM will invoke : Integer's compareTo
			//display treemap
			for (BankAccount a : sortedMap.values())
				System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
