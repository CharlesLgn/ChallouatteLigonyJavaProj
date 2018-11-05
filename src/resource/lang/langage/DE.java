package resource.lang.langage;

import resource.lang.Lang;

public class DE extends Lang {

    @Override
    protected String[] getBoutonName() {
        String chooseFile       = "Datei Wählen";
        String translate        = "Übersetzen";
        String playTranslate    = "Übersetzung abspielen";
        String export           = "Export";
        String newTranslate     = "Neu Übersetzung";
        String restart          = "Wieder beginnen";

        return new String[] {chooseFile, translate, playTranslate,
                export, newTranslate, restart};
    }

    @Override
    protected String[] getTitleName() {
        String languageToMorse  = "Deutsch zu Morse";
        String languageToL33t   = "Deutsch zu L33t";
        String morseToLanguage  = "Morse zu Deutsch";
        String directTranslate  = "Live-Übersetzung";

        return new String[] {languageToMorse, languageToL33t,
                morseToLanguage, directTranslate};
    }

    @Override
    protected String[] getLabel() {
        String writeRoman  = "Schreiben Sie in Deutsch";
        String writeMorse  = "Schreiben Sie in Morse";
        String welcome     = "Wilkommen";
        String title       = "Übersetzer";

        return new String[] {writeRoman, writeMorse, welcome, title};
    }
}
