package ds.test;

import java.io.StringReader;
import java.util.Scanner;

import ds.hash.HashTable;

public class Main {
	static int TableSize = 1001;
	private static final int ERROR = -1;
	private static final int INSERT = 0;
	private static final int FIND = 1;
	private static final int START = 2;
	private static final int PRINT = 3;

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		HashTable hashtable = new HashTable(TableSize);
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			if(line.equals("exit")){
				break;
			}
			Scanner i_scanner = new Scanner(new StringReader(line));
			String cmd = i_scanner.next();
			int value = 0;
			int c1 = 0, c2 = 0, c3 = 0;
			int k = 0;
			String type = null;
			
			switch(getCommandNum(cmd)){
			case INSERT:
				value = i_scanner.nextInt();
				hashtable.Insert(value);
				break;
			case FIND:
				value = i_scanner.nextInt();
				int idx = hashtable.find(value);
				System.out.println("FIND: "+idx);
				break;
			case START:
				type = i_scanner.next();
				c1 = i_scanner.nextInt();
				c2 = i_scanner.nextInt();
				c3 = i_scanner.nextInt();
				hashtable.Start(type, c1, c2, c3);
				break;
			case PRINT:
				hashtable.print();
				break;
			case ERROR:
				System.out.println("Error");
				break;
			}
			i_scanner.close();
		}
		scanner.close();
	}
	
	private static int getCommandNum(String cmd){
		if(cmd.equals("insert"))
			return INSERT;
		else if(cmd.equals("find"))
			return FIND;
		else if(cmd.equals("start"))
			return START;
		else if(cmd.equals("print"))
			return PRINT;
		else
			return ERROR;
	}

}
