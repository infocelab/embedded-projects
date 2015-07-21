import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumericPlainDocument extends PlainDocument {

    public NumericPlainDocument() {
        setFormat(null);
    }
    
    public NumericPlainDocument(DecimalFormat format) {
        setFormat(format);
    }

    public NumericPlainDocument(AbstractDocument.Content content, DecimalFormat format) {

        super(content);
        setFormat(format);
        
        try {
            format.parseObject(content.getString(0, content.length()), parsePos);
        } catch (Exception e) {
            throw new IllegalArgumentException("Initial content not a valid number");
        }
        
        if (parsePos.getIndex() != content.length() - 1) {
            throw new IllegalArgumentException("Initial content not a valid number");
        }
    }
 
    public void setFormat(DecimalFormat fmt) {
        this.format = fmt != null ? fmt :
            (DecimalFormat)defaultFormat.clone();
            
            decimalSeparator = format.getDecimalFormatSymbols().getDecimalSeparator();
            groupingSeparator = format.getDecimalFormatSymbols().getGroupingSeparator();
            positivePrefix = format.getPositivePrefix();
            positivePrefixLen = positivePrefix.length();
            negativePrefix = format.getNegativePrefix();
            negativePrefixLen = negativePrefix.length();
            positiveSuffix = format.getPositiveSuffix();
            positiveSuffixLen = positiveSuffix.length();
            negativeSuffix = format.getNegativeSuffix();
            negativeSuffixLen = negativeSuffix.length();
    }

    public DecimalFormat getFormat() {
        return format;
    }

    public Number getNumberValue() throws ParseException {
        try {
            String content = getText(0, getLength());
            parsePos.setIndex(0);
            Number result = format.parse(content, parsePos);
            if (parsePos.getIndex() != getLength()) {
                throw new ParseException(
                "Not a valid number: " + content, 0);
            }
            
            return result;
        } catch (BadLocationException e) {
            throw new ParseException("Not a valid number", 0);
        }
    }

    public Long getLongValue() throws ParseException {
        Number result = getNumberValue();
        if ((result instanceof Long) == false) {
            throw new ParseException("Not a valid long", 0);
        }
        
        return (Long)result;
    }

    public Double getDoubleValue() throws ParseException {
        Number result = getNumberValue();
        if ((result instanceof Long) == false &&
        (result instanceof Double) == false) {
            throw new ParseException("Not a valid double", 0);
        }
        
        if (result instanceof Long) {
            result = new Double(result.doubleValue());
        }
        
        return (Double)result;
    }

    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
        if (str == null || str.length() == 0) {
            return;
        }
        
        Content content = getContent();
        int length = content.length();
        int originalLength = length;
        
        parsePos.setIndex(0);
        
        String targetString = content.getString(0, offset) + str +
        content.getString(offset, length - offset - 1);
        
        do {
            boolean gotPositive = targetString.startsWith(positivePrefix);
            boolean gotNegative = targetString.startsWith(negativePrefix);
            
            length = targetString.length();

            if (gotPositive == true || gotNegative == true) {
                String suffix;
                int suffixLength;
                int prefixLength;
                
                if (gotPositive == true && gotNegative == true) {
                    if (positivePrefixLen > negativePrefixLen) {
                        gotNegative = false;
                    } else {
                        gotPositive = false;
                    }
                }
                
                if (gotPositive == true) {
                    suffix = positiveSuffix;
                    suffixLength = positiveSuffixLen;
                    prefixLength = positivePrefixLen;
                } else {
                    // Must have the negative prefix
                    suffix = negativeSuffix;
                    suffixLength = negativeSuffixLen;
                    prefixLength = negativePrefixLen;
                }
                
                if (length == prefixLength) {
                    break;
                }

                if (targetString.endsWith(suffix) == false) {
                    int i;
                    for (i = suffixLength - 1; i > 0 ; i--) {
                        if (targetString.regionMatches(length - i,
                        suffix, 0, i)) {
                            targetString += suffix.substring(i);
                            break;
                        }
                    }
                    
                    if (i == 0) {
                        // None of the suffix was present
                        targetString += suffix;
                    }
                    
                    length = targetString.length();
                }
            }
            
            format.parse(targetString, parsePos);
            
            int endIndex = parsePos.getIndex();
            if (endIndex == length) {
                break;		// Number is acceptable
            }

            if (positivePrefixLen > 0 &&
            endIndex < positivePrefixLen &&
            length <= positivePrefixLen &&
            targetString.regionMatches(0, positivePrefix, 0, length)) {
                break;		// Accept for now
            }
            
            if (negativePrefixLen > 0 &&
            endIndex < negativePrefixLen &&
            length <= negativePrefixLen &&
            targetString.regionMatches(0, negativePrefix, 0, length)) {
                break;		// Accept for now
            }

            char lastChar = targetString.charAt(originalLength - 1);
            int decimalIndex = targetString.indexOf(decimalSeparator);
            if (format.isGroupingUsed() &&
            lastChar == groupingSeparator &&
            decimalIndex == -1) {
                // Allow a "," but only in integer part
                break;
            }
            
            if(format.isParseIntegerOnly() == false &&
            lastChar == decimalSeparator &&
            decimalIndex == originalLength - 1) {
                // Allow a ".", but only one
                break;
            }
            
            // No more corrections to make: must be an error
            if (errorListener != null) {
                errorListener.insertFailed(this, offset, str, a);
            }
            return;
        } while (true == false);
        
        // Finally, add to the model
        super.insertString(offset, str, a);
    }

    public void addInsertErrorListener(InsertErrorListener l) {
        if (errorListener == null) {
            errorListener = l;
            return;
        }
        throw new IllegalArgumentException("InsertErrorListener already registered");
    }

    public void removeInsertErrorListener(InsertErrorListener l) {
        if (errorListener == l) {
            errorListener = null;
        }
    }

    public interface InsertErrorListener {
        public abstract void insertFailed(NumericPlainDocument doc,
        int offset, String str, AttributeSet a);
    }
    
    protected InsertErrorListener errorListener;
    protected DecimalFormat format;
    protected char decimalSeparator;
    protected char groupingSeparator;
    protected String positivePrefix;
    protected String negativePrefix;
    protected int positivePrefixLen;
    protected int negativePrefixLen;
    protected String positiveSuffix;
    protected String negativeSuffix;
    protected int positiveSuffixLen;
    protected int negativeSuffixLen;
    protected ParsePosition parsePos = new ParsePosition(0);
    protected static DecimalFormat defaultFormat =
    new DecimalFormat();
}
