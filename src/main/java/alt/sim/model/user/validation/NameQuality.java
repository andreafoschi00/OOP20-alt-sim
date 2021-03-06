package alt.sim.model.user.validation;

import java.util.regex.Pattern;

/**
 * Class that defines regex pattern.
 */
public final class NameQuality {

    /**
     * Only numbers and letters are accepted.
     * Length range: min 1, max 12
     */
    private final String regex = "^[A-Za-z0-9]{1,12}$";
    private final Pattern pattern = Pattern.compile(regex);
    private static final int MAX_LENGTH = 12;

    /**
     * Checks given name according to regex pattern.
     *
     * @param name to check for quality
     * @return enum value result
     */
    public NameValidation checkName(final String name) {

        final String trimmedName = name.trim();
        if (name.isBlank()) {
            return NameValidation.EMPTY;
        }

        if (name.length() > MAX_LENGTH) {
            return NameValidation.TOO_LONG;
        }

        return pattern.matcher(trimmedName).find() ? NameValidation.CORRECT : NameValidation.WRONG;
    }
}
