package notification;

public class Main {

    public static void main(String[] args) {

        NotificationFactory emailFactory = new EmailFactory();
        emailFactory.notifyUser();

        NotificationFactory smsFactory = new SMSFactory();
        smsFactory.notifyUser();

        NotificationFactory pushFactory = new PushFactory();
        pushFactory.notifyUser();
    }
}