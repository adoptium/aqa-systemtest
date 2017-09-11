/*******************************************************************************
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/
/**
 * File:    SolverTest.java
 * Package: net.adoptopenjdk.test.util.solver
 */
   
/**
 * SolverTest
 * ================
 * 
 * The game this code was initially designed to solve consists of 36 square cards, which each have 4 symbols on them.
 * (Symbols are denoted by letters below).
 * The cards must be arranged in a 6x6 grid such the symbols on the edges of adjacent cards match up.
 * 
 * This test has historically caused the JIT to crash or give incorrect results from time to time
 */

package net.adoptopenjdk.test.util.solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

public class SolverTest extends TestCase {
	boolean stop = false;
	
	boolean horizontalCheck(Card left, Card right) { //Check if the cards in their current orientation may sit next to each other.
		if ( (left.contents.get(1) == right.contents.get(0)) && (left.contents.get(2) == right.contents.get(3)) ) {
			return true;
		}
		return false;
	}
	
	boolean verticalCheck(Card top, Card bottom) { //Check if the cards in their current orientation may sit next to each other.
		if ( (top.contents.get(2) == bottom.contents.get(1)) && (top.contents.get(3) == bottom.contents.get(0)) ) {
			return true;
		}
		return false;
	}
	
	Deck d = new Deck("SRLB","SLBR","FRBL","FBLR","SLAB","LSBA","FLAB","FBAL","BFAL","AFRL","SARL","AFKB",
							 "RBAF","BRFA","SRBA","KFLB","SBLR","AKLS","SRLK","KRAS","FLSA","SFAL","KALR","FLRS",
							 "FRSA","RASF","RFAS","RFBS","RFSB","ASFB","BFSA","FBSL","BLFS","ABRL","BLAR","ABLR");
	
	Set<Card> cardPool = d.cards; // a Deck, which is made up of all the cards currently available. We subtract from this as we go on.
	final Set<Card> masterCardPool = new HashSet<Card>(cardPool); //CREATE A COPY OF THE FULL SET OF CARDS, TO ITERATE OVER FOR POSITION (0,0)
	CardLayout cl = new CardLayout();
	
	int cardRow = 0;
	int cardCol = 0;
	Card lastCard;
	
	public static void main(String[] args) {
		SolverTest st = new SolverTest();
		st.processNextCard();
		st.validateAnswers();
	}
	
	public void testSolution() {
		SolverTest st = new SolverTest();
		st.processNextCard();
		st.validateAnswers();
	}
	
	public void validateAnswers() {
		assertTrue("Incorrect Answer was Found.",checkAnswer());
	}
	
	public boolean checkAnswer(){
		String[][][] allowedAnswers = {
				{	{"KSRL","SFLR","FBAL","BRFA","RASF","AKLS"},
					{"LRAB","RLSA","LABS","AFRB","FSBR","SLFB"}, 
					{"BAFK","ASRF","SBLR","BRSL","RBAS","BFLA"}, 
					{"KFLB","FRBL","RLAB","LSFA","SABF","ALSB"},
					{"BLAR","LBFA","BASF","AFRS","FBLR","BSRL"}, 
					{"RASK","AFLS","FSBL","SRFB","RLAF","LRKA"} },
				
				{	{"KRAS","RBLA","BKFL","KBAF","BLRA","LKSR"},
					{"SAFL","ALBF","LFRB","FASR","ARLS","RSFL"},
					{"LFSB","FBAS","BRLA","RSBL","SLAB","LFBA"},
					{"BSRF","SAFR","ALSF","LBRS","BAFR","ABRF"},
					{"FRLA","RFBL","FSAB","SRBA","RFSB","FRAS"},
					{"ALRK","LBSR","BALS","ABFL","BSLF","SAKL"} },
					
				{	{"KLSA","LFBS","FLAB","LSBA","SRLB","RKAL"},
					{"ASFR","SBRF","BASR","ABFS","BLRF","LAFR"},
					{"RFAB","FRBA","RSLB","SFAL","FRSA","RFBS"},
					{"BALF","ABSL","BLRS","LABR","ASFB","SBLF"},
					{"FLRS","LSAR","SRFA","RBLF","BFAL","FLSA"},
					{"SRLK","RABL","AFKB","FLBK","LARB","ASKR"} },
					
				{	{"KALR","AFRL","FBSR","BLFS","LSAF","SKRA"},
					{"RLBS","LRFB","RSAF","SFBA","FALB","ARBL"},
					{"SBAL","BFSA","FALS","ABRL","BLFR","LBKF"},
					{"LABF","ASRB","SLBR","LRSB","RFAS","FKBA"},
					{"FBSL","BRFS","RBAF","BSLA","SARL","ABLR"},
					{"LSAK","SFRA","FABR","ALFB","LRSF","RLKS"} } };
													
		for (String[][] soln : allowedAnswers) {
			boolean match = true;
			ROWLOOP: for (int i = 0; i < 6; i++){
				for (int j = 0; j < 6; j++) {
					if(!(cl.grid[i][j].toString().equals(soln[i][j]))) {
						match = false;
						//System.out.println("Match Fail at i"+i+" j"+j+" checking "+cl.grid[i][j]+" and "+soln[i][j]);
						break ROWLOOP; //Might aswell stop looping entirely as its already failed the test.
					}
				}//ITEMLOOP	
			}//ROWLOOP
			if (match) return true;
		}
		return false;
	}
	
	public void processNextCard() {
		if ((cardCol == 6) && (cardRow == 5)) {
			
			this.stop = true;
			return;
		}
		
		if (cardCol == 6) {
			cardCol = 0;
			cardRow++;
		}
				
		List<Card> miniDeck;
		
		if ((cardCol == 0) && (cardRow == 0)){
			miniDeck = new ArrayList<Card>(masterCardPool);//pick from any
		}
				
		else {
			if (cardCol == 0) {
				lastCard = cl.grid[cardRow-1][cardCol];
			}
			else { 
				lastCard = cl.grid[cardRow][cardCol-1];
			} 
			miniDeck = lastCard.definiteNeighbours;
		}
		
		for (Card crd : miniDeck) {
			if (!cardPool.contains(crd)){
				continue;
			}
			
			while (!stop) {
				if (((cardRow == 0) && ((cardCol == 0)||(horizontalCheck(cl.grid[cardRow][cardCol-1], crd)))) //1. Top left ok always. 2. Check horizontal only for top row.
						|| ((cardRow>0)&&(verticalCheck(cl.grid[cardRow-1][cardCol], crd))&&((cardCol==0)||(horizontalCheck(cl.grid[cardRow][cardCol-1], crd))))//3. Only check vertical for lhs, else both 
						){
						
						//If we get here, its allowed to take the next slot.
					cl.placeCard(cardCol, cardRow, crd);
					cardPool.remove(crd);
					lastCard = crd;
					cardCol++;
					processNextCard();
					if(stop) return;//return if we're done, continue on if we've jsut run out of cards or need to rotate.
				}
				if (!crd.rotate()) { //rotate again, if we're back at start, its no good so break out.
					break;
				}
			}
			//Run out of cards, so go backwards.
		}
		//we've now gone all the way through the cards without success, so dump the one we had
		Card removingCard;
		
		if ((cardCol == 0) && (cardRow > 0)) {
			removingCard = cl.grid[cardRow-1][5]; //Get a reference to the card we want to remove, have to jump rows for this case.
			cardCol = 5; cardRow--; //And reset the indexing back a card, ready to re-place.
		}
		else {
			removingCard = cl.grid[cardRow][cardCol-1];//Get a reference to the card we want to remove, just move along 1 left.
			cardCol--;//And reset the indexing back a card, ready to re-place.
		}
		cardPool.add(removingCard); //Put it back into the card pool.
	}
}

class CardLayout {
	Card[][] grid = new Card[6][6];
	
	void placeCard(int column, int row, Card card) {
		grid[row][column] = card;
	}
}

class Card {
	List<Integer> contents = new ArrayList<Integer>(); //Must not use HashSet here as order matters. Would have tiny buckets anyway.
	List<Card> definiteNeighbours = new ArrayList<Card>(); //Could use HashSet here, but ArrayList seems just as fast -probably as we don't waste cycles generating hashcodes,
																//and the searching won't really get sped up with so few items in the collection.
	private int rotations = 0;
	
	public Card(String s) {
		for (int i = 0; i < 4; i++){
			contents.add((int)s.charAt(i)); //Go through each letter and store it in an array list of integers, char->int->Integer
		}
	}
	
	public String toString() { //We want a card holding "ABCD" to be displayed as such.
		String result = "";
		Iterator<Integer> iterator = contents.iterator();
		for (int i = 0; i < 4; i++){
			result += (char)(int)iterator.next(); //Pull the Integer out, convert to int so we can then treat it as a char again.
		}
		return result;
	}
	
	public boolean rotate() { // return false when no more rotations left.
		rotations++;
		quietRotate();
		
		if (rotations == 4) {
			rotations = 0;
			return false; //we're back at the start.
		}
		return true;
	}
	
	private void quietRotate() { //Doesn't return, and doesn't update the rotation counter. Use this for the pre-caching, as initial rotation is arbitrary.
		Collections.rotate(contents,1);
	}
	
	public void findNeighbours(Set<Card> cards) {
		for (Card cd : cards) {
			if ((cd != this) && !this.definiteNeighbours.contains(cd)){ //We know we match ourself! Then check its not already a known neighbour.
				if (this.rotateAndFit(cd)){
					this.definiteNeighbours.add(cd);
					cd.definiteNeighbours.add(this);
				}
			}
		}
	}
	
	public boolean rotateAndFit(Card cr) { //check if two cards can possibly sit together
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 4; i++) {
				if( (cr.contents.get(0) == this.contents.get(1)) && (cr.contents.get(3) == this.contents.get(2)) ) {
					return true;
				}
				cr.quietRotate();
			}
			this.quietRotate();
		}
		return false;
	}
}

class Deck {
	Set<Card> cards = new HashSet<Card>();
	
	public Deck(String... inputs) {
		for (String s : inputs) {
			this.cards.add(new Card(s));		
		}
		// Deck is made, now lets cache some possible neighbours.
		for (Card cd : cards) {
			cd.findNeighbours(cards); //Hold a list of allowed neighbours.
		}
	}
}