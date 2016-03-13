package util;

import java.io.File;
import java.io.IOException;

/**
 * Created by ZhiLI on 2016/3/13.
 */
public class fileTest {
    public static void main (String[] args) throws IOException {
        String fileDir = "./uploadData";
        File file = new File(fileDir);
        System.out.println(file.isDirectory());
    }
}
