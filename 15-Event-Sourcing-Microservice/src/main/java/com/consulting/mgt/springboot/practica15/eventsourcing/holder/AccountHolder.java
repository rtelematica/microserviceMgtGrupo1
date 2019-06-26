package com.consulting.mgt.springboot.practica15.eventsourcing.holder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.consulting.mgt.springboot.practica15.eventsourcing.domain.Account;

public class AccountHolder {

	private static final Map<Integer, Account> accounts = new HashMap<>();

	private static final AtomicLong nextSequenceId = new AtomicLong(0);

	private static final AtomicInteger nextAccountId = new AtomicInteger(0);

	public static long nextSequenceId() {
		return nextSequenceId.incrementAndGet();
	}
	
	public static void setSequenceId(long newValue) {
		nextSequenceId.set(newValue);
	}
	
	public static void setAccountId(int newValue) {
		nextAccountId.set(newValue);
	}

	public static int nextAccountId() {
		return nextAccountId.incrementAndGet();
	}

	private AccountHolder() {
	}

	public static void putAccount(Account account) {
		accounts.put(account.getAccountNo(), account);
	}

	public static Account getAccount(int accountNo) {
		Account account = accounts.get(accountNo);

		if (account == null) {
			return null;
		}

		return account.clone();
	}

	public static Map<Integer, Account> getAll() {
		return new HashMap<Integer, Account>(accounts);
	}

	public static Account getAccount(String owner) {
		Iterator<Entry<Integer, Account>> it = accounts.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry<Integer, Account> pair = (Entry<Integer, Account>) it.next();

			// System.out.println(pair.getKey() + " = " + pair.getValue());

			if (owner.trim().equals(pair.getValue().getOwner())) {
				return pair.getValue().clone();
			}
		}
		return null;
	}

	public static void resetState() {
		accounts.clear();
		nextSequenceId.set(0);
	}
}
