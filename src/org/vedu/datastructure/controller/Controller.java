package org.vedu.datastructure.controller;

import java.util.Scanner;

import org.vedu.datastructure.impl.ArrayList;
import org.vedu.datastructure.service.List;

public class Controller {
	public static void main(String...strings) {
		List<String> list = new ArrayList<>();
		
		try(Scanner sc = new Scanner(System.in)) {
			int op = 0;
			do {
				System.out.println("Options: ");
				System.out.println("1. Add");
				System.out.println("2. Remove");
				op = sc.nextInt();
				
				switch(op) {
					case 1 -> {
						System.out.printf("Add: ");
						list.append(sc.next());
					}
					case 2 -> {
						System.out.printf("Remove: ");
						list.remove(sc.nextInt());
					}
				}
				print(list);
				System.out.println("1 to continue or 0 to get out: ");
				op = sc.nextInt();
			} while (op != 0);
		} catch (Exception e) {
			throw e;
		}
		
		
		
		
	}

	public static void print(List<String> list) {
		for(int i = 0; i < list.getSize(); i++)
			System.out.println(list.get(i));
		
		System.out.println("Primeiro: " + list.getFirst());
		System.out.println("Último: " + list.getLast());
		
		System.out.println("Size: " + list.getSize());
		System.out.println();
	}
}
