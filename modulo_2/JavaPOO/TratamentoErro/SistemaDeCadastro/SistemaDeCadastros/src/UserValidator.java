public class UserValidator {

    private UserValidator(){}

    public static void VerifyModel(final UserModel model) throws ValidatorException {
        if (isStringEmpty(model.getName())) {
            throw new ValidatorException("Informe um nome válido");
        }if (model.getName().length() < 2) {
            throw new ValidatorException("O nome deve conter pelo menos 2 caracteres");
        }if (isStringEmpty(model.getEmail())) {
            throw new ValidatorException("Informe um email válido");
        }
        if (!isEmailValid(model.getEmail())) {
            throw new ValidatorException("Informe um email válido");
        }
        if (model.getDateOfBirth() == null) {
            throw new ValidatorException("Informe uma data de nascimento válida");
        }
        if (model.getDateOfBirth().isAfter(java.time.LocalDate.now())) {
            throw new ValidatorException("A data de nascimento não pode ser futura");
        }

    }

    private static boolean isStringEmpty(final String str) {
        return str == null || str.isEmpty() || str.trim().isEmpty();
    }
    
    private static boolean isEmailValid(final String email) {
        return email.contains("@") && email.contains(".");
    }
    
}
