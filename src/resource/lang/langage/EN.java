package resource.lang.langage;

import resource.lang.Lang;

public class EN extends Lang {

    @Override
    protected String[] getBoutonName() {
        String chooseFile       = "Choose a file";
        String translate        = "Translate";
        String playTranslate    = "Play translation";
        String export           = "Export";
        String newTranslate     = "New translation";
        String restart          = "Restart";

        return new String[] {chooseFile, translate, playTranslate,
                export, newTranslate, restart};
    }

    @Override
    protected String[] getTitleName() {
        String languageToMorse  = "English to Morse";
        String languageToL33t   = "English to L33t";
        String morseToLanguage  = "Morse to English";
        String directTranslate  = "Live Translation";

        return new String[] {languageToMorse, languageToL33t,
                morseToLanguage, directTranslate};
    }

    @Override
    protected String[] getLabel() {
        String writeRoman  = "Write in English";
        String writeMorse  = "Write in Morse";
        String welcome     = "Welcome";
        String title       = "Translator";

        return new String[] {writeRoman, writeMorse, welcome, title};
    }

    @Override
    protected String[] getPopUp() {
        String chooseFileTrad       = "Choose a text file";
        String chooseFileExport     = "Choose a directory where export your translation";

        String popUpSuccesTittle    = "Success";
        String popUpSuccesName      = "Export";
        String popUpSuccesDesc      = "Translation has been exported";

        String popUpErrorTittle     = "Error";
        String popUpErrorName       = "File path";
        String popUpErrorDescTrad   = "Select a file to translate first";
        String popUpErrorDescExport = "Verify that a translation has been done";

        return new String[] {chooseFileTrad, chooseFileExport, popUpSuccesTittle, popUpSuccesName,
                popUpSuccesDesc, popUpErrorTittle, popUpErrorName, popUpErrorDescTrad, popUpErrorDescExport};
    }
}
