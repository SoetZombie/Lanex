package ValidatorLayer;

import DBLayer.DBProduct;
import Exceptions.ValidationException;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Admin on 5/10/2017.
 * Validate all the given input with the appropriate regex
 */
public class Validator {

    public static String validateName(String firstLastName) throws ValidationException {
        final String regex = "^[a-zA-Z]{4,}\\s[a-zA-Z]{4,}$";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(firstLastName);

        String result = SavedErrors.getInstance().getErrors().get("WRONG_NAME"); // get and save the specific error
        if (matcher.matches()) {
            return matcher.group(0); // take the value
        } else {
            throw new ValidationException(result);
        }
    }

    public static String validateAddress(String address) {
        final String regex = "^[a-zA-Z]{3,}\\s[0-9]+$";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(address);

        String result = SavedErrors.getInstance().getErrors().get("WRONG_ADDRESS");
        if (matcher.matches()) {
            return matcher.group(0); // take the value
        } else {
            throw new ValidationException(result);
        }
    }

    public static String validateEmail(String email) {
        final String regex = "^[a-zA-Z0-9_-]+@[a-z]+\\.[a-z]{2,3}$";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(email);

        String result = SavedErrors.getInstance().getErrors().get("WRONG_EMAIL");
        if (matcher.matches()) {
            return matcher.group(0);// take the value
        } else {
            throw new ValidationException(result);
        }
    }

    public static String validatePhone(String phone) {
        final String regex = "^\\+[0-9]{8,}$";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(phone);

        String result = SavedErrors.getInstance().getErrors().get("WRONG_PHONE");
        if (matcher.matches()) {
            return matcher.group(0); // take the value
        } else {
            throw new ValidationException(result);
        }
    }

    public static String validateCity(String city) {
        final String regex = "^[a-zA-Z]{3,}$";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(city);

        String result = SavedErrors.getInstance().getErrors().get("WRONG_CITY");
        if (matcher.matches()) {
            return matcher.group(0);// take the value
        } else {
            throw new ValidationException(result);
        }
    }

    public static int validateCVR(Integer cvr) {
        String result = SavedErrors.getInstance().getErrors().get("WRONG_CVR");

        if (cvr <= 99999999 && cvr >= 10000000) {
            return cvr;// take the value
        } else {
            throw new ValidationException(result);
        }
    }

    public static int validateWorkId(Integer work_id) {
        String result = SavedErrors.getInstance().getErrors().get("WRONG_WORK_ID");

        if (work_id <= 999999999 && work_id >= 100000000) {
            return work_id;// take the value
        } else {
            throw new ValidationException(result);
        }
    }

    public static int validateObjectSize(Integer size) {
        String result = SavedErrors.getInstance().getErrors().get("WRONG_OBJECT_SIZE");
        if (size > 0) {
            return size;
        } else {
            throw new ValidationException(result);
        }
    }
    public static double validateObjectHeight(double size) {
        String result = SavedErrors.getInstance().getErrors().get("WRONG_OBJECT_HEIGHT");
        if (size > 0) {
            return size;
        } else {
            throw new ValidationException(result);
        }
    }
    public static double validateObjectWidth(double size) {
        String result = SavedErrors.getInstance().getErrors().get("WRONG_OBJECT_WIDTH");
        if (size > 0) {
            return size;
        } else {
            throw new ValidationException(result);
        }
    }
    public static double validateObjectLength(double size) {
        String result = SavedErrors.getInstance().getErrors().get("WRONG_OBJECT_LENGTH");
        if (size > 0) {
            return size;
        } else {
            throw new ValidationException(result);
        }
    }

    public static int validateType(Integer type) {
        String result = SavedErrors.getInstance().getErrors().get("WRONG_TYPE");
        if (type > 0 && type < 5) {
            return type;
        } else {
            throw new ValidationException(result);

        }
    }

    public static int validateCurrentQuantity(Integer quantity) {
        String result = SavedErrors.getInstance().getErrors().get("WRONG_CURRENT_QUANTITY");
        if (quantity > 0) {
            return quantity;
        } else {
            throw new ValidationException(result);
        }
    }

    public static int validateMinQ(Integer quantity) {
        String result = SavedErrors.getInstance().getErrors().get("WRONG_MIN_QUANTITY");
        if (quantity > 0) {
            return quantity;
        } else {
            throw new ValidationException(result);
        }
    }
    public static int validateMaxQ(Integer quantity) {
        String result = SavedErrors.getInstance().getErrors().get("WRONG_MAX_QUANTITY");
        if (quantity > 0) {
            return quantity;
        } else {
            throw new ValidationException(result);
        }
    }

    public static int validateDailyConsumption(int currentQuantity) {
        String result = SavedErrors.getInstance().getErrors().get("WRONG_DAILY_CONSUMPTION");
        if (currentQuantity > 0) {
            return currentQuantity;
        } else {
            throw new ValidationException(result);
        }

    }
    public static String validateBarcode (String barcode)  {
        String result = SavedErrors.getInstance().getErrors().get("WRONG_BARCODE");
        final String regex = "[0-9]{1,}";

        final Pattern pattern = Pattern.compile(regex);

        final Matcher matcher = pattern.matcher(barcode);

            if(matcher.matches()) {
                return matcher.group(0);// take the value
            } else {
                throw new ValidationException(result);
            }
    }

    public static String validateProductName(String firstLastName) throws ValidationException {
        final String regex = "^\\D+";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(firstLastName);

        String result = SavedErrors.getInstance().getErrors().get("WRONG_PRODUCT_NAME"); // get and save the specific error
        if (matcher.matches()) {
            return matcher.group(0); // take the value
        } else {
            throw new ValidationException(result);
        }
    }
}
