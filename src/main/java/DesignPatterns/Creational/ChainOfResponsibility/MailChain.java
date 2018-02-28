package DesignPatterns.Creational.ChainOfResponsibility;

interface Handler {

    String SPAM_MAIL="SPAM_MAIL";
    String FAN_MAIL="FAN_MAIL";
    String COMPLAINT_MAIL="COMPLAINT_MAIL";
    String NEW_LOC_MAIL="NEW_LOC_MAIL";

    void setNextChain(Handler nextChain);
    void forwardMail(Mail mailObj);
}

class Mail {

    private String subject;

    public Mail(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}

class SpamHandler implements Handler {

    private Handler chain;
    @Override
    public void setNextChain(Handler nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void forwardMail(Mail mailObj) {
		/*
		 * Checking a mail subject and forwarding to next Chain Handler.
		 */
        if(mailObj.getSubject().equalsIgnoreCase(Handler.SPAM_MAIL)){
            System.out.println("Mail Deleted.");
        }else{
            System.out.println("Not Fit with Span Dept");
            this.chain.forwardMail(mailObj);
        }
    }

}



class FanHandler implements Handler {

    private Handler chain;
    @Override

    public void setNextChain(Handler nextChain) {
        this.chain=nextChain;
    }
    @Override
    public void forwardMail(Mail mailObj) {
		/*
		 * Checking a mail subject and forwarding to next Chain Handler.
		 */
        if(mailObj.getSubject().equalsIgnoreCase(Handler.FAN_MAIL)){
            System.out.println("Forwarding Mail to CEO.");
        }else{
            System.out.println("Not Fit with Fan Dept");
            this.chain.forwardMail(mailObj);
        }

    }


}
class ComplaintHandler implements Handler {

    private Handler chain;
    @Override

    public void setNextChain(Handler nextChain) {
        this.chain=nextChain;
    }
    @Override
    public void forwardMail(Mail mailObj) {
		/*
		 * Checking a mail subject and forwarding to next Chain Handler.
		 */
        if(mailObj.getSubject().equalsIgnoreCase(Handler.COMPLAINT_MAIL)){
            System.out.println("Forwarding Mail to Legal Department.");
        }else{
            System.out.println("Not Fit with Complain Dept");
            this.chain.forwardMail(mailObj);
        }

    }

}
class NewLocHandler implements Handler {

    private Handler chain;
    @Override

    public void setNextChain(Handler nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void forwardMail(Mail mailObj) {
		/*
		 * Checking a mail subject.
		 */
        if(mailObj.getSubject().equalsIgnoreCase(Handler.NEW_LOC_MAIL)){
            System.out.println("Forwarding Mail to Business Development Group.");
        }else{
            System.out.println("Not Fit with new Local Dept");
            this.chain.forwardMail(mailObj);
        }

    }
}

public class MailChain {

    private Handler chain;

    /*
     * Forming a chain
     */
    public MailChain(){
        this.chain=new SpamHandler();

        Handler fanHandlerObj=new FanHandler();
        Handler complaingtHandlerObj=new ComplaintHandler();
        Handler newLocngtHandlerObj=new NewLocHandler();

        chain.setNextChain(fanHandlerObj);
        fanHandlerObj.setNextChain(complaingtHandlerObj);
        complaingtHandlerObj.setNextChain(newLocngtHandlerObj);

    }

    public static void main(String s[]) {

        MailChain mailChainObj =new MailChain();

		/*
		 * calling a chain with Different Subject mail
		 * Try to run the below lines one by one and see the results .
		 */
        mailChainObj.chain.forwardMail(new Mail("SPAM_MAIL"));

//        mailChainObj.chain.forwardMail(new Mail("FAN_MAIL"));

//        mailChainObj.chain.forwardMail(new Mail("COMPLAINT_MAIL"));

//        mailChainObj.chain.forwardMail(new Mail("NEW_LOC_MAIL"));

    }
}
