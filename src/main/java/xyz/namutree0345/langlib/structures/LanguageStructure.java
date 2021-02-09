package xyz.namutree0345.langlib.structures;

import java.util.ArrayList;
import java.util.HashMap;

public class LanguageStructure {
    public String languageName;
    public HashMap<String, String> languageNodes;

    public LanguageStructure() {
        languageNodes = new HashMap<>();
    }

    public void addNode(String id, String value, boolean overwrite) {
        if(!overwrite) {
            if (!languageNodes.containsKey(id))
                languageNodes.put(id, value);
        } else {
            languageNodes.put(id, value);
        }
    }

    public void addNode(String id, String value) {
        addNode(id, value, false);
    }

    public String getNode(String id, Object... placeHolders) {
        if(!languageNodes.containsKey(id))
            throw new IllegalStateException("No node!");
        String made = languageNodes.get(id);
        for (int i = 0; i < placeHolders.length; i++) {
            made = made.replace("{" + i + "}", placeHolders[i] + "");
        }
        return made;
    }
}
