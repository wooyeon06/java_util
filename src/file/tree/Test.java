package file.tree;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {

    public static void main(String args[]) {

        String DATA_DIRECTORY = "C:/test";
        File dir = new File(DATA_DIRECTORY);
        HashMap resultMap = fromFile(dir);
        //HashMap<String, Object> fileTree = new HashMap<String, Object>();


        System.out.println(resultMap);
    }

    public static HashMap fromFile(File file) {

        HashMap<String, Object> node = new HashMap<String, Object>();

        node.put("name", file.getName());
        node.put("path", file.getAbsoluteFile());
        if (file.isDirectory()) {
            ArrayList list = new ArrayList<HashMap<String, Object>>();
            node.put("list", list);
            for (File child : file.listFiles()) {
                ArrayList childList = (ArrayList) node.get("list");
                childList.add(fromFile(child));
            }
        }

        return node;
    }
}
