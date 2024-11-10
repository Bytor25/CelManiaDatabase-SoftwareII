package co.com.cmdb.generales.crosscutting.helpers;

import java.util.regex.Pattern;

public final class TextHelper {
    
    public static final String EMPTY = "";
    public static final String UNDERLINE = "_";
    
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    private static final Pattern DOCUMENT_NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    private static final Pattern ESPACIOS_LETRAS_DIGITOS_PATTERN = Pattern.compile("^[0-9A-Za-záéíóúÁÉÍÓÚ]+$");

    private TextHelper() {}

    public static boolean isNull(final String string) {
        return string == null;
    }

    public static boolean isNullOrEmpty(final String string) {
        return isNull(string) || EMPTY.equals(string.trim());
    }

    public static String getDefault(final String string, final String defaultValue) {
        return isNull(string) ? defaultValue : string;
    }

    public static String getDefault(final String string) {
        return getDefault(string, EMPTY);
    }

    public static boolean isEmpty(final String string) {
        return EMPTY.equals(getDefault(string));
    }

    public static boolean isEmptyApplyingTrim(final String string) {
        return isEmpty(applyTrim(string));
    }

    public static String applyTrim(final String string) {
        return getDefault(string).trim();
    }

    public static String concatenate(String... strings) {
        final StringBuilder sb = new StringBuilder(EMPTY);
        if (strings != null) {
            for (final var string : strings) {
                sb.append(applyTrim(string));
            }
        }
        return sb.toString();
    }

    public static String replaceParameters(String message, String... parameters) {
        String replacedMessage = message;
        for (int i = 0; i < parameters.length; i++) {
            String marker = "$[" + (i + 1) + "]";
            replacedMessage = replacedMessage.replace(marker, parameters[i]);
        }
        return replacedMessage;
    }

    public static boolean isValidEmailFormat(final String value) {
        return EMAIL_PATTERN.matcher(getDefault(value)).matches();
    }

    public static boolean isOnlyNumbers(final String value) {
        return DOCUMENT_NUMBER_PATTERN.matcher(getDefault(value)).matches();
    }

    public static boolean hasMinLength(final String value, final int minLength) {
        return applyTrim(value).length() >= minLength;
    }

    public static boolean hasMaxLength(final String value, final int maxLength) {
        return applyTrim(value).length() <= maxLength;
    }

    public static boolean isAlphanumericWithSpaces(final String value) {
        return ESPACIOS_LETRAS_DIGITOS_PATTERN.matcher(getDefault(value)).matches();
    }
}
