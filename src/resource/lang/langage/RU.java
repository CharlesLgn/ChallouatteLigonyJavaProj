package resource.lang.langage;

import lang.Lang;

public class RU extends Lang {

    @Override
    public String[] getJourSemaine() {
        String sunday    = "воскресенье";
        String monday    = "понедельник";
        String tuesday   = "вторник";
        String wednesay  = "среда";
        String thursday  = "четверг";
        String fryday    = "пятница";
        String saturday  = "суббота";
        return new String[]{sunday, monday, tuesday, wednesay, thursday, fryday, saturday};
    }

    @Override
    public String[] getMois() {
        String january   = "январь";
        String february  = "февраль";
        String march     = "Марс";
        String april     = "апреля";
        String may       = "может";
        String june      = "июнь";
        String july      = "июль";
        String august    = "августейший";
        String september = "сентябрь";
        String october   = "октября";
        String november  = "ноябрь";
        String december  = "декабрь";

        return new String[] {january, february, march, april, may,
                june, july, august, september, october, november, december};
    }
}
