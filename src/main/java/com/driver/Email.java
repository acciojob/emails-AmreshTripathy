package com.driver;
/*
 * @Amresh Tripathy
 */

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword) {
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if (!oldPassword.equals(password))
            return;

        if (newPassword.length() < 8)
            return;

        char[] arr = newPassword.toCharArray();
        boolean isUpperCasePresent = false;
        boolean islowercasePresent = false;
        boolean isDigitPresent = false;
        boolean isSpecialCharacterPresent = false;

        int i = 0;

        while (i < arr.length) {

            if (Character.isUpperCase(arr[i]))
                isUpperCasePresent = true;
            else if (Character.isLowerCase(arr[i]))
                islowercasePresent = true;
            else if (Character.isDigit(arr[i]))
                isDigitPresent = true;
            else
                isSpecialCharacterPresent = true;

            if (isUpperCasePresent && islowercasePresent && isDigitPresent && isSpecialCharacterPresent)
                break;

            i++;
        }

        if (isUpperCasePresent && islowercasePresent && isDigitPresent && isSpecialCharacterPresent)
            password = newPassword;
    }
}
