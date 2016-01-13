package test;

class SendDocument {
	  { System.out.print("In SendDocument."); }
	  public SendDocument() {
	    System.out.println("Start to send document.");
	  }
	}
	class EmailDocument extends SendDocument {
	  static {
	    System.out.println("In EmailDocument.");
	  }
	  public EmailDocument() {
	    System.out.println("Start to email document.");
	  }
	  { System.out.println("EmailDocument is in progress."); }
	  static {
	    System.out.println("EmailDocument is complete.");
	  }
	}
public	class ProcessDocument extends EmailDocument {
	  public static void main(String[] args) {
	    System.out.println("Pre process document before send.");
	    new ProcessDocument();
	    System.out.println("Document has been processed and send.");
	  }
	}