package br.edu.ifpb.biblioteca.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.edu.ifpb.biblioteca.exceptions.InvalidEmailException;

public class UserValidations {
    public static void validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new InvalidEmailException();
        }
    }
}