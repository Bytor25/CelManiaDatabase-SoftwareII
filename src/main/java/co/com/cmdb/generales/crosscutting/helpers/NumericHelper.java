package co.com.cmdb.generales.crosscutting.helpers;

public final class NumericHelper {


    public static final int DEFAULT_INT = 0;
    public static final long DEFAULT_LONG = 0000000000L;
    public static final double DEFAULT_DOUBLE = 0.0;

    private static final long MIN_PHONE_NUMBER = 3000000000L;
    private static final long MAX_PHONE_NUMBER = 3999999999L;

    private NumericHelper() {
        super();
    }

    public static <T extends Number> boolean isNull(final T value) {
        return ObjectHelper.isNull(value);
    }

    public static Integer getDefaultValue(final Integer value) {
        return isNull(value) ? DEFAULT_INT : value;
    }

    public static Long getDefaultValue(final Long value) {
        return isNull(value) ? DEFAULT_LONG : value;
    }

    public static Double getDefaultValue(final Double value) {
        return isNull(value) ? DEFAULT_DOUBLE : value;
    }

    public static <T extends Number> boolean isGreat(final T numberOne, final T numberTwo) {
        return numberOne.doubleValue() > numberTwo.doubleValue();
    }

    public static <T extends Number> boolean isLess(final T numberOne, final T numberTwo) {
        return numberOne.doubleValue() < numberTwo.doubleValue();
    }

    public static <T extends Number> boolean isEqual(final T numberOne, final T numberTwo) {
        return numberOne.doubleValue() == numberTwo.doubleValue();
    }

    public static <T extends Number> boolean isDifferent(final T numberOne, final T numberTwo) {
        return numberOne.doubleValue() != numberTwo.doubleValue();
    }

    public static <T extends Number> boolean isGreatOrEqual(final T numberOne, final T numberTwo) {
        return numberOne.doubleValue() >= numberTwo.doubleValue();
    }

    public static <T extends Number> boolean isLessOrEqual(final T numberOne, final T numberTwo) {
        return numberOne.doubleValue() <= numberTwo.doubleValue();
    }

    public static <T extends Number> boolean isBetween(final T number, final T initialLimit, final T finalLimit,
                                                       final boolean includeInitialLimit, final boolean includeFinalLimit) {
        return (includeInitialLimit ? isGreatOrEqual(number, initialLimit) : isGreat(number, initialLimit))
                && (includeFinalLimit ? isLessOrEqual(number, finalLimit) : isLess(number, finalLimit));
    }

    public static boolean isNullOrEmpty(final Integer value) {
        return isNull(value) || value.equals(DEFAULT_INT);
    }

    public static boolean isNullOrEmpty(final Long value) {
        return isNull(value) || value.equals(DEFAULT_LONG);
    }

    public static boolean validarRangoTelefono(final Long value) {
        return !isNull(value) && value >= MIN_PHONE_NUMBER && value <= MAX_PHONE_NUMBER;
    }
}
