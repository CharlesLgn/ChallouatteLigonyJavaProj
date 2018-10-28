package resource.lang.langage;

import lang.Lang;

public class FR extends Lang {
    @Override
    public String[] getJourSemaine() {
        String sunday    = "Dimanche";
        String monday    = "Lundi";
        String tuesday   = "Mardi";
        String wednesay  = "Mercredi";
        String thursday  = "Jeudi";
        String fryday    = "Vendredi";
        String saturday  = "Samedi";
        return new String[]{sunday, monday, tuesday, wednesay, thursday, fryday, saturday};
    }

    @Override
    public String[] getMois() {
        String january   = "Janvier";
        String february  = "Février";
        String march     = "Mars";
        String april     = "Avril";
        String may       = "Mai";
        String june       = "Juin";
        String july      = "Juillet";
        String august    = "Août";
        String september = "Septembre";
        String october   = "Octobre";
        String november  = "Novembre";
        String december  = "Décembre";

        return new String[] {january, february, march, april, may,
                             june, july, august, september, october, november, december};
    }
}
