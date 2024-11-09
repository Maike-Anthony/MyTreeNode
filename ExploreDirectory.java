import java.io.File;

/**
 * Class that creates a tree with all the files and folders in a directory
 * @author Maike Anthony dos Santos Silva
 */
public class ExploreDirectory {

    /**
     * Method to create the tree
     * @param filename the name of the file or folder to create a tree node for.
     * @param parent the parent node of the tree node to be created.
     * @return the new tree node.
     */
    private static MyTreeNode<String> createNode(String filename, MyTreeNode<String> parent) {
        MyTreeNode<String> folderNode;
        if (parent == null) {
            folderNode = new MyTreeNode<String>(filename);
        } else {
            folderNode = parent.addChild(filename);
        }
        File folder = new File(filename);
        if (folder.listFiles() == null || folder.listFiles().length == 0) {
            return folderNode;
        } else {
            for (File file : folder.listFiles()) {
                createNode(file.getPath(), folderNode);
            }
            return folderNode;
        }
    }

    /**
     * Main part of the program. Checks input, creates tree, and prints it.
     * @param args it must contain the path that will be contained by the root node.
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Incorrect usage.\nType the name of the folder after the name of the program when running it.");
            System.exit(-1);
        }
        File base = new File(args[0]);
        if (!base.exists()) {
            System.out.println("There is no file with this name.");
            System.exit(-2);
        }
        MyTreeNode<String> root = createNode(base.getPath(), null);
        root.print();
    }
}