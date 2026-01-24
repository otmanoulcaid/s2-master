package org.mql.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class XMLNodeTest {

    @Test
    public void testNumberOfChildNodes() {
        XMLNode root = new XMLNode("ressources/db.xml");
        XMLNode[] children = root.children();
        
        int expectedChildCount = 3;

        assertEquals(expectedChildCount, children.length, "Number of child nodes should match expected count");
    }
}
