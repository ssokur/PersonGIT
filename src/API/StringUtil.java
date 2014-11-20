package API;

import java.io.UnsupportedEncodingException;

public class StringUtil
{
    public static String toUTF8 (String isoString)
    {
        String utf8string = null;

        if (null != isoString && !isoString.equals(""))
        {
            try
            {
                byte[] stringByteISO = isoString.getBytes("ISO-8859-1");
                utf8string = new String(stringByteISO, "UTF-8");

            } catch (UnsupportedEncodingException e)
            {
                System.out.println("Pizdets" + utf8string);
                utf8string = isoString;
            }
        }
        else
        {
            utf8string = isoString;
        }
        return utf8string;
    }
}
