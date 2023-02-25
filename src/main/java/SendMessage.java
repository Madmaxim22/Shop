public class SendMessage implements Send {
    @Override
    public void send(String name, String email, String text) {
        System.out.println(name + " на вашу почту " + email + " отправлен чек покупки: " + text);
    }
}
