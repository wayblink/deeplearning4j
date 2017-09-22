package org.deeplearning4j.text.sentenceiterator;

import lombok.extern.slf4j.Slf4j;
import org.datavec.api.util.ClassPathResource;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by fartovii on 09.11.15.
 */
@Slf4j
public class StreamLineIteratorTest {

    @Test
    public void testHasNext() throws Exception {

        ClassPathResource reuters5250 = new ClassPathResource("/reuters/5250");
        File f = reuters5250.getFile();

        StreamLineIterator iterator = new StreamLineIterator.Builder(new FileInputStream(f)).setFetchSize(100).build();

        int cnt = 0;
        while (iterator.hasNext()) {
            String line = iterator.nextSentence();

            assertNotEquals(null, line);
            log.info("Line: " + line);
            cnt++;
        }

        assertEquals(24, cnt);
    }
}
