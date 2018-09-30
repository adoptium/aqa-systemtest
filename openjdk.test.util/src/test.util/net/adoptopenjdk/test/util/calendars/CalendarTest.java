/*******************************************************************************
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      https://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/
/**
 * File:    CalendarTest.java
 * Package: net.adoptopenjdk.test.util.calendars
 */
   
package net.adoptopenjdk.test.util.calendars;

import java.util.*;
import org.junit.Assert;

public class CalendarTest {
	public void run() {
		Date d = new Date ();
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(d);
		String tmpstr="";

		StringBuffer sb=new StringBuffer();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		switch (day) {
			case 1:
				tmpstr="Sun";
				break;
			case 2:
				tmpstr="Mon";
				break;
			case 3:
				tmpstr="Tue";
				break;
			case 4:
				tmpstr="Wed";
				break;
			case 5:
				tmpstr="Thu";
				break;
			case 6:
				tmpstr="Fri";
				break;
			case 7:
				tmpstr="Sat";
				break;
			default:
				Assert.fail("Invalid DAY_OF_WEEK value: " + day);
				break;
		}
		// System.out.println(tmpstr);
		
		sb.append (" weekday=\""+tmpstr+"\"");
		sb.append (" day=\""+cal.get(Calendar.DAY_OF_MONTH)+"\"");

		int month = cal.get(Calendar.MONTH);
		switch (month) {
			case 0:
				tmpstr="Jan";
				break;
			case 1:
				tmpstr="Feb";
				break;
			case 2:
				tmpstr="Mar";
				break;
			case 3:
				tmpstr="Apr";
				break;
			case 4:
				tmpstr="May";
				break;
			case 5:
				tmpstr="Jun";
				break;
			case 6:
				tmpstr="Jul";
				break;
			case 7:
				tmpstr="Aug";
				break;
			case 8:
				tmpstr="Sep";
				break;
			case 9:
				tmpstr="Oct";
				break;
			case 10:
				tmpstr="Nov";
				break;
			case 11:
				tmpstr="Dec";
				break;
			default:
				Assert.fail("Invalid MONTH value: " + month);
				break;
		}
		sb.append (" month=\""+tmpstr+"\"");

		sb.append (" time=\""+cal.get(Calendar.HOUR_OF_DAY)+
			":"+cal.get(Calendar.MINUTE)+
			":"+cal.get(Calendar.SECOND)+
			"."+cal.get(Calendar.MILLISECOND)+
			"\"");
		sb.append (" timezone=\""+cal.getTimeZone().getDisplayName(false,TimeZone.SHORT)+"\"");
		sb.append (" year=\""+cal.get(Calendar.YEAR)+"\"");
		sb.append (" ms=\""+d.getTime()+"\"");

		System.out.println(sb);
	}
} 
