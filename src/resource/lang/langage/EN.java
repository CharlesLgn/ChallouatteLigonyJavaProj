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
        String chooseFileTrad  = "Choisissez un fichier texte";
        String chooseFileExport= "Choisissez un répertoire ou exporter votre traduction";



        String popUpSuccesTittle    = "Succès";
        String popUpSuccesName      = "Export";
        String popUpSuccesDesc      = "La traduction a été exportée";

        String popUpErrorTittle     = "Erreur";
        String popUpErrorName       = "Chemin du fichier";
        String popUpErrorDescTrad   = "Sélectionnez dans un premier temps un fichier texte à traduire";
        String popUpErrorDescExport = "Vérifiez qu'un traduction a été effectuée";

        return new String[] {chooseFileTrad, chooseFileExport, popUpSuccesTittle, popUpSuccesName,
                popUpSuccesDesc, popUpErrorTittle, popUpErrorName, popUpErrorDescTrad, popUpErrorDescExport};
    }
}
