public class CustomValidationException extends Exception {
    public CustomValidationException(String message) { super(message);
    }

    public void ErrorMessage() { System.out.println("Error- " + getMessage());
    }
}
