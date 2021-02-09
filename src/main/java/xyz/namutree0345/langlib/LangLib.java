package xyz.namutree0345.langlib;

import org.bukkit.configuration.file.YamlConfiguration;
import xyz.namutree0345.langlib.structures.LanguageStructure;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class LangLib {

    private static final LangLib instance = new LangLib();
    private HashMap<String, LanguageStructure> structure;

    public static LangLib getInstance() {
        return instance;
    }

    public LanguageStructure getLanguage(String languageName) {
        if(structure == null)
            structure = new HashMap<>();
        if(!structure.containsKey(languageName))
            structure.put(languageName, new LanguageStructure());
        return structure.get(languageName);
    }

    public LanguageStructure getLanguageOnlyGet(String languageName) {
        if(structure == null)
            structure = new HashMap<>();
        if(!structure.containsKey(languageName))
            throw new IllegalStateException("Not contains!!");
        return structure.get(languageName);
    }
}
