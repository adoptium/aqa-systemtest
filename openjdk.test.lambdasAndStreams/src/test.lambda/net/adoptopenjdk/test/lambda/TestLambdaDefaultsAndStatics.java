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

package net.adoptopenjdk.test.lambda;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;

import org.junit.Test;

/** 
 * This test aims to exercise interfaces with multiple default methods.
 * 
 * It has tests covering: 
 *   o classes with default methods.
 *   o overridden default methods.
 *   o interfaces with static methods.
 */
public class TestLambdaDefaultsAndStatics {

	// Create some interfaces and subclasses, so that the test has a variety of 
	// default, static and overridden methods available.	
	interface IMoneyMarket {
		// A default method which is only declared once.
		default String getCurrencyIMM() { 
			return "USD";
		}
		
		// A default method which is overridden at every opportunity.
		default String getDepartment() { 
			return "DX12";
		}
		
		// A static method which is declared in several locations
		static double biggest(double d1, double d2) { 
			return d1 - d2;
		}
		
		default double getCommissionRate() { 
			return 0.5;
		}
	}
	
	interface ITransaction {
		// A default method which is only declared once.
		default String getCurrencyIT() { 
			return "AUD";
		}

		// A default method which is overridden at every opportunity.
		default String getDepartment() { 
			return "DA87";
		}
		
		// A static method which is declared in several locations
		static double biggest(double d1, double d2) { 
			return d1 + d2;
		}
		
		static double highestPrice(double price1, double price2) {
			if (price1 > price2) {
				return price1;
			} else {
				return price2;
			}
		}
	}
	
	interface IShareTrade extends IMoneyMarket, ITransaction {
		// A default method which is only declared once.
		default String getCurrencyIST() { 
			return "GBP";
		}
		
		default String getCurrency() { 
			return "GBP";
		}

		// A default method which is overridden at every opportunity.
		default String getDepartment() { 
			return "DQ08";
		}

		// A static method which is declared in several locations
		static double biggest(double d1, double d2) {
			return d1 + ((d2 - d1) / 2);
		}
		
		// Default implementation supplied in IMoneyMarket but make it abstract again
		abstract double getCommissionRate();
		
		abstract double getPrice();
		abstract double getQuantity();
		abstract double getTotalValue();

		// Sort by currency name and then total value of the trade
		static Comparator<? super IShareTrade> getStandardComparator() {
			return Comparator
						.comparing(IShareTrade::getCurrency)
						.thenComparing(Comparator.comparing(IShareTrade::getTotalValue));
		}
	}
	
	interface IExchange {
		default String getExchangeLocation() { 
			return "London";
		}
		
		// A default method which is overridden at every opportunity.
		default String getDepartment() { 
			return "DV56";
		}
	}
	
	static class LocalShareTrade implements IShareTrade, IExchange {
		String stock;
		double price;
		int quantity;

		// Create some lambdas instead of the usual code inside a method 
		Function<LocalShareTrade, String> toStringFunction = (ist) -> stock + " " + quantity + "@" + price;
		Function<LocalShareTrade, Double> totalValueFunction = (ist) -> price * quantity;
		
		public LocalShareTrade() {
		}
		
		public LocalShareTrade(String stock, double price, int quantity) {
			this.stock = stock;
			this.price = price;
			this.quantity = quantity;
		}
		
		// A static method which is declared in several locations
		static double biggest(double d1, double d2) { 
			if (d1 > d2) {
				return d1;
			} else {
				return d2;
			}
		}
		
		public double getPrice() { return price; }
		public double getQuantity() { return quantity; }
		public double getTotalValue() {	return totalValueFunction.apply(this); }

		// Must supply implementation method, as each interface has its own version of getDepartment. 
		public String getDepartment() { 
			return IShareTrade.super.getDepartment();
		}
		
		public double getCommissionRate() {
			return 0.75;
		}

		public String toString() {
			return toStringFunction.apply(this);
		}
	}
	
	class InternationalShareTrade implements IShareTrade { 
		String stock;
		double price;
		String currency;
		int quantity;
		
		// Create some lambdas instead of the usual code inside a method 
		Function<InternationalShareTrade, String> toStringFunction = (ist) -> stock + " " + quantity + "@" + price + currency;;
		Function<InternationalShareTrade, Double> totalValueFunction = (ist) -> price * quantity;
		
		public InternationalShareTrade() {
		}
		
		public InternationalShareTrade(String stock, double price, String currency, int quantity) {
			this.stock = stock;
			this.price = price;
			this.currency = currency;
			this.quantity = quantity;
		}

		public double getPrice() { return price; }
		public double getQuantity() { return quantity; }
		public double getTotalValue() {	return totalValueFunction.apply(this); }
		
		public String getCurrency() {
			return currency;
		}

		public double getCommissionRate() {
			return 1.35;
		}
		
		public String toString() {
			return toStringFunction.apply(this);
		}
	}
	
	class Transfer implements ITransaction {
		
	}
		
	// Verify that the correct default method is called when each interface 
	// defines it's own unique default method.
	@Test public void testOneOffDefaultMethods() {
		// Note that this also tests that an inherited default method can be called.
		LocalShareTrade trade = new LocalShareTrade();
		assertEquals("USD", trade.getCurrencyIMM());
		assertEquals("AUD", trade.getCurrencyIT());
		assertEquals("GBP", trade.getCurrencyIST());
	}
	
	// Verify that the correct overridden default method is called.
	@Test public void testOverriddenDefaultMethod() {
		// The overridden method from IShareTrade should be called.
		// (and not the earlier versions from IMoneyMarket or ITransaction)
		InternationalShareTrade trade = new InternationalShareTrade();
		assertEquals("DQ08", trade.getDepartment());
	}

	// Call a default method which has been overridden an abstract method.
	@Test public void testAbstractedDefaultMethod() {
		// The getCommisionRate method was first defined as a normal default method, then made 
		// abstract by a subclass, before being created as a default method in another subclass.
		LocalShareTrade trade = new LocalShareTrade();
		assertEquals(0.75, trade.getCommissionRate(), 0.01);
	}
	
	// Verify that an inherited duplicate default signature can be overridden.
	@Test public void testDuplicateDefaultMethod() {
		// Call a method which has been declared on LocalShareTrade.
		// LocalShareTrade gets 2 default implementations from its interfaces which have the
		// same signature, so LocalShareTrade must supply its own implementation.
		LocalShareTrade trade = new LocalShareTrade();
		assertEquals("DQ08", trade.getDepartment());
		
		// Verify that instances of Transfer pick up the default method from ITransaction
		Transfer transfer = new Transfer();
		assertEquals("DA87", transfer.getDepartment());
	}
	
	// This test makes use of static interface methods.
	// Also does some sorting to make use of default methods and lambdas. 
	@Test public void testSortUsingDefaultsInLambdas() {
		ArrayList<IShareTrade> trades = new ArrayList<IShareTrade>();
		trades.add(new LocalShareTrade("MKS", 1.22,  500));
		trades.add(new LocalShareTrade("MKS", 1.22, 1100));
		trades.add(new InternationalShareTrade("IBM", 191.92, "USD", 800));
		trades.add(new InternationalShareTrade("HOG", 63.22, "USD", 100));
		
		// Firstly sort them using a comparator from IShareTrade
		// This will use the default getCurrency method.
		trades.sort(IShareTrade.getStandardComparator().reversed());
		assertEquals("IBM 800@191.92USD", trades.get(0).toString());
		assertEquals("HOG 100@63.22USD", trades.get(1).toString());
		assertEquals("MKS 1100@1.22", trades.get(2).toString());
		assertEquals("MKS 500@1.22", trades.get(3).toString());
		
		// Now sort with inline lambda
		trades.sort((trade1, trade2) -> 
				{
					if (trade1.getPrice() < trade2.getPrice()) {
						return -1;
					} else if (trade1.getPrice() > trade2.getPrice()) {
						return 1;
					} else {
						return Double.compare(trade1.getQuantity(), trade2.getQuantity()); 
					}
				}
			);
		assertEquals("MKS 500@1.22", trades.get(0).toString());
		assertEquals("MKS 1100@1.22", trades.get(1).toString());
		assertEquals("HOG 100@63.22USD", trades.get(2).toString());
		assertEquals("IBM 800@191.92USD", trades.get(3).toString());
	}
	
	// Call static methods on interfaces
	@Test public void testInterfacesWithStatics() {
		// Make sure that the correct version of the static method is called each time.
		assertEquals(-2.0, IMoneyMarket.biggest(3.0, 5.0), 0.01);
		assertEquals(8.0, ITransaction.biggest(3.0, 5.0), 0.01);
		assertEquals(4.0, IShareTrade.biggest(3.0, 5.0), 0.01);
		assertEquals(5.0, LocalShareTrade.biggest(3.0, 5.0), 0.01);
	}
}
