package interview.craftsman.question5;

public class Question5Original {

    private Database database = new Database();
    private EmailService emailService = new EmailService();

    public User findById(int id) {
        try {
            return database.find(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void processUser(int id) {
        User user = findById(id);
        if (user != null) {
            if (user.getEmail() != null) {
                emailService.send(user.getEmail());
            }
        }
    }
}
