package resource.lang.langage;

import resource.lang.Lang;

public class RU extends Lang {

    @Override
    protected String[] getBoutonName() {
        String chooseFile       = "Выберите файл";
        String translate        = "переводить";
        String playTranslate    = "осуществлять перевод";
        String export           = "экспорт";
        String newTranslate     = "Новый перевод";
        String restart          = "начать заново";

        return new String[] {chooseFile, translate, playTranslate,
                export, newTranslate, restart};
    }

    @Override
    protected String[] getTitleName() {
        String languageToMorse  = "Русский на Морзе";
        String languageToL33t   = "Русский на L33t";
        String morseToLanguage  = "Морзе на  Русский";
        String directTranslate  = "Прямой перевод";

        return new String[] {languageToMorse, languageToL33t,
                morseToLanguage, directTranslate};
    }

    @Override
    protected String[] getLabel() {
        String writeRoman  = "Написать на русском";
        String writeMorse  = "Написать на Морзе";
        String welcome     = "добро пожаловать";
        String title       = "переводчик";

        return new String[] {writeRoman, writeMorse, welcome, title};
    }
}
