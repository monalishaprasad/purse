package com.service;

import com.cards.Card;
import com.cards.DebitCard;
import com.purse.Purse;

public class Calculator {

	private static long amount = 0;
	private int totalCash;
	
	public long calculateCash(Purse purse) {
		
		
		purse.getNotes().forEach(e -> {
			amount = amount + e.getNum();
		});
		
		purse.getCoins().forEach(e -> {
			amount = amount + e.getNumber();
		});
		
		
		return amount;
	}
	
	public long bankbalance(Purse purse) {
		
		calculateCash(purse);
		
		purse.getCard().forEach(e->{
			
			DebitCard dc =  (DebitCard)e;
			amount = amount + dc.getBalance();
			
			
		});
		
		return totalCash;
	}
	

 public int numberOfCards(Purse purse) {
	 
	 //int count = 0;
	 long sum=0;
	 for(Card card : purse.getCard()){
//		 if(card instanceof DebitCard)count++;
		 
		 if(card instanceof DebitCard) {
		 DebitCard db =(DebitCard)card;
		  sum=sum+db.getBalance();
		 }
	 }
	 
	return purse.getCard().size();
 }	
public int numberOfSlips(Purse purse){
	
	return purse.getSlips().size();
}
 
 }