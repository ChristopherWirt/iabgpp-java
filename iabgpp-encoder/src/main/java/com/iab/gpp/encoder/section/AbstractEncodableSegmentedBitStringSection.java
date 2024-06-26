package com.iab.gpp.encoder.section;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.iab.gpp.encoder.datatype.AbstractEncodableBitStringDataType;
import com.iab.gpp.encoder.datatype.SubstringException;
import com.iab.gpp.encoder.error.DecodingException;
import com.iab.gpp.encoder.error.EncodingException;
import com.iab.gpp.encoder.error.InvalidFieldException;

public abstract class AbstractEncodableSegmentedBitStringSection implements EncodableSection {
  protected Map<String, AbstractEncodableBitStringDataType<?>> fields;
  protected String[][] segments;

  @Override
  public boolean hasField(String fieldName) {
    return this.fields.containsKey(fieldName);
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (this.fields.containsKey(fieldName)) {
      return this.fields.get(fieldName).getValue();
    } else {
      return null;
    }
  }

  @Override
  public void setFieldValue(String fieldName, Object value) throws InvalidFieldException {
    if (this.fields.containsKey(fieldName)) {
      this.fields.get(fieldName).setValue(value);
    } else {
      throw new InvalidFieldException(fieldName + " not found");
    }
  }

  public String[][] getSegments() {
    return this.segments;
  }

  public List<String> encodeSegmentsToBitStrings() throws EncodingException {
    List<String> segmentBitStrings = new ArrayList<>();
    for (int i = 0; i < this.segments.length; i++) {
      String segmentBitString = "";
      for (int j = 0; j < this.segments[i].length; j++) {
        String fieldName = this.segments[i][j];
        if (this.fields.containsKey(fieldName)) {
          try {
            AbstractEncodableBitStringDataType<?> field = this.fields.get(fieldName);
            segmentBitString += field.encode();
          } catch (Exception e) {
            throw new EncodingException("Unable to encode " + fieldName, e);
          }
        } else {
          throw new EncodingException("Field not found: '" + fieldName + "'");
        }
      }
      segmentBitStrings.add(segmentBitString);
    }

    return segmentBitStrings;
  }

  public void decodeSegmentsFromBitStrings(List<String> segmentBitStrings) throws DecodingException {
    for (int i = 0; i < this.segments.length && i < segmentBitStrings.size(); i++) {
      decodeSegmentFromBitString(segments[i], segmentBitStrings.get(i));
    }
  }

  private void decodeSegmentFromBitString(String[] segment, String segmentBitString) throws DecodingException {
    if (segmentBitString != null && segmentBitString.length() > 0) {
      int index = 0;
      for (int j = 0; j < segment.length; j++) {
        String fieldName = segment[j];
        AbstractEncodableBitStringDataType<?> field = this.fields.get(fieldName);
        if (this.fields.containsKey(fieldName)) {
          try {
            String substring = field.substring(segmentBitString, index);
            field.decode(substring);
            index += substring.length();
          } catch (SubstringException e) {
            if(field.getHardFailIfMissing()) {
              throw new DecodingException("Unable to decode " + fieldName, e);
            } else {
              return;
            }
          } catch (Exception e) {
            throw new DecodingException("Unable to decode " + fieldName, e);
          }
        } else {
          throw new DecodingException("Field not found: '" + fieldName + "'");
        }
      }
    }
  }
  
  @Override
  public abstract String encode() throws EncodingException;

  @Override
  public abstract void decode(String encodedString) throws DecodingException;

  @Override
  public abstract int getId();

  @Override
  public abstract String getName();
}
