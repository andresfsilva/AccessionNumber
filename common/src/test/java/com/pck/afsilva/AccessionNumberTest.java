package com.pck.afsilva;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for {@link AccessionNumber}
 *
 * @author afsilva
 */
public class AccessionNumberTest {

    private final AccessionNumber accNum1 = new AccessionNumber("A00000");
    private final AccessionNumber accNum2 = new AccessionNumber("A0001");
    private final AccessionNumber accNum3 = new AccessionNumber("A0002");
    private final AccessionNumber accNum4 = new AccessionNumber("ABCDEFG1");
    private final AccessionNumber accNum5 = new AccessionNumber("ERR000111");

    @Test
    public void testCompareToWhenArgumentIsGreater() throws Exception {
        assertThat(accNum1.compareTo(accNum2)).isLessThan(0);
    }

    @Test
    public void testCompareToWhenArgumentIsLess() throws Exception {
        assertThat(accNum2.compareTo(accNum1)).isGreaterThan(0);
    }

    @Test
    public void testCompareToWhenArgumentIsEqual() throws Exception {
        assertThat(accNum1.compareTo(accNum1)).isEqualTo(0);
    }

    @Test
    public void testAreContinuousWhenAreContinuous() throws Exception {
        assertThat(accNum2.areContinuous(accNum3)).isTrue();
    }

    @Test
    public void testAreContinuousWhenAreNotContinuousDifferentAlphaString() throws Exception {
        assertThat(accNum1.areContinuous(accNum4)).isFalse();
    }

    @Test
    public void testAreContinuousWhenAreNotContinuousDifferentNumber() throws Exception {
        assertThat(accNum1.areContinuous(accNum3)).isFalse();
    }

    @Test
    public void testAreContinuousWhenAreNotContinuousDifferentDigits() throws Exception {
        assertThat(accNum1.areContinuous(accNum2)).isFalse();
    }

    @Test
    public void testAreContinuousWhenAreNotContinuousDifferent() throws Exception {
        assertThat(accNum1.areContinuous(accNum5)).isFalse();
    }

    @Test
    public void testGetOriginal() throws Exception {
        assertThat(accNum1.getOriginal()).isEqualTo("A00000");
    }
}