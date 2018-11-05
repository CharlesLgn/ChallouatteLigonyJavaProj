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
