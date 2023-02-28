package yamlsTools;

public class GlobalPath {
    private static String globalPath = "";

    public static String getPath() {
        return globalPath;
    }

    public static void setPath(String path) {
        if (path.contains("/")) {
            globalPath = path.substring(0, path.lastIndexOf("/") + 1);
        } else if (path.contains("\\")) {
            globalPath = path.substring(0, path.lastIndexOf("\\") + 1);
        }
    }
}
