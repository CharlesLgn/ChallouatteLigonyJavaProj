package resource.lang.langage;

import resource.lang.Lang;

public class DE extends Lang {

    @Override
    public String[] getJourSemaine() {
        String sunday    = "Sontag";
        String monday    = "Montag";
        String tuesday   = "Dienstag";
        String wednesay  = "Mitwoch";
        String thursday  = "Donnerstag";
        String fryday    = "Freitag";
        String saturday  = "Samstag";
        return new String[]{sunday, monday, tuesday, wednesay, thursday, fryday, saturday};
    }

    @Override
    public String[] getMois() {
        String january   = "Januar";
        String february  = "Februar";
        String march     = "März";
        String april     = "April";
        String may       = "May";
        String june      = "Juny";
        String july      = "July";
        String august    = "August";
        String september = "September";
        String october   = "Oktober";
        String november  = "November";
        String december  = "December";

        return new String[] {january, february, march, april, may,
                june, july, august, september, october, november, december};
    }
}
