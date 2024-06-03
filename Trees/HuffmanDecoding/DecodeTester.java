package HuffmanDecoding;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DecodeTester {

    @Test
    public void testDecode() {
        Node root = new HuffmanNode(new HuffmanLeaf(5, 'A'),
                new HuffmanNode(new HuffmanLeaf(2, 'B'), new HuffmanLeaf(3, 'C')));
        Decoding decoding = new Decoding();
        String testStr = decoding.decode("1001011", root);

        // assert
        assertEquals("ABACA", testStr);
    }
    
    @Test
    public void testGetLeaf1() {
        Node root = new HuffmanNode(new HuffmanLeaf(5, 'A'),
                new HuffmanNode(new HuffmanLeaf(2, 'B'), new HuffmanLeaf(3, 'C')));
        Decoding decoding = new Decoding();
        Node leaf = decoding.getLeaf("1001011", 0, root);

        // assert
        assertEquals('A', leaf.data);
    }

    @Test
    public void testGetLeaf2() {
        Node root = new HuffmanNode(new HuffmanLeaf(5, 'A'),
                new HuffmanNode(new HuffmanLeaf(2, 'B'), new HuffmanLeaf(3, 'C')));
        Decoding decoding = new Decoding();
        Node leaf = decoding.getLeaf("1001011", 2, root);

        // assert
        assertEquals('B', leaf.data);
    }

}
