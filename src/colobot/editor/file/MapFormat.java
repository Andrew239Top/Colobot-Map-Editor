/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package colobot.editor.file;

import colobot.editor.map.ParsedMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Tomek
 */
public abstract class MapFormat
{
    private static final HashMap<String, MapFormat> formats = new HashMap<>();
    
    static
    {
        formats.put("original", new OriginalMapFormat());
    }
    
    private final String name;
    
    protected MapFormat(String name)
    {
        this.name = name;
    }
    
    public final String getName()
    {
        return name;
    }
    
    public abstract void load(ParsedMap map, File file) throws IOException;
    
    public abstract void store(ParsedMap map, File file) throws IOException;
    
    public static MapFormat getInstance(String name)
    {
        return formats.get(name);
    }
}
