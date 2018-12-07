package org.jnbis.internal.record.reader;

import org.jnbis.internal.NistHelper;
import org.jnbis.internal.NistHelper.Field;

import java.nio.ByteBuffer;

import org.jnbis.api.model.record.MinutiaeData;

/**
 * @author ericdsoto
 */
public class MinutiaeDataReader extends RecordReader {

    @Override
    public MinutiaeData read(NistHelper.Token token) {
        MinutiaeData minutiaeData = new MinutiaeData();

        ByteBuffer buffer = token.buffer;

        while (buffer.hasRemaining()) {
            Field field = nextField(token);

            if (field == null) {
                continue;
            }

            String value = field.asString();

            switch (field.fieldNumber) {
                case 1:
                    minutiaeData.setLogicalRecordLength(field.asInteger());
                    break;
                case 2:
                    minutiaeData.setIdc(Integer.parseInt(value));
                    break;
                case 3:
                    minutiaeData.setImpressionType(value);
                    break;
                case 4:
                    minutiaeData.setMinutiaeFormat(value);
                    break;
                case 5:
                    minutiaeData.setOriginatingFingerprintReadingSystem(value);
                    break;
                case 6:
                    minutiaeData.setFingerPosition(value);
                    break;
                case 7:
                    minutiaeData.setFingerprintPatternClassification(value);
                    break;
                case 8:
                    minutiaeData.setCorePosition(value);
                    break;
                case 9:
                    minutiaeData.setDeltaPosition(value);
                    break;
                case 10:
                    minutiaeData.setNumberOfMinutiae(value);
                    break;
                case 12:
                    minutiaeData.setMinutiaeAndRidgeCountData(value);
                    break;
            }
        }
        
        return minutiaeData;
    }

}
