package com.pck.afsilva;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test suite for {@link AccessionNumberSummarized}
 *
 * @author afsilva
 */
public class AccessionNumberSummarizedTest {

    private AccessionNumberSummarized accNumSum = new AccessionNumberSummarized();
    private final String oneElement = "A00000";
    private final String ordered    = "A00000, A0001, ABCDEFG1, DRR2110012";
    private final String disordered = "A00000, A0001, ERR000111, DRR2110012, SRR211001, ABCDEFG1";
    private final String ranges     = "A00000, A0001, ERR000111, ERR000112, ERR000113, SRR211001";
    private final String rangesLast = "A00000, A0001, ERR000111, ERR000112, ERR000113";
    private final String complete   = "A00000, A0001, ERR000111, ERR000112, ERR000113, ERR000115, ERR000116, " +
            "ERR100114, ERR200000001, ERR200000002, ERR200000003, DRR2110012, SRR211001, ABCDEFG1";

    @Test
    public void testProcessAccessionNumbersStringWhenOneElement() throws Exception {
        assertThat(accNumSum.processAccessionNumbers(oneElement)).isEqualTo("A00000");
    }

    @Test
    public void testProcessAccessionNumbersStringWhenOrdered() throws Exception {
        assertThat(accNumSum.processAccessionNumbers(ordered)).isEqualTo("A00000, A0001, ABCDEFG1, DRR2110012");
    }

    @Test
    public void testProcessAccessionNumbersStringWhenDisordered() throws Exception {
        assertThat(accNumSum.processAccessionNumbers(disordered))
                .isEqualTo("A00000, A0001, ABCDEFG1, DRR2110012, ERR000111, SRR211001");
    }

    @Test
    public void testProcessAccessionNumbersStringWhenHasRanges() throws Exception {
        assertThat(accNumSum.processAccessionNumbers(ranges))
                .isEqualTo("A00000, A0001, ERR000111-ERR000113, SRR211001");
    }

    @Test
    public void testProcessAccessionNumbersStringWhenRangeAtTheEnd() throws Exception {
        assertThat(accNumSum.processAccessionNumbers(rangesLast))
                .isEqualTo("A00000, A0001, ERR000111-ERR000113");
    }

    @Test
    public void testProcessAccessionNumbersStringWhenComplete() throws Exception {
        assertThat(accNumSum.processAccessionNumbers(complete))
                .isEqualTo("A00000, A0001, ABCDEFG1, DRR2110012, ERR000111-ERR000113, ERR000115-ERR000116, " +
                        "ERR100114, ERR200000001-ERR200000003, SRR211001");
    }

}