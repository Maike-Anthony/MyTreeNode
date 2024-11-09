import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * A tree node class
 * @author Maike Anthony dos Santos Silva
 */

public class MyTreeNode<T> {
    /**The item contained in the node */
    private T item;
    /**The parent node of this node */
    private MyTreeNode<T> parent;
    /**The list of children nodes */
    private List<MyTreeNode<T>> children;

    /**
     * The private constructor for the non-root nodes
     * @param item the item contained in the node
     * @param parent the parent node of this node
    */
    private MyTreeNode(T item, MyTreeNode<T> parent) {
        this.item = item;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    /**
     * The public constructor for the root node
     * @param item the item contained in the node
     */
    public MyTreeNode(T item) {
        this(item, null);
    }

    /**
     * Method to get the item contained in this node
     * @return the item of this node
     */
    public T getItem() {
        return this.item;
    }

    /**
     * Method to get the parent node of this node
     * @return the parent node
     */
    public MyTreeNode<T> getParent() {
        return this.parent;
    }

    /**
     * Method to get the children instance variable
     * @return the list of children nodes
     */
    public List<MyTreeNode<T>> getChildren() {
        return new ArrayList<>(this.children);
    }

    /**
     * Method to add a new child node
     * @param item the item contained by the new child node
     * @return the new child node
     */
    public MyTreeNode<T> addChild(T item) {
        MyTreeNode<T> node = new MyTreeNode<T>(item, this);
        this.children.add(node);
        return node;
    }

    /**
     * Method to check if node is a leaf node
     * @return true if it is a leaf and false otherwise
     */
    public boolean isLeaf() {
        if (this.children.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to check if node is a root node
     * @return true if it is a root node and false otherwise
     */
    public boolean isRoot() {
        if (this.parent == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to calculate the size of a node
     * @return the number of descendents of a node (including itself)
     */
    public int size() {
        if (this.isLeaf()) {
            return 1;
        } else {
            int sum = 1;
            for (MyTreeNode<T> node : this.children) {
                sum += node.size();
            }
            return sum;
        }
    }

    /**
     * Method to return the depth of the node
     * @return the depth of the node
     */
    public int depth() {
        if (this.isRoot()) {
            return 0;
        } else {
            return 1 + this.parent.depth();
        }
    }

    /**
     * Method to return the height of the node
     * @return the height of the node
     */
    public int height() {
        if (this.isLeaf()) {
            return 0;
        } else {
            ArrayList<Integer> heights = new ArrayList<>();
            for (MyTreeNode<T> node : this.children) {
                heights.add(node.height());
            }
            return 1 + Collections.max(heights);
        }
    }

    /**
     * Method to check if a given item is in any of the descendents of the node (including itself)
     * @param item is the item looked for
     * @return true if the item belongs in any of the descendents and false otherwise
     */
    public boolean contains(T item) {
        if (this.item.equals(item)) {
            return true;
        } else if (this.isLeaf()) {
            return false;
        } else {
            for (MyTreeNode<T> node : this.children) {
                if (node.contains(item)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Private helper method to be called by the public print method
     * @param prefix the tabs prefixed to the number of the course
     */
    private void print(String prefix) {
        System.out.print(prefix);
        System.out.println(this.item);
        if (this.children.size() == 0) {
            return;
        } else {
            prefix += "\t";
            for (MyTreeNode<T> node : this.children) {
                node.print(prefix);
            }
        }
    }

    /**
     * Method to print the items of the descendents of the node. The children are one tab to the right of their parents
     */
    public void print() {
        this.print("");
    }

    public static void main(String[] args) {
        MyTreeNode<Integer> first = new MyTreeNode<Integer>(150);
        MyTreeNode<Integer> second = first.addChild(151);
        MyTreeNode<Integer> third = second.addChild(275);
        MyTreeNode<Integer> fourth = second.addChild(241);
        MyTreeNode<Integer> fifth = second.addChild(280);
        MyTreeNode<Integer> sixth = fifth.addChild(383);
        MyTreeNode<Integer> seventh = fourth.addChild(210);
        MyTreeNode<Integer> eigth = fourth.addChild(364);
        MyTreeNode<Integer> nineth = fourth.addChild(374);
        MyTreeNode<Integer> tenth = seventh.addChild(341);
        first.print();
    }
}