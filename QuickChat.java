
package com.mycompany.quickchat;

/**
 *
 * @author TSHEGOFATSO
 */
import java.util.ArrayList;
import java.util.Scanner;

class Message {
    
    String messageID;
    int messageNumber;
    String recipient;
    String message;
    String messageHash;
    
    public Message(String messageID, int messageNumber,String recipient, String message) {

        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;
        this.messageHash = createMessageHash();
    }
    // Validate Message ID
    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }
    // Validate recipient number
    public boolean checkRecipientCell() {
        return recipient.startsWith("+27") && recipient.length() <= 13;
    }
    public static void main(String[] args) {
    }
    public String createMessageHash() {

        String[] words = message.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2) + ":"
                + messageNumber + ":"
                + firstWord + lastWord;
    }
    public String SentMessage() {
        return "Message successfully sent.";
    }
    public void printMessage() {
        System.out.println("Message ID: " + messageID);
        System.out.println("Message Hash: " + messageHash);
        System.out.println("Recipient: " + recipient);
        System.out.println("Message: " + message);
    }
}
public class QuickChat {
    
    static ArrayList<Message> sentMessages = new ArrayList<>();

    public static int returnTotalMessages() {
        return sentMessages.size();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to QuickChat");

        int choice;

        do {
            System.out.println("1. Send Messages");
            System.out.println("2. Show Recently Sent Messages");
            System.out.println("3. Quit");
            System.out.print("Choose option: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("How many messages do you want to send? ");
                    int total = input.nextInt();
                    input.nextLine();

                    for (int i = 0; i < total; i++) {

                        System.out.println("\nMessage " + (i + 1));

                        System.out.print("Enter Message ID: ");
                        String id = input.nextLine();

                        System.out.print("Enter recipient number: ");
                        String recipient = input.nextLine();

                        System.out.print("Enter message: ");
                        String text = input.nextLine();

                        if (text.length() > 250) {
                            System.out.println("Please enter a message of less than 250 characters");
                                
                               continue;
                        }

                        Message msg = new Message(id, i, recipient, text);

                        // Validate ID
                        if (!msg.checkMessageID()) {
                            System.out.println("Message ID invalid");
                            continue;
                        }

                        // Validate recipient
                        if (!msg.checkRecipientCell()) {
                            System.out.println(
                                    "Cell phone number is incorrectly formatted");
                            continue;
                        }
                        System.out.println("\nChoose an option:");
                        System.out.println("1. Send Message");
                        System.out.println("2. Discard Message");
                        System.out.println("3. Store Message");

                        int option = input.nextInt();
                        input.nextLine();

                        switch (option) {
                            case 1:
                                sentMessages.add(msg);
                                System.out.println(msg.SentMessage());
                                break;
                            case 2:
                                System.out.println("Message discarded");
                                break;
                            case 3:
                                System.out.println("Message successfully stored");
                                break;
                            default:
                                System.out.println("Invalid option");
                        }
                    }
                    for (Message m : sentMessages) {
                        m.printMessage();
                    }
                    System.out.println("Total messages sent: "+ returnTotalMessages());
                    break;
                case 2:
                    System.out.println("Coming Soon.");
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 3);

        input.close();
    }
}


