package org.jnbis.internal.record.writer;

import java.util.Objects;

import org.junit.Test;

public class RecordWriterTest {

    @Test
    public void testWrtieRecordSizeCalculation() {
        String h1 = "14.001:"; // 7
        int sepLength = 2;
        
        for (int buffLength = 9980; buffLength < 9996; buffLength++) {
            
            int knownLength = h1.length() + sepLength + buffLength;
            int lengthOfKnown = Objects.toString(knownLength).length();
            
            int totalLength = knownLength + lengthOfKnown;
            int lengthOfTotal = Objects.toString(totalLength).length();
            
            if (lengthOfTotal > lengthOfKnown) {
                totalLength++;
            }
            
            System.out.format("%d, %d, %d, %d, %d\n", buffLength, knownLength, lengthOfKnown, totalLength, lengthOfTotal);
        }
        
    }
    
}
