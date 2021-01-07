import java.io.CharArrayWriter;
import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) {
        try (CharArrayWriter contactWriter = new CharArrayWriter()) {
            for (String st : words) {
                contactWriter.write(st);
            }
            return contactWriter.toCharArray();

        } catch (IOException e) {
            return new char[]{'1'};
        }
    }
}