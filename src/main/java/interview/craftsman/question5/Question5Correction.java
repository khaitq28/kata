package interview.craftsman.question5;

import java.util.Optional;

public class Question5Correction {

    private final Database database;

    private final  EmailService emailService;

    public Question5Correction(Database database, EmailService emailService) {
        this.database = database;
        this.emailService = emailService;
    }

    public void sendUserEmail(int userId) {
        Optional<User> user = database.findByUserId(userId);
        user.ifPresent(u -> {
            if (u.hasEmail()) {
                emailService.send(u.getEmail());
            }
        });
    }
}
