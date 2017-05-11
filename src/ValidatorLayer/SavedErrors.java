package ValidatorLayer;

import java.util.HashMap;

/**
 * Created by Admin on 5/10/2017.
 */
public class SavedErrors {
    private static HashMap<String, String> errors = new HashMap<>();
    private static SavedErrors instance;

    public static SavedErrors getInstance(){
        if (instance == null) {
            instance = new SavedErrors();
        }
        return instance;
    }

    private SavedErrors(){
        setErrors();
    }

    public void setErrors(){
        errors.put("WORNG_NAME", "Must contains first name and last name in the format: \'Mike Tyson\', first name and last name must consist of only letters with length at least 4 letters and a single free space between them!");
        errors.put("WORNG_ADDRESS","Address must consists of street and number of the street in format: \'Boulevarden 101\', street must contains only letters with length at least 4 and the number must be positive!");
        errors.put("WRONG_EMAIL","Email address must contains only digits, letters, _ and - example: \'user@mail.com\'!");
        errors.put("WRONG_PHONE","Phone number must contains only digits and/or + in format: \'+45112233\'!");
        errors.put("WRONG_CITY","City my contains only letters and to be at least 3 letters long!");
        errors.put("WRONG_CVR", "The CVR must consist of exactly 8 digits!");
    }
    public HashMap<String, String> getErrors(){
        return errors;
    }
}