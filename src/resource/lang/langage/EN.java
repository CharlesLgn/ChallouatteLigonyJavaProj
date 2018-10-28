package resource.lang.langage;

import lang.Lang;

public class EN extends Lang {

    @Override
    public String[] getJourSemaine() {
        String sunday    = "Sunday";
        String monday    = "Monday";
        String tuesday   = "Tuesday";
        String wednesay  = "Wednsday";
        String thursday  = "Thursday";
        String fryday    = "Fryday";
        String saturday  = "Saturday";
        return new String[]{sunday, monday, tuesday, wednesay, thursday, fryday, saturday};
    }

    @Override
    public String[] getMois() {
        String january   = "January";
        String february  = "February";
        String march     = "March";
        String april     = "April";
        String may       = "May";
        String june      = "June";
        String july      = "July";
        String august    = "August";
        String september = "September";
        String october   = "October";
        String november  = "November";
        String december  = "December";

        return new String[] {january, february, march, april, may,
                june, july, august, september, october, november, december};
    }
}
