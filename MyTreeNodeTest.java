import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class MyTreeNodeTest {
    @Test
    void testAddChild() {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        int second = root.addChild(2).getItem();
        assertEquals(second, 2);
    }

    @Test
    void testGetChildren() {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        root.addChild(2);
        root.addChild(3);
        root.addChild(4);
        int total = root.getChildren().size();
        assertEquals(total, 3);
    }

    @Test
    void testGetItem() {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        int first = root.getItem();
        assertEquals(first, 1);
    }

    @Test
    void testGetParent() {
        MyTreeNode<Integer> root = new MyTreeNode<>(1);
        MyTreeNode<Integer> second = root.addChild(2);
        MyTreeNode<Integer> parent = second.getParent();
        assertEquals(parent, root);
    }

    @Test
    void testIsLeaf() {
        MyTreeNode<Integer> root = new MyTreeNode<Integer>(1);
        MyTreeNode<Integer> leaf = root.addChild(2);
        assertTrue(leaf.isLeaf());
        assertFalse(root.isLeaf());
    }

    @Test
    void testIsRoot() {
        MyTreeNode<Integer> root = new MyTreeNode<Integer>(1);
        MyTreeNode<Integer> leaf = root.addChild(2);
        assertTrue(root.isRoot());
        assertFalse(leaf.isRoot());        
    }

    @Test
    void testSize() {
        MyTreeNode<Integer> root = new MyTreeNode<Integer>(10);
        MyTreeNode<Integer> second = root.addChild(20);
        MyTreeNode<Integer> third = root.addChild(21);
        MyTreeNode<Integer> fourth = second.addChild(30);
        MyTreeNode<Integer> fifth = third.addChild(31);
        MyTreeNode<Integer> sixth = third.addChild(32);
        assertEquals(root.size(), 6);
        assertEquals(second.size(), 2);
        assertEquals(third.size(), 3);
        assertEquals(fourth.size(), 1);
        assertEquals(fifth.size(), 1);
        assertEquals(sixth.size(), 1);
    }

    @Test
    void testDepth() {
        MyTreeNode<Integer> root = new MyTreeNode<Integer>(10);
        MyTreeNode<Integer> second = root.addChild(20);
        MyTreeNode<Integer> third = root.addChild(21);
        MyTreeNode<Integer> fourth = second.addChild(30);
        MyTreeNode<Integer> fifth = third.addChild(31);
        MyTreeNode<Integer> sixth = third.addChild(32);
        assertEquals(root.depth(), 0);
        assertEquals(second.depth(), 1);
        assertEquals(third.depth(), 1);
        assertEquals(fourth.depth(), 2);
        assertEquals(fifth.depth(), 2);
        assertEquals(sixth.depth(), 2);          
    }

    @Test
    void testHeight() {
        MyTreeNode<Integer> root = new MyTreeNode<Integer>(10);
        MyTreeNode<Integer> second = root.addChild(20);
        MyTreeNode<Integer> third = root.addChild(21);
        MyTreeNode<Integer> fourth = second.addChild(30);
        MyTreeNode<Integer> fifth = third.addChild(31);
        MyTreeNode<Integer> sixth = third.addChild(32);
        assertEquals(root.height(), 2);
        assertEquals(second.height(), 1);
        assertEquals(third.height(), 1);
        assertEquals(fourth.height(), 0);
        assertEquals(fifth.height(), 0);
        assertEquals(sixth.height(), 0);        
    }

    @Test
    void testContains() {
        MyTreeNode<Integer> root = new MyTreeNode<Integer>(10);
        MyTreeNode<Integer> second = root.addChild(20);
        MyTreeNode<Integer> third = root.addChild(21);
        MyTreeNode<Integer> fourth = second.addChild(30);
        MyTreeNode<Integer> fifth = third.addChild(31);
        MyTreeNode<Integer> sixth = third.addChild(32);
        assertTrue(root.contains(10));
        assertTrue(root.contains(21));
        assertTrue(root.contains(32));
        assertFalse(root.contains(50));       
    }
}
